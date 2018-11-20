/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Amostra;
import modelos.Responsavel;
import modelos.Solicitante_Academico;

/**
 *
 * @author Heverton
 */
public class AmostraDAO implements DAO <Amostra>{
    
    private Conexao con = new Conexao();
    
    private final String INSERTAMOSTRA = "INSERT INTO AMOSTRA (IDENTIFICACAO_AMOSTRA, ID_SOLICITANTE, ID_REPONSAVEL, DESCRICAO, FRASCOS ,OBSERVACOES,DATA_ENTRADA) VALUES (?,?,?,?,?,?,?)";
    private final String UPDATEAMOSTRA = "UPDATE AMOSTRA SET IDENTIFICACAO_AMOSTRA = ?, DESCRICAO = ?,ID_SOLICITANTE = ?, ID_REPONSAVEL = ?, FRASCOS = ?, OBSERVACOES = ?, DATA_ENTRADA = ? WHERE ID_AMOSTRA = ?";
    private final String DELETEAAMOSTRA = "DELETE FROM AMOSTRA WHERE ID_AMOSTRA = ?";
    private final String LISTAMOSTRA = "SELECT * FROM AMOSTRA ORDER BY IDENTIFICACAO_AMOSTRA";
    
    /**
     *
     * @param a
     * @return
     */
    @Override
    public boolean add(Amostra a){
        
        con.conecta();
        
        try{
            
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTAMOSTRA);
            
            /* A amostra tem um solicitante e responsável, temos que crirar um objeto para ele jogar aqui na criação
               Um tipo enum também mas não vou iniciar agora
               (Tirar dúvidas na terça)
            */
            
            
            preparaInstrucao.setString(1, a.getId_amostra().toUpperCase());
            preparaInstrucao.setInt(2, a.getId_responsavel());
            preparaInstrucao.setInt(3, a.getId_solicitante());
            preparaInstrucao.setString(4, a.getDescricao().toUpperCase());
            preparaInstrucao.setInt(5, a.getFrascos());
            preparaInstrucao.setString(6, a.getObservacoes().toUpperCase());
            preparaInstrucao.setDate(7, (Date) a.getData_entrada());
       

            preparaInstrucao.execute();
            con.desconecta();
			
            return true;   
        }catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean update(Amostra a){
        
        
        try {
		
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEAMOSTRA);

			
            preparaInstrucao.setString(1, a.getId_amostra().toUpperCase());
            preparaInstrucao.setInt(2, a.getId_solicitante());
            preparaInstrucao.setInt(3, a.getId_responsavel());
            preparaInstrucao.setString(4, a.getDescricao().toUpperCase());
            preparaInstrucao.setInt(5, a.getFrascos());
            preparaInstrucao.setString(6, a.getObservacoes().toUpperCase());
            preparaInstrucao.setDate(7, (Date) a.getData_entrada());
            preparaInstrucao.setInt(8,a.getId());
            
            
            preparaInstrucao.execute();

            con.desconecta();
			
            return true;

            } catch (SQLException e) {
                System.err.println(e);
		return false;

        }
    }
    
    @Override
    public boolean remove(int idAmostra){
        
        try {
            
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEAAMOSTRA);

            preparaInstrucao.setInt(1, idAmostra);

            preparaInstrucao.execute();

            con.desconecta();
			
            return true;

            } catch (SQLException e) {
                System.err.println(e);
                return false;

        }    
    }
    
  @Override
  public ArrayList<Amostra> list(){
      
      ArrayList<Amostra> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTAMOSTRA); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Amostra a = new Amostra(
                        rs.getInt("ID_AMOSTRA"),
                        rs.getString("IDENTIFICACAO_AMOSTRA"),
                        rs.getInt("ID_REPONSAVEL"), 
                        rs.getInt("ID_SOLICITANTE"),
                        rs.getString("DESCRICAO"),
                        rs.getInt("FRASCOS"), 
                        rs.getString("OBSERVACOES"), 
                        rs.getDate("DATA_ENTRADA"));
		lista.add(a); 
                
            }
            
            con.desconecta();
            
            } catch (SQLException e) {
                System.err.println(e);
            }
            return lista;

      
  }
    
}

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
public class AmostraDAO {
    
    private Conexao con = new Conexao();
    
    private final String INSERTAMOSTRA = "INSERT INTO AMOSTRA (IDENTIFICACAO_AMOSTRA, ID_SOLICITANTE, ID_REPONSAVEL, DESCRICAO, FRACOS,OBSERVACOES,DATA_ENTRADA,TIPO_AMOSTRA) VALUES (?,?,?,?,?,?)";
    private final String UPDATEAMOSTRA = "UPDATE AMOSTRA SET IDENTIFICACAO_AMOSTRA = ? WHERE IDENTIFICACAO_AMOSTRA = ?";
    private final String DELETEAAMOSTRA = "DELETE FROM AMOSTRA WHERE IDENTIFICACAO_AMOSTRA = ?";
    private final String LISTAMOSTRA = "SELECT * FROM AMOSTRA ORDER BY IDENTIFICACAO_AMOSTRA";
    
    public boolean inserirAmostra(Amostra a){
        
        con.conecta();
        
        try{
            
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTAMOSTRA);
            
            /* A amostra tem um solicitante e responsável, temos que crirar um objeto para ele jogar aqui na criação
               Um tipo enum também mas não vou iniciar agora
               (Tirar dúvidas na terça)
            */
            
            Solicitante_Academico sa = null;
            Responsavel r = null;
            
            preparaInstrucao.setString(1, a.getId_amostra().toUpperCase());
            preparaInstrucao.setInt(2, a.getId_solicitante());
            preparaInstrucao.setInt(3, a.getId_responsavel());
            preparaInstrucao.setString(4, a.getDescricao().toUpperCase());
            preparaInstrucao.setInt(5, a.getFrascos());
            preparaInstrucao.setString(6, a.getObservacoes().toUpperCase());
            preparaInstrucao.setDate(7, (Date) a.getData_entrada());
            preparaInstrucao.setString(8, a.getId_Solicitante().toUpperCase());
            preparaInstrucao.setString(9, a.getId_Responsavel().toUpperCase());
            preparaInstrucao.setString(10, a.getAnalises_aequeridas());

            preparaInstrucao.execute();
            con.desconecta();
			
            return true;   
        }catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean updateAmostra(String identificacao, Amostra a){
        
        
        try {
		
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEAMOSTRA);

			
            preparaInstrucao.setString(1, identificacao.toUpperCase());
            preparaInstrucao.setString(2, a.getId_amostra().toUpperCase());
            
            preparaInstrucao.execute();

            con.desconecta();
			
            return true;

            } catch (SQLException e) {
		return false;

        }
    }
    
    public boolean deleteAmostra(Amostra a){
        
        try {
            
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEAAMOSTRA);

            preparaInstrucao.setString(1, a.getId_amostra().toUpperCase());

            preparaInstrucao.execute();

            con.desconecta();
			
            return true;

            } catch (SQLException e) {
                return false;

        }    
    }
    
  public ArrayList<Amostra> listarAmostra(){
      
      ArrayList<Amostra> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTAMOSTRA); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Amostra a = new Amostra(rs.getString("IDENTIFICACAO_AMOSTRA"),rs.getInt("ID_Amostra"),rs.getInt("ID_RESPONSAVEL"), rs.getString("DESCRICAO"), rs.getInt("FRASCOS"), rs.getString("OBSERVACOES"), rs.getDate("DATA_ENTRADA"), rs.getString("SOLICITANTE_ACADEMICO"), rs.getString(LISTAMOSTRA),rs.getString("TIPO_AMOSTRA"));
		lista.add(a); 
                
            }
            
            con.desconecta();
            
            } catch (SQLException e) {
            }
            return lista;

      
  }
    
}

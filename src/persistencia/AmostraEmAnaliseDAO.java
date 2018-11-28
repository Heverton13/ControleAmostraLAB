/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Amostra_Analise;

/**
 *
 * @author Heverton
 */
public class AmostraEmAnaliseDAO {
    
    private Conexao con = new Conexao();
    
    private static final String INSERTANALISEAMOSTRA = "INSERT INTO AMOSTRA_ANALISES (ID_AMOSTRAR, ID_ANALISER) VALUES (?,?);";
    private static final String UPDATEANALISEAMOSTRA = "UPDATE AMOSTRA_ANALISES SET ID_AMOSTRAR = ?, ID_ANALISER = ? WHERE ID_AMOSTRA_ANALISE = ?;";
    private static final String DELETEANALISEAMOSTRA = "DELETE FROM AMOSTRA_ANALISES WHERE ID_AMOSTRA_ANALISE = ?;";
    private static final String LISTANALISEAMOSTRA = "SELECT IDENTIFICACAO_AMOSTRA, DESCRICAO, FRASCOS, NOME_ANALISE FROM AMOSTRA_ANALISES,AMOSTRA,ANALISES WHERE ID_AMOSTRAR =  ID_AMOSTRA AND ID_ANALISER = ID_ANALISE;";


    public boolean insertAnaliseAmostra(Amostra_Analise aa){
       
        con.conecta();
       
       try{
          
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTANALISEAMOSTRA);
                   
           
            preparaInstrucao.setInt(1, aa.getId_amostra());
            preparaInstrucao.setInt(2, aa.getId_analise());
              

            preparaInstrucao.execute();
            con.desconecta();
                   
        return true;    
       }catch (SQLException e) {
           System.err.println(e);
        return false;    
      }
    }
    
    public boolean updateAnaliseAmostra(Amostra_Analise aa){
        
        try {
            
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEANALISEAMOSTRA);
		
            preparaInstrucao.setInt(1, aa.getId_amostra());
            preparaInstrucao.setInt(2, aa.getId_analise());
            preparaInstrucao.setInt(3, aa.getId_amostra_analise());
            
            preparaInstrucao.execute();
            con.desconecta();
            
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean deleteAnaliseAmostra(int id){
        
        try {
            
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEANALISEAMOSTRA);
            
            preparaInstrucao.setInt(1, id);
            
            preparaInstrucao.execute();
            con.desconecta();
            
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
    }
    
    public ArrayList<Amostra_Analise> listAnalise_Amostra(){
      
      ArrayList<Amostra_Analise> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTANALISEAMOSTRA); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Amostra_Analise a = new Amostra_Analise(       
                        rs.getString("IDENTIFICACAO_AMOSTRA"),
                        rs.getString("DESCRICAO"),
                        rs.getInt("FRASCOS"),
                        rs.getString("NOME_ANALISE"));
		lista.add(a);  
                System.out.println(lista);
            }           
            con.desconecta();
            
            } catch (SQLException e) {
                System.err.println(e);
            }
            return lista;
     
  }
    
}

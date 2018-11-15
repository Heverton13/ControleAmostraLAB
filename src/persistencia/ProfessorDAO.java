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
import modelos.Professor_Orientador;

/**
 *
 * @author Denys
 */
public class ProfessorDAO {
    
     private Conexao con = new Conexao();
     
    private final String INSERTPROFESSOR = "INSERT INTO PROFESSOR (NOME_PROFESSOR, DEPARTAMENTO, TELEFONE, EMAIL_PROFESSOR) VALUES (?,?,?,?)";
    private final String UPDATEPROFESSOR = "UPDATE PROFESSOR SET NOME_PROFESSOR = ?, DEPARTAMENTO = ?, TELEFONE = ?, EMAIL_PROFESSOR = ? WHERE ID_PROFESSOR = ?";
    private final String DELETEPROFESSOR = "DELETE FROM PROFESSOR WHERE ID_PROFESSOR = ?";
    private final String LISTPROFESSOR = "SELECT * FROM PROFESSOR ORDER BY ID_PROFESSOR";
    
    public boolean insertProfessor(Professor_Orientador p){
       con.conecta();
       
       try{
          
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTPROFESSOR);
                   
           
            preparaInstrucao.setString(1, p.getNome().toUpperCase());
            preparaInstrucao.setString(2, p.getDepartamento().toUpperCase());
            preparaInstrucao.setString(3, p.getTelefone());
            preparaInstrucao.setString(4, p.getEmail().toUpperCase());        

            preparaInstrucao.execute();
            con.desconecta();
                   
        return true;    
       }catch (SQLException e) {
           System.err.println(e);
        return false;    
      }
    }

 public boolean updateProfessor(Professor_Orientador p){
        
        try {
		
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEPROFESSOR);
		
            preparaInstrucao.setString(1, p.getNome().toUpperCase());
            preparaInstrucao.setString(2, p.getDepartamento().toUpperCase());
            preparaInstrucao.setString(3, p.getTelefone().toUpperCase());
            preparaInstrucao.setString(4, p.getEmail().toUpperCase());
            preparaInstrucao.setInt(5, p.getId_professor());
            
            preparaInstrucao.execute();
            con.desconecta();
            
            return true;
            } catch (SQLException e) {
                System.err.println(e);
		return false;

        }
    }
public boolean deleteProfessor(int id) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETEPROFESSOR);

			preparaInstrucao.setInt(1, id);

			preparaInstrucao.execute();

			con.desconecta();		
			return true;
		} catch (SQLException e) {
                    System.err.println(e);
                    return false;
                }    				
	}

 public ArrayList<Professor_Orientador> listProfessor_Orientador(){
      
      ArrayList<Professor_Orientador> lista = new ArrayList<>(); 

	try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTPROFESSOR); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Professor_Orientador a = new Professor_Orientador(
                        rs.getInt("ID_PROFESSOR"),
                        rs.getString("NOME_PROFESSOR"),
                        rs.getString("DEPARTAMENTO"), 
                        rs.getString("TELEFONE"), 
                        rs.getString("EMAIL_PROFESSOR"));
		lista.add(a);               
            }           
            con.desconecta();
            
            } catch (SQLException e) {
                System.err.println(e);
            }
            return lista;
     
  }
}
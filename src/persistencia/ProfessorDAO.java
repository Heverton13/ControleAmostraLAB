/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Professor_Orientador;

/**
 *
 * @author Denys
 */
public class ProfessorDAO {
    
     private Conexao con = new Conexao();
     
    private final String INSERTPROFESSOR = "INSERT INTO PROFESSOR (ID_PROFESSOR, NOME, DEPARTAMENTO, TELEFONE,EMAIL) VALUES (?,?,?,?,?)";
    private final String UPDATEPROFESSOR = "UPDATE PROFESSOR SET NOME = ? WHERE NOME = ?";
    private final String DELETEPROFESSOR = "DELETE FROM PROFESSOR WHERE NOME = ?";
    //private final String LISTPROFESSOR = "SELECT * FROM PROFESSOR ORDER BY NOME_PROFESSOR";
    
    public boolean insertProfessor(Professor_Orientador p){
       con.conecta();
       
       try{
          
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTPROFESSOR);
                   
            preparaInstrucao.setString(1, p.getId_professor());
            preparaInstrucao.setString(2, p.getNome().toUpperCase());
            preparaInstrucao.setString(3, p.getDepartamento().toUpperCase());
            preparaInstrucao.setString(4, p.getTelefone());
            preparaInstrucao.setString(5, p.getEmail().toUpperCase());        

            preparaInstrucao.execute();
            con.desconecta();
                   
        return true;    
       }catch (SQLException e) {
        return false;    
      }
    }

 public boolean updateAmostra(String nome, Professor_Orientador p){
        
        try {
		
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEPROFESSOR);
		
            preparaInstrucao.setString(1, nome.toUpperCase());
            preparaInstrucao.setString(2, p.getId_professor().toUpperCase());
            
            preparaInstrucao.execute();
            con.desconecta();
            
            return true;
            } catch (SQLException e) {
		return false;

        }
    }
public boolean deleteProfessor(Professor_Orientador p) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETEPROFESSOR);

			preparaInstrucao.setString(1, p.getNome());

			preparaInstrucao.execute();

			con.desconecta();		
			return true;
		} catch (SQLException e) {
                }    
			return false;	
	}
}
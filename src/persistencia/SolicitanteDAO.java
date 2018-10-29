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
import modelos.Solicitante_Academico;
/**
 *
 * @author Denys
 */
public class SolicitanteDAO {
    private final Conexao con = new Conexao();
    
        private final String INSERTSOLICITANTE = "INSERT INTO SOLICITANTE (ID_PROFESSOR, NOME_SOLICITANTE, TELEFONE, EMAIL_SOLICITANTE) VALUES (?,?,?,?)";
	private final String UPDATESOLICITANTE = "UPDATE SOLICITANTE SET ID_PROFESSOR = ?, NOME_SOLICITANTE =?, TELEFONE  = ?,EMAIL_SOLICITANTE = ?";
	private final String DELETESOLICITANTE = "DELETE FROM SOLICITANTE WHERE ID_SOLICITANTE = ?";
     // private final String LISTSOLICITANTE = "SELECT * FROM SOLICITANTE ORDER BY NOME";
        
        public boolean insertSolicitante(Solicitante_Academico s) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTSOLICITANTE);

			
                       preparaInstrucao.setInt(1, s.getId_Professor());
			preparaInstrucao.setString(2, s.getNome().toUpperCase());
			preparaInstrucao.setString(3, s.getTelefone());
                        preparaInstrucao.setString(4, s.getEmail_solicitante().toUpperCase());

			preparaInstrucao.execute();
			con.desconecta();
			
			return true;
		} catch (SQLException e) {
			return false;
		}        
}
        
public boolean updateProfessor(Solicitante_Academico s) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATESOLICITANTE);

			preparaInstrucao.setInt(1, s.getId_Professor());
                        preparaInstrucao.setString(2, s.getNome().toUpperCase());
                        preparaInstrucao.setString(3, s.getTelefone().toUpperCase());
                        preparaInstrucao.setString(4, s.getEmail_solicitante().toUpperCase());

			preparaInstrucao.execute();
			con.desconecta();			
			return true;

		} catch (SQLException e) {
			return false;

		}
	}
public boolean deleteAutor(int idSolicitante) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETESOLICITANTE);

			preparaInstrucao.setInt(1,  idSolicitante);
			preparaInstrucao.execute();

			con.desconecta();			
			return true;
		} catch (SQLException e) {
                    return false;
                	}	                    		
	}
 /* public ArrayList<Solicitante_Academico> listSolicitante(){
     
      ArrayList<Solicitante_Academico> lista = new ArrayList<>(); 
	try {			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTSOLICITANTE); 			
            ResultSet rs = preparaInstrucao.executeQuery(); 			
            while (rs.next()) {        
                Solicitante_Academico a = new Solicitante_Academico(rs.getInt("ID_SOLICITANTE"),rs.getString("NOME"),rs.getInt("ID_PROFESSOR"), rs.getString("TELEFONE"),rs.getString("EMAIL_SOLICITANTE"));
		lista.add(a);               
            }           
            con.desconecta();          
            } catch (SQLException e) {
            }
            return lista;
     
  } */
}
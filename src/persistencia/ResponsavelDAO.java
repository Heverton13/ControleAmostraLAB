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
import modelos.Responsavel;

/**
 *
 * @author Denys
 */
public class ResponsavelDAO {
    
    private final Conexao con = new Conexao();
    
        private final String INSERTRESPONSAVEL = "INSERT INTO RESPONSAVEL (NOME_RESPONSAVEL, DATA_RECEBIMENTO, HORA, ASSINATURA) VALUES (?,?,?,?)";
	private final String UPDATERESPONSAVEL = "UPDATE RESPONSAVEL SET NOME_RESPONSAVEL = ?, DATA_RECEBIMENTO = ?, HORA = ?, ASSISNATURA = ? WHERE ID_REPONSAVEL = ?";
	private final String DELETERESPONSAVEL = "DELETE FROM RESPONSAVEL WHERE ID_RESPONSAVEL = ?";
        private final String LISTRESPONSAVEL = "SELECT * FROM RESPONSAVEL ORDER BY NOME";
        
        public boolean insertResponsavel(Responsavel r) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTRESPONSAVEL);

			
                        preparaInstrucao.setString(1, r.getNome().toUpperCase());
			preparaInstrucao.setDate(2, new java.sql.Date(r.getData().getTime()));
                        preparaInstrucao.setTime(3, r.getHora());
			preparaInstrucao.setString(4, r.getAssinatura().toUpperCase());

			preparaInstrucao.execute();

			con.desconecta();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
    public boolean updateResponsavel(Responsavel r) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATERESPONSAVEL);
                        
			preparaInstrucao.setString(1, r.getNome().toUpperCase());
			preparaInstrucao.setDate(2, (Date) r.getData());
                        preparaInstrucao.setTime(3, r.getHora());
                        preparaInstrucao.setString(4, r.getAssinatura().toUpperCase());
                        preparaInstrucao.setInt(5, r.getId_responsavel());
			preparaInstrucao.execute();

			con.desconecta();
			
			return true;
		} catch (SQLException e) {
			return false;

		}
	}    
        
    public boolean deleteResponsavel(int idResponsavel) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETERESPONSAVEL);

			preparaInstrucao.setInt(1, idResponsavel);

			preparaInstrucao.execute();

			con.desconecta();
			
			return true;

		} catch (SQLException e) {
                   return false;	 
                }	              
	}
    
    public ArrayList<Responsavel> listResponsavel(){
      
      ArrayList<Responsavel> lista = new ArrayList<>(); 

	try {			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTRESPONSAVEL); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Responsavel a = new Responsavel(rs.getInt("ID_RESPONSAVEL"),rs.getString("NOME"),rs.getDate("DATA"), rs.getTime("HORA"), rs.getString("ASSINATURA"));
		lista.add(a);               
            }           
            con.desconecta();          
            } catch (SQLException e) {
            }
            return lista;
     
  }
}

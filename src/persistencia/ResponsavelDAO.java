/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Responsavel;

/**
 *
 * @author Denys
 */
public class ResponsavelDAO {
    
    private final Conexao con = new Conexao();
    
        private final String INSERTRESPONSAVEL = "INSERT INTO RESPONSAVEL (ID_RESPONSABEL, ID_AMOSTRA, NOME_RESPONSAVEL, DATA_RECEBIMENTO, HORA, ASSINATURA) VALUES (?,?,?,?,?,?)";
	private final String UPDATERESPONSAVEL = "UPDATE RESPONSAVEL SET NOME_RESPONSAVEL = ? WHERE NOME_RESPONSAVEL = ?";
	private final String DELETERESPONSAVEL = "DELETE FROM RESPONSAVEL WHERE NOME_RESPONSAVEL = ?";
    
        public boolean insertAutor(Responsavel r) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(INSERTRESPONSAVEL);

			preparaInstrucao.setString(1, r.getId_responsavel().toUpperCase());
			preparaInstrucao.setString(2, r.getId_amostra().toUpperCase());
                        preparaInstrucao.setString(3, r.getNome().toUpperCase());
			preparaInstrucao.setDate(4, (Date) r.getData());
                        preparaInstrucao.setTime(5, r.getHora());
			preparaInstrucao.setString(6, r.getAssinatura().toUpperCase());

			preparaInstrucao.execute();

			con.desconecta();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
    public boolean updateResponsavel(String nome, Responsavel r) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(UPDATERESPONSAVEL);
			preparaInstrucao.setString(1, nome.toUpperCase());
			preparaInstrucao.setString(2, r.getNome().toUpperCase());
			preparaInstrucao.execute();

			con.desconecta();
			
			return true;
		} catch (SQLException e) {
			return false;

		}
	}    
        
    public boolean deleteResponsavel(Responsavel r) {
		try {
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(DELETERESPONSAVEL);

			preparaInstrucao.setString(1, r.getNome().toUpperCase());

			preparaInstrucao.execute();

			con.desconecta();
			
			return true;

		} catch (SQLException e) {
		}	
                return false;	
	}
}

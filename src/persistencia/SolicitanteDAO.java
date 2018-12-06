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
import modelos.Solicitante_Academico;

/**
 *
 * @author Denys
 */
public class SolicitanteDAO {

    private final Conexao con = new Conexao();

    private final String INSERTSOLICITANTE = "INSERT INTO SOLICITANTE (ID_PROFESSOR, NOME_SOLICITANTE, TELEFONE, EMAIL_SOLICITANTE) VALUES (?,?,?,?)";
    private final String UPDATESOLICITANTE = "UPDATE SOLICITANTE SET ID_PROFESSOR = ?, NOME_SOLICITANTE = ?, TELEFONE  = ?, EMAIL_SOLICITANTE = ? WHERE ID_SOLICITANTE = ?";
    private final String DELETESOLICITANTE = "DELETE FROM SOLICITANTE WHERE ID_SOLICITANTE = ?";
    private final String LISTSOLICITANTE = "SELECT * FROM SOLICITANTE ORDER BY ID_SOLICITANTE";

    public boolean insertSolicitante(Solicitante_Academico s) {
        try {
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTSOLICITANTE);

            preparaInstrucao.setInt(1, s.getProfessor().getId_professor()); //Uso isso para adicionar o ID do objeto
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

    public boolean updateSolicitante(Solicitante_Academico s) {
        try {
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATESOLICITANTE);

            preparaInstrucao.setInt(1, s.getId_Professor());
            preparaInstrucao.setString(2, s.getNome().toUpperCase());
            preparaInstrucao.setString(3, s.getTelefone().toUpperCase());
            preparaInstrucao.setString(4, s.getEmail_solicitante().toUpperCase());
            preparaInstrucao.setInt(5, s.getId_solicitante());

            preparaInstrucao.execute();
            con.desconecta();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteSolicitante(int idSolicitante) {
        try {
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETESOLICITANTE);

            preparaInstrucao.setInt(1, idSolicitante);
            preparaInstrucao.execute();

            con.desconecta();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public Solicitante_Academico findById(int id) {
        
        con.conecta();
        
        Solicitante_Academico usuario = new Solicitante_Academico();
        String query = "SELECT * FROM SOLICITANTE WHERE ID_SOLICITANTE = ?;";
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                String nome = rs.getString("NOME_SOLICITANTE");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL_SOLICITANTE");

                usuario.setNome(nome);
                usuario.setTelefone(telefone);
                usuario.setEmail_solicitante(email);

            }

        } catch (SQLException e) {
            System.err.println("Erro ao procurar usuario: " + id + e.getMessage());
        } finally {
            con.desconecta();
        }
        return usuario;
    }


    public ArrayList<Solicitante_Academico> listSolicitante() {

        ArrayList<Solicitante_Academico> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTSOLICITANTE);
            ResultSet rs = preparaInstrucao.executeQuery();
            ProfessorDAO profDAO = new ProfessorDAO();
            while (rs.next()) {
                Professor_Orientador prof = profDAO.findById(rs.getInt("ID_PROFESSOR"));
                Solicitante_Academico a = new Solicitante_Academico(
                        rs.getInt("ID_SOLICITANTE"),
                        prof,
                        rs.getString("NOME_SOLICITANTE"),
                        rs.getString("TELEFONE"),
                        rs.getString("EMAIL_SOLICITANTE"));
                lista.add(a);
            }
            con.desconecta();
        } catch (SQLException e) {
        }
        return lista;

    }
}

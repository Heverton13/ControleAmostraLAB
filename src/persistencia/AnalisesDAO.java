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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Analises;

/**
 *
 * @author Heverton
 */
public class AnalisesDAO {
    
    private Conexao con = new Conexao();
    
    private final static String PREENCHERANALISES =
            "INSERT INTO ANALISES(NOME_ANALISE) VALUES ('UMIDADE'),\n" +
            "  ('MATERIA_SECA'),\n" +
            "  ('MATERIA_MINERAL'),\n" +
            "  ('EXTRATO_ETEREO'),\n" +
            "  ('PROTEINA_BRUTA'),\n" +
            "  ('FIBRA_EM_DERTERGENTE_ACIDO'),\n" +
            "  ('FIBRA_EM_DERTEGENTE_NEUTRO'),\n" +
            "  ('PROTEINA_INSULUVEL_EM_DETERGENTE_NEUTRO'),\n" +
            "  ('PROTEINA_INSULUVEL_EM_DETERGENTE_ACIDO'),\n" +
            "  ('CARBOIDRATOS_TOTAIS'),\n" +
            "  ('CARBOIDRATOS_NAO_FIBROSOS'),\n" +
            "  ('CELULOSE'),\n" +
            "  ('HEMICELULOSE'),\n" +
            "  ('ENERGIA_DISGESTIVEL'),\n" +
            "  ('NUTRIENTES_DIGESTIVOS_TOTAIS');";
    private static final String LISTANALISES = "SELECT * FROM ANALISES ORDER BY ID_ANALISE";
    
    public boolean preencherAnalises(){
        con.conecta();
        
        PreparedStatement preparaInstrucao;
        
        try {
            preparaInstrucao = con.getConexao().prepareStatement(PREENCHERANALISES);
            preparaInstrucao.execute();
            con.desconecta();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AnalisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public ArrayList<Analises> listarAnalise(){
        
        ArrayList<Analises>  lista = new ArrayList<>();
        
        try {
			
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTANALISES); 
			
            ResultSet rs = preparaInstrucao.executeQuery(); 
			
            while (rs.next()) { 
                
                Analises a = new Analises(
                        rs.getInt("ID_ANALISE"),
                        rs.getString("NOME_ANALISE"));
                        
		lista.add(a);               
            }           
            con.desconecta();
            
            } catch (SQLException e) {
            }
            return lista;

        
    }
    
}

    
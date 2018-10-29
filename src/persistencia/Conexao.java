/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Amostra;
import modelos.Professor_Orientador;
import modelos.Responsavel;
import modelos.Solicitante_Academico;

/**
 *
 * @author Heverton
 */
public class Conexao {
    
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgre";
    /* No caminho devemos usar(criar) um banco com nome: labnutricao
       Além disso devemos utilizar o localhost que está sendo usado no 
       postgre na máquina exemplo localhost:5432 ou localhost:5433 ou qualquer outro, sempre verificar
       o mesmo vale para p usuário e senha postados acima.
    */
    private static final String CAMINHO = "jdbc:postgresql://localhost:5432/labnutricao";
    private static final String DRIVER = "org.postgresql.Driver";
   
    private Connection conexao;
    
    public void conecta(){
        
        System.out.println("Com conexao a: " +  CAMINHO);
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(CAMINHO, USUARIO,SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }      
    }
    
    public void desconecta(){
        
        try {
            conexao.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public Connection getConexao(){
        return conexao;
    }
    
    /*
    public static void main(String[] args) throws ParseException {
        Conexao con = new Conexao();
        
        AmostraDAO ata = new AmostraDAO();
        SolicitanteDAO sa = new SolicitanteDAO();
        ProfessorDAO pa = new ProfessorDAO();
        
        
        Professor_Orientador p2 = new Professor_Orientador(1,"Procopio", "Matemática", "99443344", "procopio@gmail.com");
        Solicitante_Academico ss = new Solicitante_Academico(1,1, "Heverton Gomes", "92544455", "evolui@gmail.com");
        
        sa.insertSolicitante(ss);
        
        //GET Values datepicker retornar um local date - transformar local date
        
        //Amostra a = new Amostra("AAA", 2,1,"TESTE", 2, "fff", data_entrada, "sss");
    }

    */
    
}

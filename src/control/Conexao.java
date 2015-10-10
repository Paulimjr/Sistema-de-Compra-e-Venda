/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Cesar
 */
public class Conexao {
   private String exo;
    public Statement stmt;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/sistema";
    private String usuario = "postgres";
    private String senha = "123";
    private static Connection conexao;
    
    public Conexao()
    {
       try {
           System.setProperty("jdbc.Drivers", driver);
           conexao = DriverManager.getConnection(caminho,usuario, senha);
       } catch (SQLException ex){
           JOptionPane.showMessageDialog(null,"Erro ao conectar: "+ex.getMessage());
       }
    }
    public void desconecta()
    {
       try {
           conexao.close();
       } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao desconectar: "+ex.getMessage());
       }
    }
    public Connection getConexao()
    {
        return conexao;
    }

}

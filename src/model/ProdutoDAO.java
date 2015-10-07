/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import model.InterfaceDAO;
import model.Produto;

/**
 *
 * @author Paulo Cesar
 */
public class ProdutoDAO implements InterfaceDAO<Produto>{
    
    List<Produto> produtos = new ArrayList<>();
    Conexao conexao = new Conexao();
    @Override
    public int insert(Produto obj) throws SQLException {
      String sql = "insert into produto(produto,valorc,valorv,tipo,descricao) values(?,?,?,?,?)";
      try{
          PreparedStatement psmt = conexao.getConexao().prepareStatement(sql);
          psmt.setString(1, obj.getNome());
          psmt.setDouble(2, obj.getValorc());
          psmt.setDouble(3, obj.getValorv());
          psmt.setString(4, obj.getTipo());
          psmt.setString(5, obj.getDescricao());
          int salvo = psmt.executeUpdate();
          return 1;
      }catch(SQLException e)
      {
          JOptionPane.showMessageDialog(null,"Erro ao gravar, esse produo já deve conter no estoque");
          return 0;
      }
    }

    @Override
    public List<Produto> list() {
       return null;
    }

    @Override
    public boolean update(Produto obj) {
       String atualiza = "update produto set produto = ? , valorc = ? , valorv = ? , tipo = ? , descricao = ?  where codigo='"+obj.getCod()+"'"; 
        try{
          PreparedStatement psmt = conexao.getConexao().prepareStatement(atualiza);
          psmt.setString(1, obj.getNome());
          psmt.setDouble(2, obj.getValorc());
          psmt.setDouble(3, obj.getValorv());
          psmt.setString(4, obj.getTipo());
          psmt.setString(5, obj.getDescricao());
          psmt.execute();
          psmt.close();
           
           return true;
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
       }
       return false;
    }


    @Override
    public Produto find(Produto obj) throws SQLException {
        try{
        Produto pd = new Produto();
        String sql = "select * from produto where codigo = '"+obj.getCod()+"'";
        Statement st = conexao.getConexao().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            pd.setCod(rs.getInt("codigo"));
            pd.setNome(rs.getString("produto"));
            pd.setDescricao(rs.getString("descricao"));
            pd.setValorv(Float.parseFloat(rs.getString("valorv")));
            pd.setValorc(Float.parseFloat(rs.getString("valorc")));
            pd.setTipo(rs.getString("tipo"));
        return (Produto) pd;
        }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
        return null; 
    }

    @Override
    public boolean delete(Produto obj) throws SQLException {
         try{
          Statement stmt = conexao.getConexao().createStatement();
          JOptionPane.showMessageDialog(null, "Codigo para remover: "+obj.getCod());
          String query = "delete from produto where codigo ='"+obj.getCod()+"'";
          stmt.executeUpdate(query);
          return true;
      }catch(SQLException e){
              JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage()); 
      }
      return false;
    }
  
}

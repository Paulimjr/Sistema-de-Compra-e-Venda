package model;

import control.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO implements InterfaceDAO<Cliente>{
    Conexao conexao = new Conexao();
    @Override
    public int insert(Cliente obj){
        int registros;
            try(PreparedStatement pstmt = conexao.getConexao().prepareStatement("INSERT INTO cliente (nome,endereco,cpf,rg,cidade,bairro,estado,telefone,celular,complemento,dataDeCadastro,dataAtualizacao,numero,cep) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"))
               {
                pstmt.setString(1, obj.getNome().toUpperCase());
                pstmt.setString(2, obj.getEndereco());
                pstmt.setString(3, obj.getCpf());
                pstmt.setString(4, obj.getRg());
                pstmt.setString(5, obj.getCidade());
                pstmt.setString(6, obj.getBairro());
                pstmt.setString(7, obj.getEstado());
                pstmt.setString(8, obj.getTelefone());
                pstmt.setString(9, obj.getCelular());
                pstmt.setString(10, obj.getComplemento());
                pstmt.setString(11, obj.getDataDeCadastro());
                pstmt.setString(12, obj.getDataAtualizacao());
                pstmt.setString(13,obj.getNumero());
                pstmt.setString(14, obj.getCep());
                registros = pstmt.executeUpdate();
                return 1;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Você já deve estar cadastrado.");
        }
    return 0;
    }
    @Override
    public List<Cliente>list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cliente obj) {
        try{
          Statement stmt = conexao.getConexao().createStatement();
          JOptionPane.showMessageDialog(null, "Codigo para remover: "+obj.getCodigo());
          String query = "delete from cliente where codigo ='"+obj.getCodigo()+"'";
          stmt.executeUpdate(query);
          return true;
      }catch(SQLException e){
              JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage()); 
      }
      return false;
    }
    @Override
    public boolean update(Cliente obj) {
     String query = "update cliente set nome = ? , endereco = ? ,dataAtualizacao = ? , cep = ? , bairro = ? ,complemento = ? , cidade = ? , estado = ? , telefone = ? , celular = ? , numero = ? where codigo = '"+obj.getCodigo()+"'";
        try{
          PreparedStatement pstmt = conexao.getConexao().prepareStatement (query);
            pstmt.setString(1, obj.getNome().toUpperCase());
            pstmt.setString(2, obj.getEndereco());
            pstmt.setString(7, obj.getCidade());
            pstmt.setString(5, obj.getBairro());
            pstmt.setString(8, obj.getEstado());
            pstmt.setString(9, obj.getTelefone());
            pstmt.setString(10, obj.getCelular());
            pstmt.setString(6, obj.getComplemento());
            pstmt.setString(3, obj.getDataAtualizacao());
            pstmt.setString(11,obj.getNumero());
            pstmt.setString(4, obj.getCep());          
          pstmt.execute();
          pstmt.close();
          return true;
      }catch(SQLException e){
              JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage()); 
      }
      return false;
    }

    @Override
    public Cliente find(Cliente obj){
        
    try{
        Cliente cli = new Cliente();
        String sql = "select * from cliente where cpf = '"+obj.getCpf()+"'";
        Statement st = conexao.getConexao().createStatement();
        ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
            cli.setCodigo(rs.getInt("codigo"));
            cli.setNome(rs.getString("nome"));
            cli.setEndereco(rs.getString("endereco"));
            cli.setEstado(rs.getString("estado"));
            cli.setNumero(rs.getString("numero"));
            cli.setCidade(rs.getString("cidade"));
            cli.setCpf(rs.getString("cpf"));
            cli.setRg(rs.getString("rg"));
            cli.setComplemento(rs.getString("complemento"));
            cli.setCep(rs.getString("cep"));
            cli.setBairro(rs.getString("bairro"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setCelular(rs.getString("celular"));
            cli.setDataDeCadastro(rs.getString("dataDeCadastro"));

        }               
           return (Cliente)cli;
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
    }
        return null;
    }

}

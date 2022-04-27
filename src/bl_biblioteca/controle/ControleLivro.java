/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.controle;

import bl_biblioteca.modelo.ModeloLivro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControleLivro {

    ConectaBanco conecta = new ConectaBanco();

    public void inserirLivro(ModeloLivro mod) {
        conecta.conexao();
        
        try {
        
                PreparedStatement pst = conecta.conn.prepareStatement("insert into single.livro "
                        + " (titulo, area, autor, editora, volume, serie, ano_publicacao) "
                        + "values (?,?,?,?,?,?,?)");

                pst.setString(1, mod.getTitulo());
                pst.setInt(2, mod.getArea());
                pst.setInt(3, mod.getAutor());
                pst.setInt(4, mod.getEditora());
                pst.setInt(5, mod.getVolume());
                pst.setString(6, mod.getSerie());
                pst.setInt(7, mod.getAno_publicacao());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados! \nERRO: " + e);
        }
        conecta.desconectar();
    }

    public void excluirLivro(ModeloLivro mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from single.livro where registro=? ");
            pst.setInt(1, mod.getRegistro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados! \n ERRO:" + ex);
        }
        conecta.desconectar();
    }

    /*
     consultarRegistro verifica se o registro esta armazenado no banco, ele retorna um valor booleano.
     true -> registro existe no banco
     false -> registro não existe no banco
     */
    public void consultarRegistro(ModeloLivro mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("select * from single.livro where registro=?");
            pst.setInt(1, mod.getRegistro());
            pst.execute();
            ResultSet rs = pst.getResultSet();
            if (rs.next()) {
               // JOptionPane.showMessageDialog(null, "_________EXITE______!" );
                mod.setContem(true);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados! \n ERRO:" + ex);
        }
        conecta.desconectar();
    }

    public void alteraLivro(ModeloLivro mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update single.livro set titulo=?, area=?, autor=?, "
                    + "editora=?, volume=?, serie=?, ano_publicacao=? where registro=?");

            pst.setString(1, mod.getTitulo());
            pst.setInt(2, mod.getArea());
            pst.setInt(3, mod.getAutor());
            pst.setInt(4, mod.getEditora());
            pst.setInt(5, mod.getVolume());
            pst.setString(6, mod.getSerie());
            pst.setInt(7, mod.getAno_publicacao());
            pst.setInt(8, mod.getRegistro());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados! \n ERRO:" + ex);
        }
        conecta.desconectar();
    }
    
}
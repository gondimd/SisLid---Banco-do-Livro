/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.controle;

import bl_biblioteca.modelo.ModeloAutor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControleAutor {
    
    ConectaBanco conecta = new ConectaBanco();
    
    public void inserirAutor(ModeloAutor mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into single.autor "
                    + "( nome) values (?)");
            pst.setString(1, mod.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados! \n ERRO: " + e);
        }
        conecta.desconectar();
    }
    
        public void excluirAutor(ModeloAutor mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from single.autor where nome=? ");
            //pst.setInt(1, mod.getCodigo());
            pst.setString(1, mod.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados! \n ERRO: ");
        }
        conecta.desconectar();
    }

    public void alteraAutor(ModeloAutor mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update single.autor set nome=? where codigo =? ");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!");
        }
        conecta.desconectar();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.controle;

import bl_biblioteca.modelo.ModeloEditora;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControleEditora {

    ConectaBanco conecta = new ConectaBanco();

    public void inserirEditora(ModeloEditora mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into single.editora "
                    + "( nome, local) values (?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getLocal());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados! \nERRO: " + e);
        }
        conecta.desconectar();
    }

    public void excluirEditora(ModeloEditora mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from single.editora where nome=? ");
            pst.setString(1, mod.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados! \n ERRO:" + ex);
        }
        conecta.desconectar();
    }

    public void alteraEditora(ModeloEditora mod) {
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update single.editora set nome=? , local =? where codigo=?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getLocal());
            pst.setInt(3, mod.getCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados! \n ERRO:" + ex);
        }
        conecta.desconectar();
    }
}

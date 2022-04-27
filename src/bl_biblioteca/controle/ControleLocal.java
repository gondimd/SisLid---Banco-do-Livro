/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.controle;

import bl_biblioteca.modelo.ModeloLocal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControleLocal {

    ConectaBanco conecta = new ConectaBanco();

    public void inserirLocal(ModeloLocal mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into single.local "
                    + "( cidade, estado_sigla) values (?,?)");
            pst.setString(1, mod.getCidade());
            pst.setString(2, mod.getEstado_sigla());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!");
        }
        conecta.desconectar();
    }

    public void excluirLocal(ModeloLocal mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from single.local where cidade=? ");
            pst.setString(1, mod.getCidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!");
        }
        conecta.desconectar();
    }

    public void alteraLocal(ModeloLocal mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update single.local set cidade = ?, estado_sigla=? where codigo = ? ");
            pst.setString(1, mod.getCidade());
            pst.setString(2, mod.getEstado_sigla());
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar! \n ERRO:" + ex);
        }
        conecta.desconectar();
    }
}
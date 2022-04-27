/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.controle;

import bl_biblioteca.modelo.ModeloArea;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControleArea {

    ConectaBanco conecta = new ConectaBanco();

    public void inserirArea(ModeloArea mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into single.area "
                    + "( nome) values (?)");
            pst.setString(1, mod.getArea());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados! \nERRO: " +e);
        }     
        conecta.desconectar();
    }

    public void excluirArea(ModeloArea mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from single.area where codigo=? ");
            pst.setInt(1, mod.getCodigo());
            // pst.setString(2, mod.getArea());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados! \n ERRO:"+ex);
        }
        conecta.desconectar();
    }

    public void alteraCidade(ModeloArea mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update single.area set nome=? where codigo=?");
            pst.setString(1, mod.getArea());
            pst.setInt(2, mod.getCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados! \n ERRO:"+ex);
        }
        conecta.desconectar();
    }
}

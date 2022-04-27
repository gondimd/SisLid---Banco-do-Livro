/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.controle;

import bl_biblioteca.modelo.ModeloEmprestimo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControleEmprestimo {

    ConectaBanco conectaEmprestimo = new ConectaBanco();
  //  ConectaBanco conectaItem = new ConectaBanco();

    public void realizarEmprestimo(ModeloEmprestimo mod) {
        conectaEmprestimo.conexao();
      //  conectaItem.conexao();

        try {

            PreparedStatement pstEmprestimo = conectaEmprestimo.conn.prepareStatement("insert into single.emprestimo "
                    + " (atendente, users, exemplar, data_hora, status) "
                    + "values (?,?,?,?,?)");
            pstEmprestimo.setInt(1, mod.getAtendente());
            pstEmprestimo.setInt(2, mod.getUsers());
            pstEmprestimo.setInt(3, mod.getExemplar());
            // seta a data e hora atual do sistema
            pstEmprestimo.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pstEmprestimo.setBoolean(5, true);
            pstEmprestimo.execute();
            
            JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar o empréstimo! \nERRO: " + ex);
        }
        conectaEmprestimo.desconectar();
        //conectaItem.desconectar();
    }
   
    // este metodo é utilizado para realizar a devolucao de livros, altera o campo emprestado para FALSE
    public void devolverExemplar(ModeloEmprestimo mod) {
        conectaEmprestimo.conexao();
        try {
            PreparedStatement pst = conectaEmprestimo.conn.prepareStatement("update single.emprestimo set status=? where exemplar=?");
            pst.setBoolean(1, false);
            pst.setInt(2, mod.getExemplar());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao devolver o livro! \n ERRO:" + ex);
        }
        conectaEmprestimo.desconectar();
    }
}

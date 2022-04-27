package bl_biblioteca.controle;

import bl_biblioteca.modelo.ModeloExemplar;
import bl_biblioteca.modelo.ModeloEmprestimo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControleExemplar {

    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco conectaEmprestimo = new ConectaBanco();

    public void inserirExemplar(ModeloExemplar mod) {
        conecta.conexao();
        int cont = mod.getQuant();
        try {
            while (cont > 0) {

                PreparedStatement pst = conecta.conn.prepareStatement("insert into single.exemplar "
                        + " (data_entrada, livro) "
                        + "values (?,?)");

                pst.setDate(1, mod.getData_entrada());
                pst.setInt(2, mod.getLivro());
                pst.execute();
                cont--;
                if (cont == 0) {
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados! \nERRO: " + e);
        }
        conecta.desconectar();
    }

    public void excluirExemplar(ModeloExemplar mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from single.exemplar where registro=? ");
            pst.setInt(1, mod.getRegistro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados! "
                                                 + "\n Não é permitido excluir um exemplar que está emprestado ou já foi emprestado."
                                                 + "\n ERRO:" + ex);
        }
        conecta.desconectar();
    }

    public void efetuarBaixa(ModeloEmprestimo mod) {
        // Atenção vc só consegue dar baixa no livro se o livro não estiver emprestado
        conectaEmprestimo.conexao();
        try {
            PreparedStatement pst = conectaEmprestimo.conn.prepareStatement("update single.exemplar set data_saida=? where registro=?");
            pst.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            pst.setInt(2, mod.getExemplar());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Baixa efetuada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar baixa do livro! \n ERRO:" + ex);
        }
        conectaEmprestimo.desconectar();
    }

    public ModeloExemplar buscarTitulo(ModeloExemplar modExemplar) {
        conecta.conexao();
        try {
            conecta.executaSQL("SELECT * FROM single.exemplar INNER JOIN"
                    + " single.livro on single.exemplar.livro = single.livro.registro "
                    + "where single.livro.titulo ~* '" + modExemplar.getPesquisa() + "'");
            conecta.rs.first();
            modExemplar.setTitulo(conecta.rs.getString("titulo"));
            modExemplar.setRegistro(conecta.rs.getInt("registro"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o exemplar! \nErro: " + ex);
        }
        conecta.desconectar();
        return modExemplar;
    }
}

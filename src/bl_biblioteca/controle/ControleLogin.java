/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.controle;
import bl_biblioteca.modelo.ModeloAtendente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControleLogin {

    ConectaBanco conectaLogin = new ConectaBanco();
    ModeloAtendente modLogin = new ModeloAtendente();
    
    public void salvar(ModeloAtendente mod){
        conectaLogin.conexao();
        try {
            PreparedStatement pst = conectaLogin.conn.prepareStatement("insert into single.atendente (nome, login, senha, permissao) values (?,?,md5(?),?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.setString(4, mod.getPermissao());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro de usuário efetuado com sucesso");
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar o cadastro de usuário \nERRO:"+ ex);
        }
        conectaLogin.desconectar();
    }
    
    public ModeloAtendente primeiro (){
        conectaLogin.conexao();
        try {
            conectaLogin.executaSQL("SELECT * from single.atendente");
            conectaLogin.rs.first();
            modLogin.setId(conectaLogin.rs.getInt("id"));
            modLogin.setLogin(conectaLogin.rs.getString("login"));
            modLogin.setNome(conectaLogin.rs.getString("nome"));
            modLogin.setPermissao(conectaLogin.rs.getString("permissao"));
            modLogin.setSenha(conectaLogin.rs.getString("senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir o primeiro registro!\n Erro: "+ex);
        }
        return modLogin;
    }
    
    public ModeloAtendente anterior (){
        
        try {
            conectaLogin.rs.previous();
            modLogin.setId(conectaLogin.rs.getInt("id"));
            modLogin.setLogin(conectaLogin.rs.getString("login"));
            modLogin.setNome(conectaLogin.rs.getString("nome"));
            modLogin.setPermissao(conectaLogin.rs.getString("permissao"));
            modLogin.setSenha(conectaLogin.rs.getString("senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir o primeiro registro!\n Erro: "+ex);
        }
        return modLogin;
    }
    
    public ModeloAtendente proximo (){
        
        try {
            conectaLogin.rs.next();
            modLogin.setId(conectaLogin.rs.getInt("id"));
            modLogin.setLogin(conectaLogin.rs.getString("login"));
            modLogin.setNome(conectaLogin.rs.getString("nome"));
            modLogin.setPermissao(conectaLogin.rs.getString("permissao"));
            modLogin.setSenha(conectaLogin.rs.getString("senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir o primeiro registro!\n Erro: "+ex);
        }
        return modLogin;
    }
    
    public ModeloAtendente ultimo (){
        conectaLogin.conexao();
        try {
            conectaLogin.executaSQL("SELECT * from single.atendente");
            conectaLogin.rs.last();
            modLogin.setId(conectaLogin.rs.getInt("id"));
            modLogin.setLogin(conectaLogin.rs.getString("login"));
            modLogin.setNome(conectaLogin.rs.getString("nome"));
            modLogin.setPermissao(conectaLogin.rs.getString("permissao"));
            modLogin.setSenha(conectaLogin.rs.getString("senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir o ultimo registro!\n Erro: "+ex);
        }
        return modLogin;
    }
    
    public void excluir(ModeloAtendente mod){
        conectaLogin.conexao();
        try {
            PreparedStatement pst = conectaLogin.conn.prepareStatement("delete from single.atendente where id = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a exclusão de um usuário \nERRO:"+ ex);
        }
        conectaLogin.desconectar();
    }
    
    public void alterar(ModeloAtendente mod){
        conectaLogin.conexao();
        try {
            PreparedStatement pst = conectaLogin.conn.prepareStatement("update single.atendente set nome=? , login=?, senha=md5(?), permissao=? where id =?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.setString(4, mod.getPermissao());
            pst.setInt(5, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar as informações. \nERRO:"+ ex);
        }
        conectaLogin.desconectar();
   
    }
  
}

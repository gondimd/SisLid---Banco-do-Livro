
package bl_biblioteca.controle;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConectaBanco {
    
    public Statement stm; //responsavel por preparar e realizar pesquisas no banco
    public ResultSet rs; // armazena o resultado da pesquisa
    private String driver = "org.postgresql.Driver"; //driver responsavel por identificar qual serviço de BD a ser usada
    private String caminho = "jdbc:postgresql://localhost:5432/biblivre4"; // seta o local do banco de dados
    private String usuario = "postgres";
    private String senha = "abracadabra";
    public Connection conn;
    
    public void conexao(){ // realiza conexão com banco
        
        try {
            // usando a conexao do tipo jdbc e o driver de conexão
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
           // JOptionPane.showMessageDialog(null, "Conectado com sucesso! ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão" + ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try { 
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro no ExecutaSQL" + ex.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            conn.close();
        } catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
        }   
    }
    
    public Connection getConexao() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
         //   JOptionPane.showMessageDialog(null, "conectado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro de conexão" + ex.getMessage());
        }
        return conn;
    }
    
}

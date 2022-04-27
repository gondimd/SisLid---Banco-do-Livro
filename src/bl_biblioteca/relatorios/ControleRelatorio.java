/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.relatorios;

import bl_biblioteca.controle.ConectaBanco;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.postgresql.core.ConnectionFactory;


public class ControleRelatorio {

    String relatorio = "";
    ConectaBanco conecta = new ConectaBanco();

    public void gerarRelatorioPadrao(String relatorio) {
        this.relatorio = relatorio;
        InputStream inputStream = getClass().getResourceAsStream(relatorio);
        Map paramentros = new HashMap();
        try {
            ReportUtils.openReport("Relacao de Livros", inputStream, paramentros, conecta.getConexao());
        } catch (JRException ex) {
            Logger.getLogger(ControleRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gerarRelatorioPersonalizado() throws JRException {
        conecta.getConexao();
        try {
            conecta.executaSQL("SELECT * FROM single.livro");
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
            JasperPrint jpPrint;
            jpPrint = JasperFillManager.fillReport("src/bl_biblioteca/relatorios/RelatorioLivros.jasper", new HashMap(), relatResul);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControleRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconectar();
    }
    
    public void gerarRelatorioPadrao2() {
        
        
        InputStream inputStream = getClass().getResourceAsStream("relatorioPrincipal-modelo 2.jasper");
        Map paramentros = new HashMap();
        try {
            ReportUtils.openReport("Relacao de Livros", inputStream, paramentros, conecta.getConexao());
        } catch (JRException ex) {
            Logger.getLogger(ControleRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void executaRelatorioAtrasados() throws JRException {

        conecta.getConexao();
        conecta.executaSQL("SELECT \n" +
"	single.users.id,\n" +
"	single.users.name,\n" +
"	single.exemplar.registro,\n" +
"	single.livro.titulo,\n" +
"	single.area.nome,\n" +
"	single.livro.serie,\n" +
"	single.emprestimo.data_hora\n" +
"	\n" +
"FROM single.livro\n" +
"	INNER JOIN single.editora ON \n" +
"	 single.livro.editora = single.editora.codigo \n" +
"	INNER JOIN single.area ON \n" +
"	 single.livro.area = single.area.codigo \n" +
"	INNER JOIN single.autor ON \n" +
"	 single.livro.autor = single.autor.codigo \n" +
"	INNER JOIN single.local ON \n" +
"	 single.editora.local = single.local.codigo \n" +
"	INNER JOIN single.exemplar ON\n" +
"	single.exemplar.livro = single.livro.registro\n" +
"	INNER JOIN single.emprestimo ON\n" +
"	single.exemplar.registro = single.emprestimo.exemplar\n" +
"	INNER JOIN single.users ON\n" +
"	single.emprestimo.users = single.users.id\n" +
"	INNER JOIN single.users_types ON\n" +
"	single.users.type = single.users_types.id\n" +
"		 where data_saida is null  and\n" +
"		 single.emprestimo.data_hora <  current_date - interval '1 year' and\n" +
"		 single.emprestimo.status is true\n" +
"	 GROUP BY single.livro.titulo,\n" +
"		  single.livro.serie,\n" +
"		  single.area.nome,\n" +
"		  single.exemplar.registro,\n" +
"		  single.users.name,\n" +
"		  single.users.id,\n" +
"		  single.emprestimo.data_hora\n" +
"		  Order by single.emprestimo.data_hora desc");
        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
        JasperPrint jpPrint = JasperFillManager.fillReport("src/bl_biblioteca/relatorios/emprestimosAtrasados.jasper", new HashMap(), relatResul);
        JasperViewer jv = new JasperViewer(jpPrint, false);
        jv.setVisible(true);
    }
    
    
    
    
    
    /*  public void gerarPdf(){
     conecta.conexao();
     HashMap filtro = new HashMap();
     filtro.put("codigo", this);
     JasperPrint print = JasperFillManager.fillReport("relatorios/livros.jasper", filtro, conecta);
     JasperViewer viewer = new JasperViewer(print, false);
     viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
     viewer.setTitle("Relatório");
     viewer.setVisible(true);    
     }
     */
    
}

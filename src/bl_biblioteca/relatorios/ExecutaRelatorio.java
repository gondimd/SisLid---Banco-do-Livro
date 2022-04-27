
package bl_biblioteca.relatorios;

import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import bl_biblioteca.controle.ConectaBanco;


public class ExecutaRelatorio {

    ConectaBanco conecta = new ConectaBanco();
    
    public void executaRelatorio2() throws JRException{
    
    conecta.getConexao();
    conecta.executaSQL ("SELECT * FROM single.livro");
    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
    JasperPrint jpPrint = JasperFillManager.fillReport("src/bl_biblioteca/relatorios/RelatorioLivros.jasper", new HashMap(), relatResul);
    JasperViewer jv = new JasperViewer(jpPrint, false);
    jv.setVisible(true);
    }
    
    public void executaRelatorio3() throws JRException{
    
    conecta.getConexao();
    conecta.executaSQL ("SELECT  COUNT(*),livro.titulo ,autor.nome, area.nome, editora.nome,livro.ano_publicacao, livro.serie, livro.volume, livro.data_entrada\n" +
                        "FROM single.livro livro \n" +
                        "INNER JOIN single.autor autor ON \n" +
                        "autor.codigo = livro.autor \n" +
                        "INNER JOIN single.editora editora ON\n" +
                        "livro.editora = editora.codigo\n" +
                        "INNER JOIN single.area area ON\n" +
                        "area.codigo = livro.area\n" +
                        "where data_saida is null\n" +
                        "group by livro.autor, livro.data_entrada, livro.titulo, autor.nome, livro.serie, livro.volume,area.nome,editora.nome, livro.ano_publicacao\n" +
                        "order by livro.data_entrada");
    JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
    JasperPrint jpPrint = JasperFillManager.fillReport("src/bl_biblioteca/relatorios/RelatorioLivros3.jasper", new HashMap(), relatResul);
    JasperViewer jv = new JasperViewer(jpPrint, false);
    jv.setVisible(true);
    }
    
}

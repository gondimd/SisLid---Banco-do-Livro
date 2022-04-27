/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.relatorios;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import bl_biblioteca.controle.ConectaBanco;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Diego
 */
public class ExecutaRelatorio2 {

    ConectaBanco conecta = new ConectaBanco();

    public void executaRelatorio2() throws JRException {

        conecta.getConexao();
        conecta.executaSQL("SELECT \n"
                + "	single.users.id,\n"
                + "	single.users.name,\n"
                + "	single.exemplar.registro,\n"
                + "	single.livro.titulo,\n"
                + "	single.area.nome,\n"
                + "	single.livro.serie,\n"
                + "	single.emprestimo.data_hora\n"
                + "	\n"
                + "FROM single.livro\n"
                + "	INNER JOIN single.editora ON \n"
                + "	 single.livro.editora = single.editora.codigo \n"
                + "	INNER JOIN single.area ON \n"
                + "	 single.livro.area = single.area.codigo \n"
                + "	INNER JOIN single.autor ON \n"
                + "	 single.livro.autor = single.autor.codigo \n"
                + "	INNER JOIN single.local ON \n"
                + "	 single.editora.local = single.local.codigo \n"
                + "	INNER JOIN single.exemplar ON\n"
                + "	single.exemplar.livro = single.livro.registro\n"
                + "	INNER JOIN single.emprestimo ON\n"
                + "	single.exemplar.registro = single.emprestimo.exemplar\n"
                + "	INNER JOIN single.users ON\n"
                + "	single.emprestimo.users = single.users.id\n"
                + "	INNER JOIN single.users_types ON\n"
                + "	single.users.type = single.users_types.id\n"
                + "		 where data_saida is null  and\n"
                + "		 single.emprestimo.data_hora <  current_date -365 and\n"
                + "		 single.emprestimo.status is true\n"
                + "	 GROUP BY single.livro.titulo,\n"
                + "		  single.livro.serie,\n"
                + "		  single.area.nome,\n"
                + "		  single.exemplar.registro,\n"
                + "		  single.users.name,\n"
                + "		  single.users.id,\n"
                + "		  single.emprestimo.data_hora\n"
                + "		  Order by single.emprestimo.data_hora desc");
        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
        JasperPrint jpPrint = JasperFillManager.fillReport("src/bl_biblioteca/relatorios/emprestimosAtrasados.jasper", new HashMap(), relatResul);
        JasperViewer jv = new JasperViewer(jpPrint, false);
        jv.setVisible(true);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.subRelatorios;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Diego
 */
public class ControleSubRelatorio {
    
    
    public void abrirRelatorioClientes() {

        InputStream inputStream = getClass().getResourceAsStream( "LocacoesPorClientes.jasper" );
   //    InputStream inputStream = getClass().getResourceAsStream( "/EmprestimoAlunos.jasper" );
        
      
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put( "nomeCliente", "F%" );

        try {
            
            ReportUtils.openReport( "Locações por Clientes", inputStream, parametros,
                    ConnectionFactory.getSakilaConnection() );

        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } catch ( JRException exc ) {
            exc.printStackTrace();
        }
        
    }
}

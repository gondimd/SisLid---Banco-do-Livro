/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.relatorios;

import java.awt.BorderLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Diego
 */
  public class ReportUtils {
    public static void openReport(String titulo, InputStream inputstream, Map parametros, Connection conectar ) throws JRException{
        JasperPrint print = JasperFillManager.fillReport(inputstream, parametros, conectar);
        viewReportFrame(titulo, print);
    }
    
    
    private static void viewReportFrame (String titulo, JasperPrint print){
            JRViewer viewer = new JRViewer(print);
            JFrame frameRelatorio = new JFrame(titulo);
            frameRelatorio.add(viewer, BorderLayout.CENTER);
            frameRelatorio.setSize(500,500);
            frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameRelatorio.setVisible(true);
        }
    
}

package bl_biblioteca.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PostgresRestore {

    public void realizaRestore() throws IOException, InterruptedException {
        final List<String> comandos = new ArrayList<String>();

        comandos.add("C:\\Arquivos de programas\\PostgreSQL\\9.1\\bin\\pg_restore.exe"); //testado no windows xp  


        comandos.add("-i");
        comandos.add("-h");
        comandos.add("localhost");    //ou   comandos.add("192.168.0.1");   
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("postgres");
        comandos.add("-d");
        comandos.add("biblivre4");       // "biblivre4"
        comandos.add("-v");

        comandos.add("D:\\SisLiD.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.    

        ProcessBuilder pb = new ProcessBuilder(comandos);

        pb.environment().put("PGPASSWORD", "abracadabra");     //Somente coloque sua senha           

        try {
            final Process process = pb.start();

            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }
            r.close();

            process.waitFor();
            process.destroy();
            JOptionPane.showMessageDialog(null, "Restauração da base de dados realizado com sucesso!.");

        } catch (IOException e) {
        } catch (InterruptedException ie) {
        }

    }
    /*    
     public static void main(String[] args) {    
     try {    
     PostgresRestore.realizaRestore();             
     } catch (IOException e) {    
     e.printStackTrace();    
     } catch (InterruptedException e) {    
     e.printStackTrace();    
     }       
     }
     */
}

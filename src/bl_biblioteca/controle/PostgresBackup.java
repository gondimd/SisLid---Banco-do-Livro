package bl_biblioteca.controle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bl_biblioteca.modelo.ModeloBackup;
import bl_biblioteca.visao.FrmBackup;



import java.io.IOException;

public class PostgresBackup {

    public void realizaBackup() throws IOException, InterruptedException {
        final List<String> comandos = new ArrayList<String>();

        //comandos.add("C:\\Program Files (x86)\\PostgreSQL\\8.4\\bin\\pg_dump.exe");   
        //comandos.add("C:\\Program Files\\PostgresPlus\\8.4SS\\bin\\pg_dump.exe");   
        comandos.add("C:\\Arquivos de programas\\PostgreSQL\\9.1\\bin\\pg_dump.exe");    // esse é meu caminho    

        comandos.add("-i");
        comandos.add("-h");
        comandos.add("localhost");     //ou  comandos.add("192.168.0.1");   
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("postgres");
        comandos.add("-F");
        comandos.add("c");
        comandos.add("-b");
        comandos.add("-v");
        comandos.add("-f");

        comandos.add("d:\\SisLiD.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.    
        //comandos.add("testeBackup");
        comandos.add("biblivre4");
        ProcessBuilder pb = new ProcessBuilder(comandos);

        pb.environment().put("PGPASSWORD", "abracadabra");      //Somente coloque sua senha           
        ModeloBackup backup = new ModeloBackup();
        try {
            final Process process = pb.start();

            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();

            while (line != null) {
                line = r.readLine();
                System.out.println(""+line);
            }
            r.close();

            process.waitFor();
            process.destroy();
            JOptionPane.showMessageDialog(null, "Backup da base de dados realizado com sucesso!.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
/*
 public static void main(String[] args) {
 try {
 PostgresBackup.realizaBackup();
 } catch (IOException e) {
 e.printStackTrace();
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }*/

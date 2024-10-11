import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String[] commands = {
                "pwd",           // Mostrar el directorio actual
                "ls -l",         // Listar archivos con detalles
                "df -h",         // Ver el uso del disco en formato legible
                "date",          // Mostrar la fecha y hora actuales
                "uname -a"       // Mostrar información del sistema operativo
        };

        for (String command : commands) {
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", command);

            try {
                Process process = processBuilder.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                System.out.println("Salida del comando: " + command);
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                int exitCode = process.waitFor();
                System.out.println("Proceso terminado con código: " + exitCode);
                System.out.println("--------------------------------------------");

            } catch (IOException e) {
                System.out.println("Ocurrió un error ejecutando " + command + ": " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("El proceso fue interrumpido ejecutando " + command + ": " + e.getMessage());
            }
        }
    }
}

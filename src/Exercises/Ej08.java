package Exercises;

import java.io.*;

/**
 * 8. Crea un fichero de texto con algún editor de textos y después realiza un
 * programa Java que visualice su contenido. Cambia el programa java para que el
 * nombre del fichero se acepte desde teclado.
 **/

public class Ej08 {
    public static void main(String[] args) {
        File f = new File(Rutas.RUTA_FICHERO);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

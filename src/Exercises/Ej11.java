package Exercises;

import java.io.*;

/**
 * PRÁCTICA.............: Ej11
 * NOMBRE y APELLIDOS...: Pablo Navarro
 * CURSO y GRUPO........: 2º Desarrollo de Interfaces
 * TÍTULO de la PRÁCTICA:
 * <p>
 * Realiza un programa que copie dos ficheros. El nombre de los dos ficheros,
 * origen y destino se introducen por teclado.
 * </p>
 * FECHA de ENTREGA.....: 22 / 09 /2022
 **/


public class Ej11 {
    public static void main(String[] args) {
        File f = new File(Rutas.RUTA_FICHERO);
        File fCopia = new File(Rutas.RUTA_FICHERO_TEMPORAL);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            PrintWriter pw = new PrintWriter(fCopia);
            String linea;
            while ((linea = br.readLine())!=null)
            {
                pw.println(linea);
            }
            br.close();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

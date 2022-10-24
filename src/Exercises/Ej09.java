package Exercises;

import java.io.*;
import java.util.Scanner;

/**
 * 9. Crea un fichero Java que reciba un identificador de un empleado desde
 * teclado y visualice sus datos. Si el empleado no existe debe visualizar el mensaje.
 **/

public class Ej09 {
    public static void main(String[] args) {
        File f = new File(Rutas.RUTA_FICHERO);
        try {
            Scanner teclado = new Scanner(System.in);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            boolean existe = false;
            System.out.println("Indica el número del empleado que quieras consultar");
            int num = teclado.nextInt();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (num == Integer.parseInt(datos[0])) {
                    System.out.printf("Número: " + datos[0].trim() + "  | Nombre: " + datos[1].trim());
                    existe = true;
                }
            }
            if (!existe){
                System.out.println("El número indicado no pertenece a ningún empleado");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

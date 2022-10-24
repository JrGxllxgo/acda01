package Exercises;

import java.io.*;
import java.util.Scanner;

/**
 * 6. Realiza un programa Java que te permita modificar los datos de
 * departamento. El programa lee el número de departamento a modificar, el nuevo
 * nombre de departamento y la nueva localidad. Si el departamento no existe visualiza
 * un mensaje indicándolo. Visualiza también los datos antiguos del departamento y los
 * nuevos datos.
 **/

public class Ej06 {
    public static void main(String[] args) throws IOException
    {
        File f = new File(Rutas.RUTA_DEPARTAMENTO);
        File fTemporal = new File(Rutas.RUTA_DEPARTAMENTO_TEMPORAL);

        if (f.exists())
        {
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            FileOutputStream fos = new FileOutputStream(fTemporal);
            DataOutputStream dos = new DataOutputStream(fos);
            int numDpto;
            String nombreDpto;
            int salarioDpto;
            Scanner teclado = new Scanner(System.in);
            int numDptoNuevo;

            System.out.println("Indica el número del departamento que desea modificar");
            numDptoNuevo = teclado.nextInt();

            try {
                while (true) {
                    numDpto = dis.readInt();
                    nombreDpto = dis.readUTF();
                    salarioDpto = dis.readInt();

                    if (numDpto == numDptoNuevo)
                    {
                        System.out.println("Indica el nuevo nombre:");
                        nombreDpto = teclado.next();
                        System.out.println("Indica el nuevo salario:");
                        salarioDpto = teclado.nextInt();
                    }

                    dos.writeInt(numDpto);
                    dos.writeUTF(nombreDpto);
                    dos.writeInt(salarioDpto);
                }
            } catch (IOException e) {
                fis.close();
                dis.close();
                fos.close();
                dos.close();
            }
        } else
        {
            System.out.println("El archivo especificado no existe");
        }
    }
}

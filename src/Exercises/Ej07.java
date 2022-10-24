package Exercises;

import java.io.*;
import java.util.Scanner;

/**
 * 7. Realiza un programa java que te permita eliminar un departamento. El
 * programa lee el número de departamento a eliminar. Si el departamento no existe
 * visualiza un mensaje indicándolo. Visualiza también el número total de departamentos
 * que existen.
 **/

public class Ej07 {
    public static void main(String[] args) {
        File f = new File(Rutas.RUTA_DEPARTAMENTO);
        File fTemporal = new File(Rutas.RUTA_DEPARTAMENTO_TEMPORAL);

        try
        {
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            FileOutputStream fos = new FileOutputStream(fTemporal);
            DataOutputStream dos = new DataOutputStream(fos);
            boolean existe = false;
            int numDpto;
            String nombreDpto;
            int salarioDpto;
            int contador = 0;

            Scanner teclado = new Scanner(System.in);
            int numDptoNuevo;

            System.out.println("Indica el número del departamento que desea eliminar");
            numDptoNuevo = teclado.nextInt();
            try {
                while (true) {
                    numDpto = dis.readInt();
                    nombreDpto = dis.readUTF();
                    salarioDpto = dis.readInt();
                    if (numDpto == numDptoNuevo)
                    {
                        existe = true;
                    }else
                    {
                        dos.writeInt(numDpto);
                        dos.writeUTF(nombreDpto);
                        dos.writeInt(salarioDpto);
                    }
                    contador++;
                }
            } catch (IOException e) {
                fis.close();
                dis.close();
                fos.close();
                dos.close();
            }
            if (!existe){
                System.out.println("El número indicado de departamento no existe");
            }
            System.out.println("Hay un total de " + contador + " departamentos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

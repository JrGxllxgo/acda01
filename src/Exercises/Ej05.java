package Exercises;

import java.io.*;

/**
 * 5. Realiza un programa java que cree un fichero binario para guardar datos de
 * departamentos, dale el nombre Departamentos.dat. Introduce varios departamentos.
 * Los datos por cada departamento son: Número de departamento: entero, Nombre:
 * String y Localidad: String.
 **/

public class Ej05 {
    public static void main(String[] args) throws IOException {
        File f = new File(Rutas.RUTA_DEPARTAMENTO);
        if (!f.exists()) {
            f.createNewFile();
        } else {
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);
            int[] numDpto = {1, 2, 3, 4, 5};
            String[] nombreDpto = {"Dpto1", "Dpto2", "Dpto3", "Dpto4", "Dpto5"};
            String[] localidadDpto = {"Málaga", "Albacete", "Churriana", "Alhaurín", "Madrid"};
            for (int i = 0; i < numDpto.length; i++) {
                dos.writeInt(numDpto[i]);
                dos.writeUTF(nombreDpto[i]);
                dos.writeUTF(localidadDpto[i]);
            }
            fos.close();
            dos.close();
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            int num;
            String nombre;
            String localidad;
            try {
                while (true) {
                    num = dis.readInt();
                    nombre = dis.readUTF();
                    localidad = dis.readUTF();
                    System.out.println("Número: " + num + " | Nombre: " + nombre + " | Localidad: " + localidad);
                }
            } catch (IOException e) {
                fis.close();
                dis.close();
            }
        }
    }
}

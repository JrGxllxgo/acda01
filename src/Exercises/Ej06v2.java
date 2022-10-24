package Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej06v2 {
    public static void main(String[] args) throws IOException {
        File f = new File(Rutas.RUTA_DEPARTAMENTO);
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            int numDpto;
            String nombreDpto;
            String localidadDpto;
            ArrayList<Integer> nums = new ArrayList<>();
            ArrayList<String> nombres = new ArrayList<>();
            ArrayList<String> localidades = new ArrayList<>();

            try {
                while (true) {
                    numDpto = dis.readInt();
                    nums.add(numDpto);
                    nombreDpto = dis.readUTF();
                    nombres.add(nombreDpto);
                    localidadDpto = dis.readUTF();
                    localidades.add(localidadDpto);
                }
            } catch (IOException e) {
                fis.close();
                dis.close();
            }

            Scanner teclado = new Scanner(System.in);
            System.out.println("Indica el número del departamento que desea modificar");
            int numDptoNuevo = teclado.nextInt();
            System.out.println("Indica el nuevo nombre:");
            String nombreDptoNuevo = teclado.next();
            System.out.println("Indica la nueva localidad:");
            String localidadDptoNuevo = teclado.next();

            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == numDptoNuevo){
                    nombres.set(i,nombreDptoNuevo);
                    localidades.set(i,localidadDptoNuevo);
                }
            }
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < nums.size(); i++) {
                dos.writeInt(nums.get(i));
                dos.writeUTF(nombres.get(i));
                dos.writeUTF(localidades.get(i));
            }
            fos.close();
            dos.close();

        } else {
            System.out.println("El archivo especificado no existe");
        }
    }
}

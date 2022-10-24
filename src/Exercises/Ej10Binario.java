package Exercises;

import java.io.*;
import java.util.Scanner;

public class Ej10Binario
{
    public static void main(String[] args)
    {
        File f = new File(Rutas.RUTA_DEPARTAMENTO);
        File fTemporal = new File(Rutas.RUTA_DEPARTAMENTO_TEMPORAL);

        try
        {
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            Scanner teclado = new Scanner(System.in);
            FileOutputStream fos = new FileOutputStream(fTemporal);
            DataOutputStream dos = new DataOutputStream(fos);
            boolean existe = false;
            int num,id;
            String nombre,localidad;

            System.out.println("Indique el número de empleado al cual desee modificar el salario");
            num = teclado.nextInt();
            try {
                while (true) {
                    id = dis.readInt();
                    nombre = dis.readUTF();
                    localidad = dis.readUTF();
                    //datos[0] = identificador, datos[1] = nombre, datos[2] = salario
                    if (id == num){
                        System.out.println("Indique la nueva localidad");
                        localidad = teclado.next();
                        existe = true;
                    }
                    dos.writeInt(id);
                    dos.writeUTF(nombre);
                    dos.writeUTF(localidad);
                }
            } catch (IOException e) {
                fis.close();
                dis.close();
            }
            dis.close();
            dos.close();
            if (!existe)
            {
                System.out.println("El número introducido no pertenece a ningún empleado");
            }
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

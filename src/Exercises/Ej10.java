package Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PRÁCTICA.............: Ej10
 * NOMBRE y APELLIDOS...: Pablo Navarro
 * CURSO y GRUPO........: 2º Desarrollo de Interfaces
 * TÍTULO de la PRÁCTICA:
 * <p>
 * Crea un programa java que reciba desde teclado un identificador de empleado
 * y un importe. Se debe sumar al salario del empleado el importe tecleado. El programa
 * debe visualizar el apellido, el salario antiguo y el nuevo. Si el identificador no existe se
 * visualizará un mensaje indicándolo.
 * </p>
 * FECHA de ENTREGA.....: 22 / 09 /2022
 **/

public class Ej10
{
    public static void main(String[] args)
    {
        File f = new File(Rutas.RUTA_FICHERO);
        File fTemporal = new File(Rutas.RUTA_FICHERO_TEMPORAL);

        try
        {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            Scanner teclado = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(fTemporal);
            boolean existe = false;
            int num;
            int salario;

            System.out.println("Indique el número de empleado al cual desee modificar el salario");
            num = teclado.nextInt();
            while ((linea = br.readLine()) != null)
            {
                //datos[0] = identificador, datos[1] = nombre, datos[2] = salario
                String datos[] = linea.split(",");

                if (Integer.parseInt(datos[0]) == num)
                {
                    System.out.println("Indique el nuevo salario");
                    salario = teclado.nextInt();
                    pw.println(datos[0] + "," + datos[1] + "," + salario);
                    existe = true;
                }
                else
                {
                    pw.println(datos[0] + "," + datos[1] + "," + datos[2]);
                }
            }
            br.close();
            pw.close();
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

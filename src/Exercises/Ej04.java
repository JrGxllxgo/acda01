package Exercises;

import java.io.File;
import java.util.Scanner;

public class Ej04 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del directorio: ");
        String directorio = teclado.next();
        File f = new File(directorio);
        if (f.exists() && f.isDirectory()){
            for (File file : f.listFiles()) {
                System.out.println(file);
            }
        } else if (!f.isDirectory()) {
            System.out.println("La ruta establecida no pertenece a un directorio");
        }else {
            System.out.println("La ruta especificada no apunta a ningún fichero ni directorio");
        }
    }
}

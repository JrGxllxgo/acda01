package Exercises;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Ej02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del directorio: ");
        String directorio = teclado.next();
        File f = new File(directorio);
        if (f.exists() && f.isDirectory()) {
/*          Con recursividad
            listarDirectorio(f);*/
            for (File file : f.listFiles()) {
                System.out.println(file);
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        System.out.println(file2);
                        if (file2.isDirectory()) {
                            for (File file3 : file2.listFiles()) {
                                System.out.println(file3);
                                if (file3.isDirectory()) {
                                    for (File file4 : file3.listFiles()) {
                                        System.out.println(file4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (!f.isDirectory()) {
            System.out.println("La ruta establecida no pertenece a un directorio");
        } else {
            System.out.println("La ruta especificada no apunta a ningún fichero ni directorio");
        }
    }

    private static void listarDirectorio(File file) {
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                System.out.println("\u001B[32m" + file1 + "\u001B[0m");
                listarDirectorio(file1);
            } else {
                System.out.println(file1);
            }
        }
    }
}

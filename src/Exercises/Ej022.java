package Exercises;

import java.io.File;
import java.util.Scanner;

public class Ej022 {
	public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del directorio: ");
        String directorio = teclado.next();
        File f = new File(directorio);
        if (f.exists() && f.isDirectory()) {
            listarDirectorio(f);
        }
    }

    private static void listarDirectorio(File file) {
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                System.out.println(file1);
                listarDirectorio(file1);
            } else {
                System.out.println(file1);
            }
        }
    }
}

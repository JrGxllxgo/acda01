package Lesson1;

import java.io.*;
import java.util.Scanner;

public class Ej02_ShowDir {

	public static void main(String[] args) {
		// File f = new File("D:\\FileTesting");
		File f = new File(KeyBoard());

		//printFiles(f);
		File[] ficheros = f.listFiles();

		for (int x = 0; x < ficheros.length; x++) {
			if (ficheros[x].isDirectory()) {
				for (int y = 0; y < ficheros.length; y++) {
					if (ficheros[y].isDirectory()) {
						printFiles(ficheros[y]);
					} else {
						System.out.println(ficheros[y]);
					}
				}
			} else {
				System.out.println(ficheros[x]);
			}
		}
	}

	// Metodo para usar la recursividad
	public static void printFiles(File f) {
		File[] ficheros = f.listFiles();

		for (int x = 0; x < ficheros.length; x++) {
			if (ficheros[x].isDirectory()) {
				printFiles(ficheros[x]);
			} else {
				System.out.println(ficheros[x]);
			}
		}
	}

	// Metodo donde introducimos la ruta por teclado
	private static String KeyBoard() {
		Scanner Key = new Scanner(System.in);
		System.out.println("Introduce la Ruta");
		return Key.nextLine();
	}
}

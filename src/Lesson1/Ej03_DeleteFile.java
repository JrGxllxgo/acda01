package Lesson1;

import java.io.*;
import java.util.Scanner;

public class Ej03_DeleteFile {

	public static void main(String[] args) {
		// File d = new File("D:\\FileTesting");
		File d = new File(KeyBoard());

		//deleteDir(d);
		
		File[] ficheros = d.listFiles();

		for (int x = 0; x < ficheros.length; x++) {
			if (ficheros[x].isDirectory()) {
				for (int y = 0; y < ficheros.length; y++) {
					if (ficheros[y].isDirectory()) {
						ficheros[y].delete();
					} else {
						ficheros[y].delete();
					}
				}
			} else {
				ficheros[x].delete();
			}
		}
		d.delete();
	}

	// Metodo donde borra los ficheros
	private static void deleteDir(File d) {
		File[] ficheros = d.listFiles();

		for (int x = 0; x < ficheros.length; x++) {
			if (ficheros[x].isDirectory()) {
				System.out.println("Borrando... "+ficheros[x]);
				deleteDir(ficheros[x]);
			}
			ficheros[x].delete();
		}
		d.delete();
	}

	// Metodo donde introducimos la ruta por teclado
	private static String KeyBoard() {
		Scanner Key = new Scanner(System.in);
		System.out.println("Introduce la Ruta");
		return Key.nextLine();
	}
}

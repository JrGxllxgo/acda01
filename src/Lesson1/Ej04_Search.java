package Lesson1;

import java.io.*;
import java.util.*;

public class Ej04_Search {

	public static void main(String[] args) {
		String dir = KeyBoard();
		File f = null;

		try {
			// tratamos el objeto f como directorio
			f = new File(dir);
			// condicional donde si es directorio entra
			if (f.isDirectory()) {
				// metemos en un array el contenido y lo vamos imprimiendo
				String[] contenido = f.list();
				for (int i = 0; i < contenido.length; i++) {
					System.out.println(contenido[i]);
				}
			} else
				System.out.println("Directorio no valido");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo donde introducimos la ruta por teclado
	private static String KeyBoard() {
		Scanner Key = new Scanner(System.in);
		System.out.println("Introduce la Ruta");
		return Key.nextLine();
	}
}

package Lesson1;

import java.io.*;

public class WriteFile {
	public static void main(String[] args) throws IOException {
		File fichero = new File("D:\\FileTesting\\example.txt"); // declarar fichero
		FileWriter fic = new FileWriter(fichero,true);
		String cadena = "Prueba para FileWriter";
		// convierte la cadena en array de caracteres para extraerlos uno a uno
		char[] cad = cadena.toCharArray();
		for (int i = 0; i < cad.length; i++)
			fic.write(cad[i]); // se va escribe por caracter

		fic.append('*');
		fic.close();
	}
}

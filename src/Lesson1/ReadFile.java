package Lesson1;

import java.io.*;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		// declarar fichero
		File fichero = new File("D:\\FileTesting\\example.txt");
		// crear el flujo de entrada hacia el fichero
		FileReader fic = new FileReader(fichero);
		int i;
		while ((i = fic.read()) != -1)
			System.out.print((char) i);// se va leyendo un carácter
		fic.close(); // cierro el fichero
	}
}

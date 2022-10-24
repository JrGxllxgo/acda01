package Lesson1;

import java.io.*;

public class WriteBin {
	public static void main(String[] args) throws IOException {
		File fichero = new File("D:\\FileTesting\\FichBytes.dat"); // declara fichero
		// crea flujo de escritura hacia el fichero
		FileOutputStream fileout = new FileOutputStream(fichero);
		// crea flujo de lectura del fichero
		FileInputStream filein = new FileInputStream(fichero);
		int i;
		for (i = 1; i < 100; i++)
			fileout.write(i); // escribe datos en el flujo de salida
		fileout.close(); // cerrar stream de salida
		// visualizar los datos del fichero
		while ((i = filein.read()) != -1) // lee datos del flujo de entrada
			System.out.println(i);
		filein.close(); // cerrar stream de entrada
	}
}

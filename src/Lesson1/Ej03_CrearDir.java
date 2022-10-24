/*
 * Creamos un directorio y dos ficheros y renombramos el primer fichero
 */
package Lesson1;

import java.io.*;

public class Ej03_CrearDir {
	public static void main(String[] args) {
		
		// Creamos los objetos con los que trataremos
		File d = new File("NUEVODIR");
		File f1 = new File(d, "FICHERO1.TXT");
		File f2 = new File(d, "FICHERO2.TXT");

		// Hacemos el objeto d un directorio
		d.mkdir();
		try {
			if (f1.createNewFile())
				System.out.println("FICHERO1 creado correctamente");
			else
				System.out.println("No se ha podido crear FICHERO1");
			if (f2.createNewFile())
				System.out.println("FICHERO2 creado correctamente");
			else
				System.out.println("No se ha podido crear FICHERO2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f1.renameTo(new File(d, "FICHERO1NUEVO.TXT")); // renombrar FICHERO1
		try {
			File f3 = new File("NUEVODIR/FICHERO3.TXT");
			f3.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Crear FICHERO3 en NUEVODIR
	}
}

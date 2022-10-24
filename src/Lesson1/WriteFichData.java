package Lesson1;

import java.io.*;

public class WriteFichData {
	public static void main(String[] args) throws IOException {
		File fichero = new File("D:\\FileTesting\\FichData.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);

		DataOutputStream dataOS = new DataOutputStream(fileout);

		String nombres[] = { "Enrique", "Alejandra", "Ascensión", "José Miguel" };
		int edades[] = { 38, 4, 76, 43 };

		for (int i = 0; i < edades.length; i++) {
			dataOS.writeUTF(nombres[i]); // escribe el nombre
			dataOS.writeInt(edades[i]); // escribe la edad
		}
		dataOS.close(); // cerrar stream
	}
}

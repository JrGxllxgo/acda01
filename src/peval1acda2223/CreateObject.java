package peval1acda2223;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateObject {

	private static GeneralMethods m = new GeneralMethods();

	private static String objectPath = "./investor.obj";

	CreateObject(String myPath) throws IOException {
		create(myPath);
	}

	public static void create(String myPath) throws IOException {
		File fichero = new File(objectPath);

		ObjectOutputStream fileout = new ObjectOutputStream(new FileOutputStream(fichero));

		BufferedReader myFileReader = new BufferedReader(new FileReader(myPath));
		String line;

		DataOutputStream dataOS = new DataOutputStream(fileout);

		try {
			while ((line = myFileReader.readLine()) != null) {
				String[] data = line.split(";");

				String lastField = data[data.length - 1];
				String[] sort = lastField.split(" ");

				char company = data[1].charAt(data[1].length() - 1);

				if (sort.length == 2) {
					fileout.writeObject(
							new Investor(Integer.parseInt(data[0]), company, data[2], data[3], sort[0], sort[1]));

				} else {
					fileout.writeObject(
							new Investor(Integer.parseInt(data[0]), company, data[2], data[3], sort[0], null));
				}
			}
		} catch (IOException io) {
			m.print("Error de E/S");
		}

		fileout.close();
		dataOS.close(); // cerrar stream
		myFileReader.close();

	}
}

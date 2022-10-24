package peval1acda2223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * 
 * @author José Ramón Gallego Vélez
 * @date 05/10/2022
 * @version 1.0
 * 
 * @info At this class we just receive the path of the file to update and
 *       rewrite it
 */
public class UpdateFile {

	SearchFile search = new SearchFile();

	private static GeneralMethods m = new GeneralMethods();
	private static String textToChange = "Purchasing";
	private static String newText = "Investor";
	private static String tempPath = "./CompaniesTemporal.txt";

	UpdateFile(String myPath) throws IOException {
		update(myPath);
	}

	/**
	 * Method where we receive our path and read it line per line to change the word
	 * given and rewrite it on another new TemporalFile
	 * 
	 * @param myPath
	 * @throws IOException
	 */
	private static void update(String myPath) throws IOException {

		BufferedReader fichero = new BufferedReader(new FileReader(myPath));
		BufferedWriter fTemp = new BufferedWriter(new FileWriter(tempPath));
		String line;

		File actual = new File(myPath);
		File newOne = new File(tempPath);

		try {
			while ((line = fichero.readLine()) != null) {
				m.print("Cambiando los textos desdeados...");
				String newLine = line.replace(textToChange, newText);
				fTemp.write(newLine);
				fTemp.newLine();
			}
		} catch (IOException io) {
			m.print("Error de E/S");
		}

		fTemp.close();
		fichero.close();

		renameFiles(actual, newOne, myPath);

	}

	/**
	 * In this method we remove the original File and rename the temporal one
	 * 
	 * @param actual
	 * @param newOne
	 * @param myPath
	 */
	private static void renameFiles(File actual, File newOne, String myPath) {
		actual.delete();
		newOne.renameTo(new File(myPath));
		m.print("ARCHIVO ACTUALIZADO CON EXITO");
	}
}

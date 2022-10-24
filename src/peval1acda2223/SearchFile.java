package peval1acda2223;

import java.io.File;

/**
 * 
 * @author José Ramón Gallego Vélez
 * 
 * @info Class where the user introduce a path and the program search in it the
 *       file to get sure that it exists
 *
 */

public class SearchFile {

	private static GeneralMethods m = new GeneralMethods();
	private static String myPath;

	/**
	 * Method where it get a path given by the user and use it to send it to the
	 * method searchDirectory
	 * 
	 * @param path
	 */
	public static String searchDirectory(String path) {
		File f = new File(path);

		try {
			for (File file1 : f.listFiles()) {
				if (file1.isDirectory()) {
					m.print("Buscando en: " + file1);
					searchDirectory(file1.getAbsolutePath());
				} else {
					if (file1.getName().equals("Companies.txt")) {
						m.print("Archivo encontrado!!");
						myPath = file1.getAbsolutePath();
					}
				}
			}
			
		}catch(NullPointerException e) {
			m.print("Error en el examen de los archivos");
		}
		return myPath;
	}
}

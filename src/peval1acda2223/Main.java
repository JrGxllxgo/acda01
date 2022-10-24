package peval1acda2223;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

/**
 * 
 * @author José Ramón Gallego Vélez
 * @date 05/10/2022
 * @version 1.0
 * 
 *          D:\FileTestingPeval1 "D:\FileTestingPeval1\B\C\Companies.txt"
 */
public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, SAXException {

		SearchFile search = new SearchFile();
		GeneralMethods m = new GeneralMethods();

		int numOption = 0;
		String myPath;
		m.print("Bienvenido al menu de la PEVAL1");
		myPath = search
				.searchDirectory(m.keyBoardString("Introduzca la ruta sobre la que se va a ejecutar el programa"));

		while (numOption != 6) {

			try {
				m.print("\nOPCIONES\t1: Actualizar fichero\t2: Crear objeto\t3: Crear fichero XML\t4: Leer Fichero XML\t5: Salir");
				numOption = m.keyBoardInt("Introduzca el numero de la opcion"); // Variable to set an option

				switch (numOption) {
				case 1:
					try {
						new UpdateFile(myPath);
					} catch (NullPointerException e) {
						m.print("Ruta Erronea");
					}
					break;
				case 2:
					new CreateObject(myPath);
					break;
				case 3:
					new CreateXML();
					break;
				case 4:
					new ReadXML();
					break;
				case 5:
					m.print("Hasta luego!!!");
					System.exit(0);
					break;
				default:
					m.print("Opcion invalida");
				}
			} catch (InputMismatchException e) {
				m.print("Introduzca valores numericos");
			}

		}
	}
}

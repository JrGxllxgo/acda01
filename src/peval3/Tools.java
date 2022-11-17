package peval3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author José Ramón Gallego Vélez
 * @date 15/11/2022
 * @version 1.0
 * 
 * @info On this class we use basic methods to use in all class
 */
public class Tools {

	/**
	 * Method to transform a String with a date to a date type Daate
	 * @param fecha String with the date
	 * @return Date with new date
	 */
	public Date transformDate(String fecha){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date newFecha = null;

		try{
			newFecha = format.parse (fecha);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return newFecha;
	}
	/**
	 * Method that receive a text and prints it
	 * 
	 * @param txt
	 */
	public static void print(String txt) {
		System.out.println(txt);
	}

	/**
	 * Method that ask for a number to select the option
	 * 
	 * @param text
	 * @return number selection
	 */
	public static int keyBoardInt(String text) {
		Scanner key = new Scanner(System.in);
		System.out.print(text);
		return key.nextInt();
	}

	/**
	 * Method that ask for a number to select the option
	 * 
	 * @param text
	 * @return number selection
	 */
	public static String keyBoardString(String text) {
		Scanner key = new Scanner(System.in);
		System.out.print(text);
		return key.nextLine();
	}
}

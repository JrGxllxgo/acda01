package peval3;

import java.util.Scanner;

/**
 * 
 * @author José Ramón Gallego Vélez
 * @date 24/10/2022
 * @version 1.0
 * 
 * @info On this class we use basic methods to use in all class
 */
public class Tools {

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

package peval3acda2223;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author José Ramón Gallego Vélez
 * @version 0
 * @date 15/11/2022
 * @info On this class we use basic methods to use in all class
 */
public class Tools {

    /**
     * Method to show the menu exercise
     */
    public static void menu() {
        /**
         * Integer numOption give you a number to use at the menu
         */
        int numOption = 0;

        print("Bienvenido al menu de");

        while (numOption != 7) {
            try {

                numOption = keyBoardInt("Introduzca una de las opciones:" +
                        "\n0: " +
                        "\n1: " +
                        "\n2: " +
                        "\n3: " +
                        "\n4: " +
                        "\n5: " +
                        "\n6: SALIR");
                switch (numOption) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        print("Hasta luego!!");
                        System.exit(0);
                        break;
                    default: //default message if the user tries to use an option that doesnt exist
                        print("Opcion no válida");
                }
            } catch (InputMismatchException e) { //controlling that the user not introduce text
                print("Introduzca valores correctos");
            }
        }
    }
    /**
     * Method to transform a String with a date to a date type Daate
     *
     * @param fecha String with the date
     * @return Date with new date
     */
    public Date transformDate(String fecha) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date newFecha = null;

        try {
            newFecha = format.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return newFecha;
    }
    /**
     * Method that receive a text and prints it
     *
     * @param txt String with the text to show
     */
    public static void print(String txt) {
        System.out.println(txt);
    }
    /**
     * Method that ask for a number to select the option
     *
     * @param text String with the text to show
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
     * @param text String with the text to show
     * @return number selection
     */
    public static String keyBoardString(String text) {
        Scanner key = new Scanner(System.in);
        System.out.print(text);
        return key.nextLine();
    }
}

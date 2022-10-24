package peval2acda2223;

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
 * @date 24/10/2022
 * @version 1.0
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, SAXException {

        Tools myTools = new Tools();
        DBConnection myDbConnection = new DBConnection();

        int numOption = 0;
        myTools.print("Bienvenido al menu de la PEVAL2");

        while (numOption != 6) {

            try {
                myTools.print("\nOPCIONES" +
                        "\n\t1: Anadir Fichajes" +
                        "\n\t2: Insertar Partido" +
                        "\n\t3: Mostrar datos de Jugadores" +
                        "\n\t4: Ver partidos de cada jugador" +
                        "\n\t5: Actualizar datos Pacífico (PIVOT --> PIVOTE)" +
                        "\n\t6: Eliminar datos de equipo" +
                        "\n\t7: Salir");
                numOption = myTools.keyBoardInt("Introduzca el numero de la opcion"); // Variable to set an option

                switch (numOption) {
                    case 1:
                        /*try {
                            new UpdateFile(myPath);
                        } catch (NullPointerException e) {
                            myTools.print("Ruta Erronea");
                        }*/
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
                        break;
                    case 7:
                        myTools.print("Hasta luego!!!");
                        System.exit(0);
                        break;
                    default:
                        myTools.print("Opcion invalida");
                }
            } catch (InputMismatchException e) {
                myTools.print("Introduzca valores correctos");
            }

        }
    }
}

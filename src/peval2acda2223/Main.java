package peval2acda2223;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

/**
 * @author José Ramón Gallego Vélez
 * @date 24/10/2022
 * @info Program that has different option working with a PHPMyAdmin DB and makes different actions depending on the option you choose
 *          !!!! I COULDN'T FINISH PERFECTLY THE FIRST OPTION !!!!
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, SAXException {

        Tools myTools = new Tools();
        DBConnection myConnection = new DBConnection();

        /**
         * Integer numOption give you a number to use at the menu
         */
        int numOption = 0;
        myTools.print("Bienvenido al menu de la PEVAL2");

        while (numOption != 7) {
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
                        myTools.print("Opción no implementada finalmente");
                        /*try {
                            new UpdateFile(myPath);
                        } catch (NullPointerException e) {
                            myTools.print("Ruta Erronea");
                        }*/
                        break;
                    case 2: //option that introduce at the DB a new game with data required
                        /**
                         * String localTeam text introduced by the user to set it for the query
                         */
                        String localTeam = myTools.keyBoardString("Introduzca el nombre del equipo local");
                        /**
                         * String visitorTeam text introduced by the user to set it for the query
                         */
                        String visitorTeam = myTools.keyBoardString("Introduzca el nombre del equipo visitante");
                        /**
                         * Integer localPts number introduced by the user to set it for the query
                         */
                        int localPts = myTools.keyBoardInt("Puntos del equipo local: ");
                        /**
                         * Integer visitorPts number introduced by the user to set it for the query
                         */
                        int visitorPts = myTools.keyBoardInt("Puntos del equipo visitante: ");
                        /**
                         * String season text introduced by the user to set it for the query
                         */
                        String season = myTools.keyBoardString("Introduzca la temporada: ");

                        myConnection.executeInsertQuery(localTeam, visitorTeam, localPts, visitorPts, season);
                    case 3: //option that show to the user all players of a concrete City
                        myConnection.executeSelectQuery(myTools.keyBoardString("Introduzca la ciudad que desea consultar"));
                        break;
                    case 4: //option that show to the user how many games a player played distinguishing between local and visitor
                        myConnection.getGames(myTools.keyBoardString("Introduzca el jugador que desea consultar"));
                        break;
                    case 5: //option that update the DB changing players positions
                        myConnection.executeUpdateQuery();
                        break;
                    case 6: //option that delete ALL team data
                        myConnection.deleteTeam(myTools.keyBoardString("Introduzca el equipo que desea borrar"));
                        break;
                    case 7: //option to exit the program
                        myTools.print("Hasta luego!!!");
                        System.exit(0);
                        break;
                    default: //defaultt message if the user tries to use an option that doesnt exist
                        myTools.print("Opcion invalida");
                }
            } catch (InputMismatchException e) { //controlling that the user not introduce text
                myTools.print("Introduzca valores correctos");
            } catch (SQLException e) {
                myTools.print("Error con las sentencias SQL");
            }
        }
    }
}

package peval3;

/**
 * @author José Ramón Gallego Vélez
 * @project peval3acda2223
 * @version v0
 * @info Project for Neodatis learning in a case of a library management
 */

import java.sql.SQLException;
import java.util.InputMismatchException;

public class Main {

    /**
     * Using another classes in main
     */
    private static Tools myTools = new Tools();
    private static Consultas myCons = new Consultas();
    private static Gestion gest = new Gestion();

    private static Config myConfig =  new Config();
    public static void main(String[] args) {

        /**
         * Integer numOption give you a number to use at the menu
         */
        int numOption = 0;
        myTools.print("Bienvenido al menu de la PEVAL3");

        while(numOption != 7){
            try{

                numOption = myTools.keyBoardInt("Introduzca una de las opciones:" +
                        "\n0: Crear Base de Datos neodatis" +
                        "\n1: Dar de alta un libro" +
                        "\n2: Dar de baja un usuario" +
                        "\n3: Modificar un préstamo" +
                        "\n4: Préstamos con retardo de usuario" +
                        "\n5: Libro de un género según precio máximo" +
                        "\n6: Préstamo por provincia en x tiempo" +
                        "\n7: SALIR");
                switch (numOption){
                    case 0:
                         new TransferData(myConfig.getMYPATH(), myConfig.getDBNAME(), myConfig.getDBUSER());
                        break;
                    case 1:
                        String nombreLibro = myTools.keyBoardString("Introduzca el Titulo del Libro");
                        String editorial = myTools.keyBoardString("Introduzca la Editorial del Libro");
                        String autor = myTools.keyBoardString("Inrtoduzca el Autor del Libro");
                        String genero = myTools.keyBoardString("Introduzca el Genero del Libro");
                        String paisAutor = myTools.keyBoardString("Introduzca el Pais del Autor");
                        int numPags = myTools.keyBoardInt("Introduzca el Numero de Paginas del Libro");
                        int anyoEdicion = myTools.keyBoardInt("Introduzca el Anho de Edicion del Libro");
                        int precioLibro = myTools.keyBoardInt("Introduzca el Precio del Libro");

                        gest.newBook(myConfig.getMYPATH(), nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro);
                        break;
                    case 2:
                        gest.deleteUser(myConfig.getMYPATH());
                        break;
                    case 3:
                        myCons.editPrst(myConfig.getMYPATH());
                        break;
                    case 4:
                        myCons.prstData(myConfig.getMYPATH());
                        break;
                    case 5:
                        myCons.genreBook(myConfig.getMYPATH());
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    default: //default message if the user tries to use an option that doesnt exist
                        myTools.print("Opcion no válida");
                }
            }catch (InputMismatchException e) { //controlling that the user not introduce text
                myTools.print("Introduzca valores correctos");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

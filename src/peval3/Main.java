package peval3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class Main {
    private static Tools myTools = new Tools();
    private static MostrarDatos show = new MostrarDatos();
    private static Comprobaciones checkers = new Comprobaciones();
    private static Consultas myCons = new Consultas();
    private static Gestion gest = new Gestion();
    private static TransferData myTransferData;
    public static void main(String[] args) {


        String MYPATH = "D:\\2 DAM\\ACDA\\acda01\\src\\peval3\\biblioteca.neo";
        String DBNAME = "biblioteca";
        String DBUSER = "root";

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
                         new TransferData(MYPATH, DBNAME, DBUSER);
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

                        gest.newBook(MYPATH, nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro);
                        break;
                    case 2:
                        gest.deleteUser(MYPATH);
                        break;
                    case 3:
                        myCons.editPrst(MYPATH);
                        break;
                    case 4:
                        myCons.prstData(MYPATH);
                        break;
                    case 5:
                        myCons.genreBook(MYPATH);
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    default: //defaultt message if the user tries to use an option that doesnt exist
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

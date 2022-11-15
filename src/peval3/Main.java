package peval3;


import java.sql.SQLException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Tools myTools = new Tools();

        String MYPATH = "D:\\2 DAM\\ACDA\\acda01\\src\\peval3\\biblioteca.neo";

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
                        "\n4: Préstamos con retrado de usuario" +
                        "\n5: Libro de un género según precio máximo" +
                        "\n6: Préstamo por provincia en x tiempo" +
                        "\n7: SALIR");
                switch (numOption){
                    case 0:
                        new TransferData(MYPATH);
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

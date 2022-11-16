package peval3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class Main {
    private static Tools myTools = new Tools();

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
                        "\n4: Préstamos con retrado de usuario" +
                        "\n5: Libro de un género según precio máximo" +
                        "\n6: Préstamo por provincia en x tiempo" +
                        "\n7: SALIR");
                switch (numOption){
                    case 0:
                         new TransferData(MYPATH, DBNAME, DBUSER);
                        break;
                    case 1:
                        newBook(MYPATH);
                        break;
                    case 2:
                        deleteUser(MYPATH);
                        break;
                    case 3:
                        editPrst(MYPATH);
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

    private static void editPrst(String mypath) {
        ODB odb = ODBFactory.open(mypath);

        showPrst(odb);

        int code = myTools.keyBoardInt("Código del Préstamo a cambiar: ");

        IQuery getPrst = new CriteriaQuery(Prestamos.class, Where.equal("numeroPedido", code));

        try{
            Prestamos prestamos = (Prestamos) odb.getObjects(getPrst).getFirst();
            System.out.println("------------ Datos del Préstamo seleccionado ---------------" +
                    "\nNombre del Libro: " + prestamos.getCodigoLibro().getNombreLibro() +
                    "\nNombre del Usuario: " + prestamos.getCodigoUsuario().getNombre() +
                    "\n-------------------------------------------------------------");

            showUser(odb);

            int numUser = myTools.keyBoardInt("Introduzca el numero del nuevo usuario: ");

            try{
                IQuery getUser = new CriteriaQuery(Usuario.class, Where.equal("codigoUsuario", numUser));
                Usuario usuario = (Usuario) odb.getObjects(getUser).getFirst();
                prestamos.setCodigoUsuario(usuario);
                odb.store(usuario);
                odb.commit();
            }catch (IndexOutOfBoundsException e) {
                myTools.print("El usuario seleccionado no existe");
            }
        }catch (IndexOutOfBoundsException e) {
            myTools.print("El préstamo no existe");
        }

        odb.close();
    }

    private static void deleteUser(String mypath) {
        ODB odb = ODBFactory.open(mypath);
        showUser(odb);

        int codigoUsuario = myTools.keyBoardInt("Introduzca el código del Usuario");

        try{
            IQuery queryCode = new CriteriaQuery(Usuario.class, Where.equal("codigoUsuario", codigoUsuario));
            Usuario checkCode = (Usuario) odb.getObjects(queryCode).getFirst();
            deleteUserPrest(checkCode, odb);
            myTools.print("Borrando a:" +
                    "\n" + checkCode.getCodigoUsuario() +
                    "\n" +  checkCode.getNombre() +
                    "\n" + checkCode.getApellido() +
                    "\n" +  checkCode.getDni() +
                    "\n" +  checkCode.getDomicilio() +
                    "\n" +  checkCode.getPoblacion() +
                    "\n" +  checkCode.getProvincia() +
                    "\n" +  checkCode.getFechaNacimiento());
            odb.delete(checkCode);
            odb.commit();

        }catch (IndexOutOfBoundsException e){
            System.out.println("El usuario no existe");
        }

        odb.close();
    }

    private static void deleteUserPrest(Usuario checkCode, ODB odb) {
        IQuery queryUserCode = odb.criteriaQuery(Prestamos.class, Where.equal("codigoUsuario", checkCode));
        Prestamos checkPrst = (Prestamos) odb.getObjects(queryUserCode).getFirst();
        odb.delete(checkPrst);

        odb.commit();
    }


    /**
     * Method where we show to the user all Prestamos
     * @param odb ODB that has our Neodatis file
     */
    private static void showPrst(ODB odb) {
        Objects<Prestamos> objects = odb.getObjects(Prestamos.class);

        while(objects.hasNext()){
            Prestamos prestamo = objects.next();
            myTools.print("Numero de Pedido: " + prestamo.getNumeroPedido() +
                    "\nCodigo Libro: " +  prestamo.getCodigoLibro().getNombreLibro() +
                    "\nNombre Usuario: " +  prestamo.getCodigoUsuario().getNombre() +
                    "\nFecha Salida: " +  prestamo.getFechaSalida() +
                    "\nFecha Máxima de Devolución: " +  prestamo.getFechaMaxDevolucion() +
                    "\nFecha de Devolución: " +  prestamo.getFechaDevolucion());
            myTools.print("----------------------------------------------------");
        }
    }

    /**
     * Method where we show to the user all Usuarios
     * @param odb ODB that has our Neodatis file
     */
    private static void showUser(ODB odb) {
        Objects<Usuario> objects = odb.getObjects(Usuario.class);

        while(objects.hasNext()){
            Usuario user = objects.next();
            myTools.print("Código usuario " + user.getCodigoUsuario() +
                    "\nNombre: " + user.getNombre() +
                    "\nApellidos: " + user.getApellido() +
                    "\nDNI: " + user.getDni() +
                    "\nDomicilio: " + user.getDomicilio() +
                    "\nPoblación: " + user.getPoblacion() +
                    "\nProvincia: " + user.getProvincia() +
                    "\nFecha Nacimiento: " + user.getFechaNacimiento());
            myTools.print("----------------------------------------------------");
        }
    }

    private static void newBook(String mypath) {
        ODB odb = ODBFactory.open(mypath);


        int codigoMax = Integer.parseInt(odb.getValues(new ValuesCriteriaQuery(Libros.class).max("codigoLibro")).getFirst().getByAlias("codigoLibro").toString()) + 1;
        String nombreLibro = myTools.keyBoardString("Introduzca el Titulo del Libro");
        String editorial = myTools.keyBoardString("Introduzca la Editorial del Libro");
        String autor = myTools.keyBoardString("Inrtoduzca el Autor del Libro");
        String genero = myTools.keyBoardString("Introduzca el Genero del Libro");
        String paisAutor = myTools.keyBoardString("Introduzca el Pais del Autor");
        int numPags = myTools.keyBoardInt("Introduzca el Numero de Paginas del Libro");
        int anyoEdicion = myTools.keyBoardInt("Introduzca el Anho de Edicion del Libro");
        int precioLibro = myTools.keyBoardInt("Introduzca el Precio del Libro");

        if(!checkEditorial(editorial, odb) && !checkName(nombreLibro, odb)){
            odb.store(new Libros(codigoMax, nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro));
        }else if (checkName(nombreLibro, odb) && !checkEditorial(editorial, odb)){
            odb.store(new Libros(codigoMax, nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro));
        }else if (!checkName(nombreLibro, odb) && checkEditorial(editorial, odb)){
            odb.store(new Libros(codigoMax, nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro));
        }else{
            System.out.println("El libro NO se puede crear, ya  existe");
        }

        odb.commit();
        odb.close();
    }

    private static boolean checkName(String nombreLibro, ODB odb) {
        boolean exists = false;

        try{
            IQuery queryNombre = new CriteriaQuery(Libros.class, Where.equal("nombreLibro", nombreLibro));
            Libros checkName = (Libros) odb.getObjects(queryNombre).getFirst();
            exists = false;
        }catch (IndexOutOfBoundsException e){
            exists = true;
        }

        return exists;
    }

    private static boolean checkEditorial(String editorial, ODB odb) {
        boolean exists = false;

        try{
            IQuery queryNombre = new CriteriaQuery(Libros.class, Where.equal("nombreLibro", editorial));
            Libros checkNamse = (Libros) odb.getObjects(queryNombre).getFirst();
            System.out.println("El editorial existe");
            exists = false;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Editorial no existe");
            exists = false;
        }

        return exists;
    }
}

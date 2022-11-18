package peval3;

/**
 * @author José Ramón Gallego Vélez
 * @project peval3acda2223
 * @version v0
 * @info Class where we´ll manage our db
 */

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Gestion {

    /**
     * Classes that we use
     */
    private static Tools myTools = new Tools();
    private static MostrarDatos show = new MostrarDatos();
    private static Comprobaciones checkers = new Comprobaciones();

    /**
     * Method to delete the Usuario that the user give to us
     * @param mypath String with the path of our neodatis file
     */
    public static void deleteUser(String mypath) {
        ODB odb = ODBFactory.open(mypath);
        show.showUser(odb);

        int codigoUsuario = myTools.keyBoardInt("Introduzca el código del Usuario");

        IQuery queryCode = new CriteriaQuery(Usuario.class, Where.equal("codigoUsuario", codigoUsuario));

        try{
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
                    "\n" +  checkCode.getFechaNacimiento() +
                    "\n-------------------------------------------------");
            odb.delete(checkCode);
            odb.commit();
            myTools.print("Usuario borrado!!");
        }catch (IndexOutOfBoundsException e){
            System.out.println("El usuario no existe");
        }

        odb.close();
    }

    /**
     * Method to delete all Prestamo data of the user deleted
     * @param user Usuario data that we´ll delete
     * @param odb ODB with our Neodatis db open
     */
    public static void deleteUserPrest(Usuario user, ODB odb) {
        IQuery queryUserCode = odb.criteriaQuery(Prestamos.class, Where.equal("codigoUsuario", user));
        Prestamos checkPrst = (Prestamos) odb.getObjects(queryUserCode).getFirst();
        odb.delete(checkPrst);

        odb.commit();
    }

    /**
     * Method to create a new book in our db checking that it cannot be created if it exists
     * @param mypath String with the path of our neodatis file
     * @param nombreLibro String with the name of the book given by the user
     * @param editorial String with the editorial of the book given by the user
     * @param autor String with the author of the book given by the user
     * @param genero String with the genre of the book given by the user
     * @param paisAutor String with the country of the author given by the user
     * @param numPags String with the pages count of the book given by the user
     * @param anyoEdicion String with the year of the book´s edition given by the user
     * @param precioLibro String with the price of the book given by the user
     */
    public static void newBook(String mypath, String nombreLibro, String editorial, String autor, String genero, String paisAutor, int numPags, int anyoEdicion, int precioLibro) {
        ODB odb = ODBFactory.open(mypath);

        int codigoMax = Integer.parseInt(odb.getValues(new ValuesCriteriaQuery(Libros.class).max("codigoLibro")).getFirst().getByAlias("codigoLibro").toString()) + 1;

        if(!checkers.checkEditorial(editorial, odb) && !checkers.checkName(nombreLibro, odb)){
            odb.store(new Libros(codigoMax, nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro));
        }else if (checkers.checkName(nombreLibro, odb) && !checkers.checkEditorial(editorial, odb)){
            odb.store(new Libros(codigoMax, nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro));
        }else if (!checkers.checkName(nombreLibro, odb) && checkers.checkEditorial(editorial, odb)){
            odb.store(new Libros(codigoMax, nombreLibro, editorial, autor, genero, paisAutor, numPags, anyoEdicion, precioLibro));
        }else{
            System.out.println("El libro NO se puede crear, ya  existe");
        }

        odb.commit();
        odb.close();
    }
}

package peval3;

/**
 * @author José Ramón Gallego Vélez
 * @project peval3acda2223
 * @version v0
 * @info Class where we have methods to check if certain data exists or not
 */

import org.neodatis.odb.ODB;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Comprobaciones {

    /**
     * Method to check if the name of the book exists in our database
     * @param nombreLibro String for the name given by the user
     * @param odb ODB that has our neodatis database open
     * @return Boolean to set if exists or not
     */
    public static boolean checkName(String nombreLibro, ODB odb) {
        boolean exists = false;

        try{
            IQuery queryNombre = new CriteriaQuery(Libros.class, Where.equal("nombreLibro", nombreLibro));
            Libros checkName = (Libros) odb.getObjects(queryNombre).getFirst();
            exists = true;
        }catch (IndexOutOfBoundsException e){
            exists = false;
        }

        return exists;
    }

    /**
     * Method to check if the Editorial of the book exists in our database
     * @param editorial String for the editorial given by the user
     * @param odb ODB that has our neodatis database open
     * @return Boolean to set if exists or not
     */
    public static boolean checkEditorial(String editorial, ODB odb) {
        boolean exists = false;

        try{
            IQuery queryNombre = new CriteriaQuery(Libros.class, Where.equal("nombreLibro", editorial));
            Libros checkNamse = (Libros) odb.getObjects(queryNombre).getFirst();
            System.out.println("El editorial existe");
            exists = true;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Editorial no existe");
            exists = false;
        }

        return exists;
    }

    /**
     * Method to check if the Genero of the book exists in our database
     * @param genero String for the genero given by the user
     * @param odb ODB that has our neodatis database open
     * @return Boolean to ser if exists or not
     */
    public static boolean checkGenero(String genero, ODB odb){
        boolean exists = false;

        try{
            IQuery queryGenero = new CriteriaQuery(Libros.class, Where.equal("genero", genero));
            Libros checkGnr = (Libros) odb.getObjects(queryGenero).getFirst();
            exists = true;
        }catch (IndexOutOfBoundsException e){
            exists = false;
        }

        return exists;
    }
}

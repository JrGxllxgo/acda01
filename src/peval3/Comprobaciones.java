package peval3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Comprobaciones {

    public static boolean checkName(String nombreLibro, ODB odb) {
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

    public static boolean checkEditorial(String editorial, ODB odb) {
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

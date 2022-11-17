package peval3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Gestion {

    private static Tools myTools = new Tools();
    private static MostrarDatos show = new MostrarDatos();
    private static Comprobaciones checkers = new Comprobaciones();
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
                    "\n" +  checkCode.getFechaNacimiento());
            odb.delete(checkCode);
            odb.commit();

        }catch (IndexOutOfBoundsException e){
            System.out.println("El usuario no existe");
        }

        odb.close();
    }

    public static void deleteUserPrest(Usuario checkCode, ODB odb) {
        IQuery queryUserCode = odb.criteriaQuery(Prestamos.class, Where.equal("codigoUsuario", checkCode));
        Prestamos checkPrst = (Prestamos) odb.getObjects(queryUserCode).getFirst();
        odb.delete(checkPrst);

        odb.commit();
    }

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

package peval3;

/**
 * @author José Ramón Gallego Vélez
 * @project peval3acda2223
 * @version v0
 * @info Class where we do our queries
 */

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Consultas {

    /**
     * Classes that we´ll use
     */
    private static Tools myTools = new Tools();
    private static MostrarDatos show = new MostrarDatos();
    private static Comprobaciones check = new Comprobaciones();

    /**
     * Method to get the genre of our book depending on a maximum price
     * @param mypath String with the path of our neodatis file
     */
    public static void genreBook(String mypath) {
        ODB odb = ODBFactory.open(mypath);

        show.showBooks(odb);

        String generoLibro = myTools.keyBoardString("Introduzca el Genero del Libro: ");
        int precioTope = myTools.keyBoardInt("Introduzca el Precio Maximo a consultar: ");

        if(check.checkGenero(generoLibro, odb)){
            ICriterion criterion = new And().add(Where.equal("genero", generoLibro)).add(Where.le("precioLibro", precioTope));
            IQuery getLibros = new CriteriaQuery(Libros.class, criterion);
            Objects<Libros> libros = odb.getObjects(getLibros);

            while(libros.hasNext()){
                Libros libros1 = libros.next();
                myTools.print("Nombre del libro: " + libros1.getNombreLibro() +
                        "\nGenero del libro: " + libros1.getGenero() +
                        "\nPrecio del libro: " + libros1.getPrecioLibro() +
                        "\n----------------------------");
            }
        }else{
            myTools.print("El genero introducido no existe");
        }

        odb.close();
    }

    /**
     * Method to get the data of our prestamo
     * @param mypath String with the path of our neodatis file
     */
    public static void prstData(String mypath) {
        ODB odb = ODBFactory.open(mypath);
        show.showUser(odb);

        int codigoUsuario = myTools.keyBoardInt("Introduzca el código del Usuario");

        IQuery queryUserCode = new CriteriaQuery(Usuario.class, Where.equal("codigoUsuario", codigoUsuario));

        try{
            Usuario user = (Usuario) odb.getObjects(queryUserCode).getFirst();
            IQuery queryPrst = odb.criteriaQuery(Prestamos.class, Where.equal("codigoUsuario", user));
            Objects<Prestamos> prestamosUsuario = odb.getObjects(queryPrst);

            while (prestamosUsuario.hasNext()){
                Prestamos myPrst = prestamosUsuario.next();
                ICriterion compareFecha = Where.gt("fechaDevolucion",myPrst.getFechaMaxDevolucion());
                CriteriaQuery queryFechas = new CriteriaQuery(Prestamos.class, compareFecha);

                Prestamos prst = (Prestamos) odb.getObjects(queryFechas).getFirst();

                myTools.print("Prestamo con retardo: "  + prst.getNumeroPedido() +
                        "\n--------------------------------------------");
            }

        }catch (IndexOutOfBoundsException e){
            myTools.print("El usuario no existe");
        }

        odb.close();
    }

    /**
     * Method to edit the Usuario in a certain Prestamo
     * @param mypath String with the path of our neodatis file
     */
    public static void editPrst(String mypath) {
        ODB odb = ODBFactory.open(mypath);

        show.showPrst(odb);

        int code = myTools.keyBoardInt("Código del Préstamo a cambiar: ");

        IQuery getPrst = new CriteriaQuery(Prestamos.class, Where.equal("numeroPedido", code));

        try{
            Prestamos prestamos = (Prestamos) odb.getObjects(getPrst).getFirst();
            System.out.println("------------ Datos del Préstamo seleccionado ---------------" +
                    "\nNombre del Libro: " + prestamos.getCodigoLibro().getNombreLibro() +
                    "\nNombre del Usuario: " + prestamos.getCodigoUsuario().getNombre() +
                    "\n-------------------------------------------------------------");

            show.showUser(odb);

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
}

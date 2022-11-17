package peval3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Consultas {
    private static Tools myTools = new Tools();
    private static MostrarDatos show = new MostrarDatos();
    public static void genreBook(String mypath) {
    }

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

                System.out.println(prst.getNumeroPedido());
            }

        }catch (IndexOutOfBoundsException e){
            myTools.print("El usuario no existe");
        }

        odb.close();
    }

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

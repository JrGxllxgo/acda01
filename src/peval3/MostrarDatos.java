package peval3;

/**
 * @author José Ramón Gallego Vélez
 * @project peval3acda2223
 * @version v0
 * @info Class to show some certain data
 */

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class MostrarDatos {

    Tools myTools = new Tools();

    /**
     * Method where we show to the user all Books
     * @param odb ODB that has our Neodatis file
     */
    public void showBooks(ODB odb){
        Objects<Libros> objects = odb.getObjects(Libros.class);

        while(objects.hasNext()){
            Libros libro = objects.next();
            myTools.print("Codigo Libro: " + libro.getCodigoLibro() +
                    "\nNombre Libro: " + libro.getNombreLibro() +
                    "\nGenero: " + libro.getGenero() +
                    "\nPrecio Libro: " + libro.getPrecioLibro());
            myTools.print("----------------------------------------------------");
        }
    }

    /**
     * Method where we show to the user all Prestamos
     * @param odb ODB that has our Neodatis file
     */
    public void showPrst(ODB odb) {
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
    public void showUser(ODB odb) {
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
}

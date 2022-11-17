package peval3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class MostrarDatos {

    Tools myTools = new Tools();

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

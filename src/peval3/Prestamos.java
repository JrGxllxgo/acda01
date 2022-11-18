package peval3;

import java.util.Date;

/**
 * @author José Ramón Gallego Vélez
 * @project peval3acda2223
 * @version v0
 * @info Class with prestamos data
 */

public class Prestamos {

    /**
     * Integer for order number
     */
    private int numeroPedido;
    /**
     * Atribute type Usuario for the user data
     */
    private Libros codigoLibro;
    /**
     * Atribute type Libros for the book data
     */
    private Usuario codigoUsuario;
    /**
     * Date for exit date
     */
    private Date fechaSalida;
    /**
     * Date for the maximum date to return the book
     */
    private Date fechaMaxDevolucion;
    /**
     * Date for date of the return
     */
    private Date fechaDevolucion;

    /**
     * Constructor of Pedidos class
     *
     * @param numeroPedido Integer for order number
     * @param codigoLibro Atribute type Libros for the book data
     * @param codigoUsuario Atribute type Usuario for the user data
     * @param fechaSalida String for exit date
     * @param fechaMaxDevolucion String for the maximum date to return the book
     * @param fechaDevolucion String for date of the return
     */
    public Prestamos(int numeroPedido, Libros codigoLibro, Usuario codigoUsuario, String fechaSalida, String fechaMaxDevolucion, String fechaDevolucion) {
        this.numeroPedido = numeroPedido;
        this.codigoLibro = codigoLibro;
        this.codigoUsuario = codigoUsuario;
        this.fechaSalida = new Tools().transformDate(fechaSalida);
        this.fechaMaxDevolucion = new Tools().transformDate(fechaMaxDevolucion);
        this.fechaDevolucion = new Tools().transformDate(fechaDevolucion);
    }

    /**
     * Generate GETTERS Y SETTERS
     */
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Libros getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Libros codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaMaxDevolucion() {
        return fechaMaxDevolucion;
    }

    public void setFechaMaxDevolucion(Date fechaMaxDevolucion) {
        this.fechaMaxDevolucion = fechaMaxDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

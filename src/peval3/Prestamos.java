package peval3;

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
     * String for exit date
     */
    private String fechaSalida;
    /**
     * String for the maximum date to return the book
     */
    private String fechaMaxDevolucion;
    /**
     * String for date of the return
     */
    private String fechaDevolucion;

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
        this.fechaSalida = fechaSalida;
        this.fechaMaxDevolucion = fechaMaxDevolucion;
        this.fechaDevolucion = fechaDevolucion;
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

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaMaxDevolucion() {
        return fechaMaxDevolucion;
    }

    public void setFechaMaxDevolucion(String fechaMaxDevolucion) {
        this.fechaMaxDevolucion = fechaMaxDevolucion;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

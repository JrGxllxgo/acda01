package peval3;

public class Libros {

    /**
     * Integer for book´s code
     */
    private int codigoLibro;
    /**
     * String for book´s tittle
     */
    private String nombreLibro;
    /**
     * String for book´s editorial
     */
    private String editorial;
    /**
     * String for book´s author
     */
    private String autor;
    /**
     * String for book´s genre
     */
    private String genero;
    /**
     * String for book´s author country
     */
    private String paisAutor;
    /**
     * Integer for the number of pages
     */
    private int numeroPaginas;
    /**
     * Integer for edition year
     */
    private int anyoEdicion;
    /**
     * Integer for book´s price
     */
    private int precioLibro;

    /**
     * Constructor of the Libros class
     *
     * @param codigoLibro Integer for book´s code
     * @param nombreLibro String for book´s tittle
     * @param editorial String for book´s editorial
     * @param autor String for book´s author
     * @param genero String for book´s genre
     * @param paisAutor String for book´s author country
     * @param numeroPaginas Integer for the number of pages
     * @param anyoEdicion Integer for edition year
     * @param precioLibro Integer for book´s price
     */
    public Libros(int codigoLibro, String nombreLibro, String editorial, String autor, String genero, String paisAutor, int numeroPaginas, int anyoEdicion, int precioLibro) {
        this.codigoLibro = codigoLibro;
        this.nombreLibro = nombreLibro;
        this.editorial = editorial;
        this.autor = autor;
        this.genero = genero;
        this.paisAutor = paisAutor;
        this.numeroPaginas = numeroPaginas;
        this.anyoEdicion = anyoEdicion;
        this.precioLibro = precioLibro;
    }

    /**
     * Generate GETTERS Y SETTERS
     */

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisAutor() {
        return paisAutor;
    }

    public void setPaisAutor(String paisAutor) {
        this.paisAutor = paisAutor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getAnyoEdicion() {
        return anyoEdicion;
    }

    public void setAnyoEdicion(int anyoEdicion) {
        this.anyoEdicion = anyoEdicion;
    }

    public int getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(int precioLibro) {
        this.precioLibro = precioLibro;
    }
}

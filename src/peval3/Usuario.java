package peval3;

public class Usuario {

    /**
     * Integer for the user code
     */
    private int codigoUsuario;
    /**
     * String for user name
     */
    private String nombre;
    /**
     * String for user surname
     */
    private String apellido;
    /**
     * String for user id
     */
    private String dni;
    /**
     * String for user adress
     */
    private String domicilio;
    /**
     * String for user town
     */
    private String poblacion;
    /**
     * String for user province
     */
    private String provincia;
    /**
     * String for user birthdate
     */
    private String fechaNacimiento;

    /**
     * Constructor of the User
     *
     * @param codigoUsuario Integer for the user code
     * @param nombre String for user name
     * @param apellido String for user surname
     * @param dni String for user id
     * @param domicilio String for user adress
     * @param poblacion String for user town
     * @param provincia String for user province
     * @param fechaNacimiento String for user birthdate
     */
    public Usuario(int codigoUsuario, String nombre, String apellido, String dni, String domicilio, String poblacion, String provincia, String fechaNacimiento) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Generate GETTERS Y SETTERS
     */
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

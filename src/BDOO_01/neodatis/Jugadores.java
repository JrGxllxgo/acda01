package BDOO_01.neodatis;

public class Jugadores {
    private String nombre;
    private String ciudad;
    private String deporte;
    private int edad;

    public Jugadores (String nombre, String deporte, String ciudad, int edad){
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.deporte=deporte;
        this.edad=edad;
    }

    //GETTERS Y SETTERS
    public String getNombre(){return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String dir){this.ciudad=dir;}
    public String getCiudad() {
        return ciudad;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

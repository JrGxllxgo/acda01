package BDOO_01;

public class E1Persona {
    private String nombre;
    private String ciudad;

    public E1Persona (String nombre, String ciudad){
        this.nombre=nombre;
        this.ciudad=ciudad;
    }
    public E1Persona(){
        this.nombre=null;
        this.ciudad=null;


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
}


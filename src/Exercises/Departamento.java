package Exercises;

import java.io.Serializable;

public class Departamento implements Serializable {
    int num;
    String nombre;
    String localidad;

    public Departamento(int num,String nomnbre,String localidad){
        this.num = num;
        this.nombre = nomnbre;
        this.localidad = localidad;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}

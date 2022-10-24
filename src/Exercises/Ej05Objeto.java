package Exercises;

import java.io.*;

public class Ej05Objeto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File(Rutas.RUTA_DEPARTAMENTO_OBJETO);


        FileOutputStream fileout=new FileOutputStream(f);
        ObjectOutputStream dataOS=new ObjectOutputStream(fileout);
        FileInputStream filein = new FileInputStream(f);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        Departamento departamento;

        int[] numDpto = {1, 2, 3, 4, 5};
        String[] nombreDpto = {"Dpto1", "Dpto2", "Dpto3", "Dpto4", "Dpto5"};
        String[] localidadDpto = {"Málaga", "Albacete", "Churriana", "Alhaurín", "Madrid"};

        for (int i = 0; i < numDpto.length; i++) {
            departamento = new Departamento(numDpto[i],nombreDpto[i],localidadDpto[i]);
            dataOS.writeObject(departamento);
        }
        dataOS.close();

        try {
            while (true) {
                departamento = (Departamento) dataIS.readObject();
                System.out.println("Identificador: " + departamento.getNum() + " Nombre: " + departamento.getNombre() + " Localidad: " + departamento.getLocalidad());
            }
        } catch (EOFException e) {
            dataIS.close();
        }
    }
}

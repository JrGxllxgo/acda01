package BDOO_01.db4;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1Reader {

    final static String BDPER = "D:/2 DAM/ACDA/db/db4o/DBE1Persona.yap";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(BDPER);
        //LEER TODOS LOS REGISTROS
        System.out.println("Todas las personas son:");
        E1Persona per = new E1Persona(null, null);
        ObjectSet<E1Persona> result = db.queryByExample(per);
        if (result.size() == 0) {
            System.out.println("No existen Registros de Personas.. ");
        } else {
            System.out.println("Número de registros: " + result.size());

            while (result.hasNext()) {
                E1Persona p = result.next();
                System.out.println("Nombre: " + p.getNombre() + ", Ciudad:" + p.getCiudad());
            }
        }

        //LEER SÓLO LOS REGISROS DE AQUELLOS LLAMADOS Enrique
        System.out.println("Todos los Enrique son...");
        E1Persona perEnrique = new E1Persona("Enrique", null);
        ObjectSet<E1Persona> resultEnrique = db.queryByExample(perEnrique);
        if (resultEnrique.size() == 0) {
            System.out.println("No existen Registros de Personas.. ");
        } else {
            System.out.println("Número de registros: " + resultEnrique.size());

            while (resultEnrique.hasNext()) {
                E1Persona p = resultEnrique.next();
                System.out.println("Nombre: " + p.getNombre() + ", Ciudad: " + p.getCiudad());
            }
        }

        //LEER SÓLO LOS REGISTROS DE AQUELLAS PERSONAS QUE VIVAN EN Madrid
        System.out.println("En Madrid viven...");
        E1Persona perMadrid = new E1Persona(null, "Madrid");
        ObjectSet<E1Persona> resultMadrid = db.queryByExample(perMadrid);
        if (resultMadrid.size() == 0) {
            System.out.println("No existen Registros de Personas.. ");
        } else {
            System.out.println("Número de registros: " + resultMadrid.size());

            while (resultMadrid.hasNext()) {
                E1Persona p = resultMadrid.next();
                System.out.println("Nombre: " + p.getNombre() + ", Ciudad: " + p.getCiudad());
            }
        }

        //CIERRA LA BASE DE DATOS
        db.close();
    }
}

package BDOO_01;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class EjemploNeodatis {
    public static void main(String[] args) {

        //Crear instancias para almacenar en BD
        Jugadores j1 = new Jugadores("Maria", "volleyball", "Madrid", 14);
        Jugadores j2 = new Jugadores("Miguel", "tenis", "Madrid", 15);
        Jugadores j3 = new Jugadores("Mario", "baloncesto", "Guadalajara", 15);
        Jugadores j4 = new Jugadores("Alicia", "tenis", "Madrid", 14);

        ODB odb = ODBFactory.open("D:/2 DAM/ACDA/db/neodatis/jugadores.neo");

        //Almacenamos objetos
        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(j4);

        //recuperamos todos los datos
        Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
        System.out.printf("%d Jugadores: %n", objects.size());

        int i = 1;
        //visualizamos objetos
        while(objects.hasNext()){
            Jugadores jug = objects.next();
            System.out.printf("%d: %s, %s, %s, %d %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad());
        }

        odb.close();
    }
}

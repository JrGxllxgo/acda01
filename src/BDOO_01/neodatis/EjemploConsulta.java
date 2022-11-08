package BDOO_01.neodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class EjemploConsulta {
    public static void main(String[] args) {

        ODB odb = ODBFactory.open("D:/2 DAM/ACDA/db/neodatis/jugadores.neo");

        consultaQuery(odb);

        //updateQuery(odb);
    }

    private static void updateQuery(ODB odb) {
        IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("nombre","Miguel"));

        Objects<Jugadores> objects = odb.getObjects(query);

        Jugadores jug = (Jugadores) objects.getFirst();
        jug.setDeporte("Baloncesto");
        odb.store(jug);

        int i = 1;
        while(objects.hasNext()){
            objects.next();
            System.out.printf("%d: %s, %s, %s, %d, %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad());
        }

        odb.commit();
        odb.close();
    }

    private static void consultaQuery(ODB odb) {
        IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte","baloncesto"));
        query.orderByAsc("nombre,edad");

        Objects<Jugadores> objects = odb.getObjects(query);
        System.out.printf("%d Jugadores: %n", objects.size());

        int i = 1;
        while(objects.hasNext()){
            Jugadores jug = objects.next();
            System.out.printf("%d: %s, %s, %s, %d, %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad());
        }

        odb.close();
    }
}

package BDOO_01.neodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

public class EjemploOID {

    public static void main(String[] args) {
        //abro base de datos
        ODB odb = ODBFactory.open("D:/2 DAM/ACDA/db/neodatis/jugadores.neo");

        //obtengo el objeto con el oid 5
        OID oid = OIDFactory.buildObjectOID(5);

        Jugadores jug = (Jugadores) odb.getObjectFromId(oid);
        System.out.println(jug.getNombre() + "*" + jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
        odb.delete(jug);
        odb.commit();
        odb.close();
    }
}

package exercisesBdoo;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class ViewInformation {
    public static void main(String[] args) {

        ODB odb = ODBFactory.open("D:/2 DAM/ACDA/db/neodatis/equipos.neo");

        IQuery query = new CriteriaQuery(Players.class, Where.equal("countryName", "Portugal"));
        query.orderByAsc("nombre,edad");

        Objects<Players> objects = odb.getObjects(query);
        System.out.printf("%d Jugadores: %n", objects.size());

        int i = 1;
        while (objects.hasNext()) {
            Players ply = objects.next();
            System.out.printf("%d: %s, %s, %s, %d, %n", i++, ply.getName(), ply.getSport(), ply.getCountry(), ply.getAge());
        }

        odb.close();
    }
}

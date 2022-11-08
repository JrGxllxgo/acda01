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

        Objects<Country> objCountry =  odb.getObjects(Country.class);
        System.out.printf("%d Countries: %n", objCountry.size());

        int i = 1;
        while(objCountry.hasNext()){
            Country country = objCountry.next();
            System.out.printf("%d: %s %n", i++, country.getCountryName());

            Objects<Players> objPlayer = odb.getObjects(Players.class);

            int j = 1;
            while(objPlayer.hasNext()){
                Players player = objPlayer.next();
                if(player.getCountry().getCountryName().equals(country.getCountryName())){
                    System.out.printf("\t %d: %s, %s, %d %n", j++, player.getName(), player.getSport(), player.getAge());
                }
            }
        }

        odb.close();
    }
}

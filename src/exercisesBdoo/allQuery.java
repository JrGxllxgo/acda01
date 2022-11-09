package exercisesBdoo;

import BDOO_01.neodatis.Jugadores;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;

public class allQuery {
    public static void main(String[] args) {

        ODB odb = ODBFactory.open("D:/2 DAM/ACDA/db/neodatis/equipos.neo");

        viewCountryData(odb);
        //deleteData(odb);
        //createPlayer(odb);
        odb.close();
    }

    private static void createPlayer(ODB odb) {
    }

    private static void deleteData(ODB odb) {

        OID oid = OIDFactory.buildObjectOID(5);

        Players players = (Players) odb.getObjectFromId(oid);
        System.out.println("Deleting player -->" + players.getName() + "*" + players.getSport() + "*" + players.getCountry().getCountryName() + "*" + players.getAge());
        odb.delete(players);
        odb.commit();
    }

    private static void viewCountryData(ODB odb) {
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
    }
}

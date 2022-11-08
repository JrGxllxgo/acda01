package exercisesBdoo;

import BDOO_01.neodatis.Jugadores;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class main {
    public static void main(String[] args) {
        //creo los paises
        Country c1 = new Country(0,"Espana");
        Country c2 = new Country(1, "Portugal");
        Country c3 = new Country(2, "Alemania");

        //Creo los jugadores
        Players j1 = new Players("Maria", "volleyball", c1, 14);
        Players j2 = new Players("Miguel", "tenis", c1, 15);
        Players j3 = new Players("Mario", "baloncesto", c2, 15);
        Players j4 = new Players("Alicia", "tenis", c3, 14);

        ODB odb = ODBFactory.open("D:/2 DAM/ACDA/db/neodatis/equipos.neo");

        //Almacenamos en la base de datos
        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(j4);

        odb.close();
    }
}

package BDOO_01;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
public class E1Principal {
    final static String BDPer = "D:/2 DAM/ACDA/db/db4o/DBE1Persona.yap";
    public static void main(String[] args) {
        ObjectContainer
                db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDPer);

        //Creamos E1Personas
        E1Persona p1 = new E1Persona ("Juan", "Guadalajara");
        E1Persona p2 = new E1Persona ("María", "Madrid");
        E1Persona p3 = new E1Persona ("Enrique", "Málaga");
        E1Persona p4 = new E1Persona ("Manuel", "Sevilla");

        //Almacenar objetos Persona en la base de datos
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);

        //Cerramos la base de datos
        db.close();
    }
}

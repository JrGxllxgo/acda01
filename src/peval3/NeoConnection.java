package peval3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import java.sql.SQLException;

public class NeoConnection {

    private DBConnection sqlDB =  new DBConnection();
    NeoConnection(String MYPATH) throws SQLException {
        ODB odb = ODBFactory.open(MYPATH);
        setBooksData(odb);
        setUserData(odb);
        setPrestamosDatos(odb);
    }

    private void setPrestamosDatos(ODB odb) {
    }

    private void setBooksData(ODB odb) throws SQLException {
        while(sqlDB.getBooksData().next()){
            new Libros(sqlDB.getBooksData().getInt(1),
                    sqlDB.getBooksData().getString(2),
                    sqlDB.getBooksData().getString(3),
                    sqlDB.getBooksData().getString(4),
                    sqlDB.getBooksData().getString(5),
                    sqlDB.getBooksData().getString(6),
                    sqlDB.getBooksData().getInt(7),
                    sqlDB.getBooksData().getInt(8),
                    sqlDB.getBooksData().getInt(9));
        }
    }

    private void setUserData(ODB odb) throws SQLException {
        while(sqlDB.getUsersData().next()){
            new Usuario(sqlDB.getUsersData().getInt(1),
                    sqlDB.getUsersData().getString(2),
                    sqlDB.getUsersData().getString(3),
                    sqlDB.getUsersData().getString(4),
                    sqlDB.getUsersData().getString(5),
                    sqlDB.getUsersData().getString(6),
                    sqlDB.getUsersData().getString(7),
                    sqlDB.getUsersData().getString(8));
        }
    }
}

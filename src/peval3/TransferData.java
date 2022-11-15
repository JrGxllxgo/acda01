package peval3;

import java.sql.*;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class TransferData {
    private Statement myStatement;

    TransferData(String MYPATH) throws SQLException {
        createBDConnection();
        createNeoDB(MYPATH);
    }

    private void createNeoDB(String MYPATH) throws SQLException {
        ODB odb = ODBFactory.open(MYPATH);
        setBooksData(odb);
        setUsersData(odb);
        setPtmosData(odb);
        odb.close();
    }

    public void createBDConnection() {
        try {

            //starting the driver
            Class.forName("com.mysql.jdbc.Driver");

            //stablishing the connection
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblioteca",
                    "root", "");

            //startint the statement for the methods
            myStatement = (Statement) connection.createStatement();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBooksData(ODB odb) throws SQLException {
        ResultSet bookRs = myStatement.executeQuery("SELECT * FROM libros");

        while(bookRs.next()){
            odb.store(new Libros(bookRs.getInt(1),
                    bookRs.getString(2),
                    bookRs.getString(3),
                    bookRs.getString(4),
                    bookRs.getString(5),
                    bookRs.getString(6),
                    bookRs.getInt(7),
                    bookRs.getInt(8),
                    bookRs.getInt(9)));
            System.out.println(bookRs.getString(2) + "creado");
        }

        bookRs.close();
        odb.commit();
    }

    public void setUsersData(ODB odb) throws SQLException {
        ResultSet userRs = myStatement.executeQuery("SELECT * FROM usuario");

        while (userRs.next()){
            odb.store(new Usuario(userRs.getInt(1),
                    userRs.getString(2),
                    userRs.getString(3),
                    userRs.getString(4),
                    userRs.getString(5),
                    userRs.getString(6),
                    userRs.getString(7),
                    userRs.getString(8)));
        }

        userRs.close();
        odb.commit();
    }

    public void setPtmosData(ODB odb) throws SQLException {
        ResultSet ptmosRs = myStatement.executeQuery("SELECT * FROM prestamos");

        while(ptmosRs.next()){
            odb.store(new Prestamos(ptmosRs.getInt(1),
                    (Libros) odb.getObjects(new CriteriaQuery(Libros.class, Where.equal("codigoLibro", ptmosRs.getInt(2)))).getFirst(),
                    (Usuario) odb.getObjects(new CriteriaQuery(Usuario.class, Where.equal("codigoUsuario", ptmosRs.getInt(3)))).getFirst(),
                    ptmosRs.getString(4),
                    ptmosRs.getString(5),
                    ptmosRs.getString(6)));
        }
        ptmosRs.close();
        odb.commit();
    }
}

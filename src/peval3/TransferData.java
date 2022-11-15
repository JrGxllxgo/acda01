package peval3;

import java.sql.*;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class TransferData {
    private Statement myStatement;

    private ODB odb;
    TransferData(String MYPATH, String DBNAME, String DBUSER) throws SQLException {
        createBDConnection(DBNAME, DBUSER);
        createNeoDB(MYPATH);
    }

    /**
     * Method to create our Neodatis file and call others to add data
     * @param MYPATH String that has the file path
     * @throws SQLException
     */
    public void createNeoDB(String MYPATH) throws SQLException {
        odb = ODBFactory.open(MYPATH);
        setBooksData(odb);
        setUsersData(odb);
        setPtmosData(odb);
        odb.close();
    }

    /**
     * Method were we create the connection with the DB
     */
    public void createBDConnection(String DBNAME, String DBUSER) {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + DBNAME,
                    DBUSER, "");

            myStatement = (Statement) connection.createStatement();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method were we get data from Libros at our DB and transfer it to our neodatis file
     * @param odb ODB for our neo file
     * @throws SQLException
     */
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

    /**
     * Method were we get data from Usuario at our DB and transfer it to our neodatis file
     * @param odb ODB for our neo file
     * @throws SQLException
     */
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

    /**
     * Method were we get data from Prestamos at our DB and transfer it to our neodatis file
     * @param odb ODB for our neo file
     * @throws SQLException
     */
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

    public ODB getOdb() {
        return odb;
    }
}

package peval3;

import java.sql.*;

public class DBConnection {
    private Statement myStatement;

    DBConnection(){
        createBDConnection();
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

    public ResultSet getBooksData() throws SQLException {
        ResultSet bookRs = myStatement.executeQuery("SELECT * FROM libros");

        return bookRs;
    }

    public ResultSet getUsersData() throws SQLException {
        ResultSet userRs = myStatement.executeQuery("SELECT * FROM usuarios");

        return userRs;
    }

    public ResultSet getPtmosData() throws SQLException {
        ResultSet ptmosRs = myStatement.executeQuery("SELECT * FROM prestamos");

        return ptmosRs;
    }
}

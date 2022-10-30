package peval2acda2223;

import java.io.IOException;
import java.sql.*;

public class DBConnection {

    private String myQuery;
    private Statement myStatement;

    DBConnection(){
        createBDConnection();
    }

    public void createBDConnection(){
        try {
            // cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // establecemos la conexion con la BD
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/basketlitle",
                    "root", "");

            // preparamos la consulta
            myStatement = (Statement) conexion.createStatement();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeInsertQuery(String localTeam, String visitorTeam, int localPts, int visitorPts, String season) throws SQLException {
        ResultSet rs = myStatement.executeQuery("SELECT MAX(codigo) FROM partidos");
        rs.next();
        int matchCode = rs.getInt("MAX(codigo)")+1;
        myStatement.executeUpdate(String.format("INSERT INTO partidos VALUES ('%d', '%s', '%s', '%d', '%d', '%s')", matchCode, localTeam, visitorTeam, localPts, visitorPts, season));

        System.out.println("Partido anadido");

        rs.close();
    }
    public void executeSelectQuery(String city) throws SQLException, IOException {
        ResultSet rs = myStatement.executeQuery(String.format("SELECT j.Nombre,j.Altura, j.Peso, j.Posicion, e.Nombre FROM jugadores j, equipos e WHERE (j.Nombre_equipo= e.Nombre) AND e.Ciudad LIKE '%s'", city));

        printResultColumns(rs);

        rs.close(); // Cerrar ResultSet
    }

    public void executeUpdateQuery() throws SQLException {
        myStatement.executeUpdate("UPDATE jugadores SET Posicion = 'PIVOTE' WHERE Nombre_equipo IN (SELECT nombre FROM equipos WHERE (Conferencia LIKE 'West') AND (Division LIKE 'Pacific') ) AND Posicion LIKE 'PIVOT'");
        System.out.println(myStatement.getUpdateCount() + " registros afectados");

    }

    public void deleteTeam(String team) throws SQLException {
        System.out.println(String.format("DELETE * FROM equipos WHERE nombre like '%s'", team));
        //myStatement.executeUpdate(String.format("DELETE * FROM equipos WHERE nombre like '%s'", team));
    }

    public static void printResultColumns(ResultSet resultSet) throws SQLException, IOException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();

        while (resultSet.next()) {
            System.out.println("--");
            for (int i = 1; i <= columnCount; i++) {
                switch (rsmd.getColumnType(i)) {
                    case Types.VARCHAR:
                    case Types.LONGVARCHAR:
                    case Types.CHAR:
                        System.out.print(resultSet.getString(i));
                        break;
                    case Types.DOUBLE:
                        System.out.print(resultSet.getDouble(i));
                        break;
                    case Types.INTEGER:
                        System.out.print(resultSet.getInt(i));
                        break;
                    case Types.DATE:
                        System.out.print(resultSet.getDate(i).toString());
                        break;
                    case Types.TIMESTAMP:
                        System.out.print(resultSet.getTimestamp(i).toString());
                        break;
                    case Types.BOOLEAN:
                        System.out.print(resultSet.getBoolean(i));
                        break;
                    case Types.DECIMAL:
                    case Types.NUMERIC:
                        System.out.print(resultSet.getBigDecimal(i));
                        break;
                    default:
                }
                if (i != columnCount) {
                    System.out.print(" || ");
                }
            }
            System.out.println("");
        }
    }
}

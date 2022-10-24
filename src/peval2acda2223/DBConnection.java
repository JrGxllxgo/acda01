package peval2acda2223;

import java.io.IOException;
import java.sql.*;

public class DBConnection {

    private String myQuery;
    DBConnection() {
        try {
            // cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // establecemos la conexion con la BD
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/basketlitle",
                    "root", "");

            // preparamos la consulta
            Statement sentencia = (Statement) conexion.createStatement();

            executeQuery(sentencia, myQuery);

            sentencia.close(); // Cerrar Statement
            conexion.close(); // Cerrar conexión

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void executeQuery(Statement sentencia, String myQuery) throws SQLException, IOException {
        ResultSet rs = sentencia.executeQuery(myQuery);

        printResultColumns(rs);

        rs.close(); // Cerrar ResultSet
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
                if (i != columnCount){
                    System.out.print(",");
                }
            }
            System.out.println("");
        }
    }
}

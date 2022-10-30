package peval2acda2223;

/**
 * @author José Ramón Gallego Vélez
 * @date 24/10/2022
 * @info Class that has the connection to the database and makes all query
 */

import java.io.IOException;
import java.sql.*;

public class DBConnection {
    private Statement myStatement;

    /**
     * Constructor of the class
     */
    DBConnection(){
        createBDConnection();
    }

    /**
     * Method to set different params to the connection
     */
    public void createBDConnection(){
        try {
            //starting the driver
            Class.forName("com.mysql.jdbc.Driver");

            //stablishing the connection
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/basketlitle",
                    "root", "");

            //startint the statement for the methods
            myStatement = (Statement) connection.createStatement();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to execute  aquery that insert a new game to our DB with params introduced by the user
     * @param localTeam String for the name of the local team
     * @param visitorTeam String for the name of the visitor team
     * @param localPts Integer for the point scored by the local team
     * @param visitorPts Integer for the point scored by the visitor team
     * @param season String for the season of the game
     * @throws SQLException exception for the possible error at th query
     */
    public void executeInsertQuery(String localTeam, String visitorTeam, int localPts, int visitorPts, String season) throws SQLException {
        ResultSet rs = myStatement.executeQuery("SELECT MAX(codigo) FROM partidos");
        rs.next();
        /**
         * Integer matchCode is for the code of the game that is the higher plus one
         */
        int matchCode = rs.getInt("MAX(codigo)")+1;
        myStatement.executeUpdate(String.format("INSERT INTO partidos VALUES ('%d', '%s', '%s', '%d', '%d', '%s')", matchCode, localTeam, visitorTeam, localPts, visitorPts, season));

        System.out.println("Partido anadido");

        rs.close();
    }

    /**
     * Method that execute the query to show the player data of the city required by the user
     * @param city String for the city given by the user
     * @throws SQLException exception for the possible error at th query
     * @throws IOException
     */
    public void executeSelectQuery(String city) throws SQLException, IOException {
        ResultSet rs = myStatement.executeQuery(String.format("SELECT j.Nombre,j.Altura, j.Peso, j.Posicion, e.Nombre FROM jugadores j, equipos e WHERE (j.Nombre_equipo= e.Nombre) AND e.Ciudad LIKE '%s'", city));
        printResultColumns(rs);

        rs.close(); // Cerrar ResultSet
    }

    /**
     * Methos that changes the positions
     * @throws SQLException exception for the possible error at th query
     */
    public void executeUpdateQuery() throws SQLException {
        myStatement.executeUpdate("UPDATE jugadores SET Posicion = 'PIVOTE' WHERE Nombre_equipo IN (SELECT nombre FROM equipos WHERE (Conferencia LIKE 'West') AND (Division LIKE 'Pacific') ) AND Posicion LIKE 'PIVOT'");
        System.out.println(myStatement.getUpdateCount() + " registros afectados");

    }

    /**
     * Method to delete ALL data of the team given by the user
     * @param team String for the city that the user wants
     * @throws SQLException exception for the possible error at th query
     */
    public void deleteTeam(String team) throws SQLException {
        myStatement.executeUpdate(String.format("DELETE * FROM equipos WHERE nombre like '%s'", team));
    }

    /**
     * Method that receive a player name and show how many games played as visitor and as local
     * @param player String for the player name given by the user
     * @throws SQLException exception for the possible error at th query
     * @throws IOException
     */
    public void getGames(String player) throws SQLException, IOException {
        ResultSet rsLoc = myStatement.executeQuery(String.format("SELECT count(partidos.codigo), partidos.temporada " +
                "FROM equipos, partidos" +
                " WHERE equipos.Nombre = partidos.equipo_visitante " +
                "and partidos.equipo_local like" +
                "( SELECT equipos.Nombre from equipos, jugadores where equipos.Nombre = jugadores.Nombre_equipo and jugadores.Nombre LIKE '%s')" +
                " GROUP BY partidos.temporada", player));
        while(rsLoc.next()){
            System.out.printf("Partidos: %d || Temporada %d", rsLoc.getInt(1), rsLoc.getInt(2));
        }
        rsLoc.close();

        System.out.println("Partidos de VISITANTE: ");
        ResultSet rsVis = myStatement.executeQuery(String.format("SELECT count(partidos.codigo), partidos.temporada " +
                "FROM equipos, partidos" +
                " WHERE equipos.Nombre = partidos.equipo_visitante " +
                "and partidos.equipo_visitante like" +
                "( SELECT equipos.Nombre from equipos, jugadores where equipos.Nombre = jugadores.Nombre_equipo and jugadores.Nombre LIKE '%s')" +
                " GROUP BY partidos.temporada", player));
        printResultColumns(rsVis);
        rsVis.close();
    }

    /**
     * Method that receive a ResultSet and print all data separating each data with a switch giving some styling
     * @param resultSet ResultSet received
     * @throws SQLException exception for the possible error at th query
     * @throws IOException
     */
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

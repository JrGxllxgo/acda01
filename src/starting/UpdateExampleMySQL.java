package starting;

import java.sql.*;

public class UpdateExampleMySQL {

	public static void main(String[] args) {
		try {
			// cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");

			// conexion a la base de datos
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/testingschema",
					"root", "");

			// valores nuevos
			String newLoc = "'MALAGA'";
			String denombre = "'VENTAS'";
			String loc = "'CADIZ'";

			// Sentencia sql
			// String sql = String.format("UPDATE departamentos SET loc = '%s' WHERE
			// denombre='%s'", newLoc, denombre);
			String sql = String.format("DELETE FROM departamentos WHERE loc = %s", loc);
			System.out.println(sql);

			Statement sentence = (Statement) connection.createStatement();
			int filas = sentence.executeUpdate(sql);
			System.out.printf("Departamentos modificados: %d %n", filas);

			sentence.close();
			connection.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

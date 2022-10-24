package exercisesConectors;

import java.sql.*;

public class E2MySQL {
	public static void main(String[] args) {
		try {
			// cargar el driver
			Class.forName("com.mysql.jdbc.Driver");

			// establecemos la conexion con la BD
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/testingschema",
					"root", "");

			// preparamos la consulta
			Statement sentencia = (Statement) conexion.createStatement();
			String sql = "SELECT * FROM departamentos";
			ResultSet resul = sentencia.executeQuery(sql);

			// Recorremos el resultado para visualizar cada fila
			// Se hace un buclee mientras haya regisros y se van mostrando
			while (resul.next()) {
				System.out.printf("%d, %s, %s, %n", resul.getInt(1), resul.getString(2), resul.getString(3));
			}

			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

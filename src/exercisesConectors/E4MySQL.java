package exercisesConectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E4MySQL {

	private static int id, stock_actual, stock_minimo, pvp;
	private static String descripcion;

	public static void main(String[] args) {
		try {
			// cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");

			// conexion a la base de datos
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/unidad2", "root",
					"");

			Statement sentencia = (Statement) connection.createStatement();

			introduceProductos(sentencia);

			sentencia.close();
			connection.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Creamos el metodo para comenzar a introducir los daros en produtos y luego
	// hacer el insert en la tabla
	private static void introduceProductos(Statement sentencia) throws SQLException {
		// values
		id = keyBoardInt("Introduzca el numero de producto");
		descripcion = keyBoardString("Introduzca la descripción del producto");
		stock_actual = keyBoardInt("Stock actual del producto:");
		stock_minimo = keyBoardInt("Introduzca la cantidad minima en almacén:");
		pvp = keyBoardInt("Introduzca el P.V.P. del producto");

		// condicional para que no pueda ser nula la descripcion
		if (descripcion.equals(null)) {
			System.out.println("Descripción no puede ser nula.");
			introduceProductos(sentencia);
		} else {
			prodIdVerify(id, sentencia);
		}
	}

	// Metodo donde verificamos que el numero de empleado exista
	public static void prodIdVerify(int id, Statement sentencia) throws SQLException {
		String sqlId = String.format("SELECT * FROM productos WHERE id LIKE '%d'", id);

		boolean value = sentencia.execute(sqlId);
		ResultSet rs = sentencia.getResultSet();

		if (rs.next()) {
			introduceProductos(sentencia);
			System.out.println("Producto ya registrado");
		} else {
			insertProd(sentencia);
		}
	}

	// Metodo para hacer el insert al terminar de recabar todos los datos
	public static void insertProd(Statement sentencia) throws SQLException {
		String sqlInsert = String.format("INSERT INTO productos VALUES ('%d', '%s', '%d', '%d', '%d')",
				id, descripcion, stock_actual, stock_minimo, pvp);

		sentencia.executeUpdate(sqlInsert);

		System.out.println("Producto registrado!!");
	}

	// Metodo para introducir int por teclado
	public static int keyBoardInt(String text) {
		Scanner key = new Scanner(System.in);
		System.out.println(text);
		return key.nextInt();
	}

	// Metodo para introducir un String por teclado
	public static String keyBoardString(String text) {
		Scanner key = new Scanner(System.in);
		System.out.println(text);
		return key.next();
	}

}

package exercisesConectors;

import java.sql.*;
import java.util.Scanner;

public class E3MySQL {

	private static int emp_no, salario, comision, dept_no, director;
	private static String apellido, profesion, fecha_alta;

	public static void main(String[] args) {
		try {
			// cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");

			// conexion a la base de datos
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/testingschema",
					"root", "");

			for (int i = 0; i < 4; i++) {
				// values
				emp_no = keyBoardInt("Introduzca el numero de empleado");
				apellido = keyBoardString("Introduzca el apellido del empleado");
				profesion = keyBoardString("Introduzca la profesion del empleado");
				director = keyBoardInt("Introduzca el director del empleado");
				salario = keyBoardInt("Introduzca el salario del empleado");
				comision = keyBoardInt("Introduzca la comision del empleado");
				dept_no = keyBoardInt("Introduzca el numero de departamento al que pertenece");
				fecha_alta = "NOW()";

				Statement sentencia = (Statement) connection.createStatement();

				if (salario > 0 && !apellido.equals("") && !profesion.equals("")) {
					deptNoVerify(dept_no, sentencia);
				} else if (salario < 0) {
					System.out.println("Error en el salario, debe ser mayor que 0");
				} else if (apellido.equals("")) {
					System.out.println("Apellido no puede ser nulo");
				} else if (profesion.equals("")) {
					System.out.println("La profesión no puede ser nula");
				}
			}

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Metodo donde verificamos que el numero de departamento exista
	public static void deptNoVerify(int dept_no, Statement sentencia) throws SQLException {
		String sqlDeptNo = String.format("SELECT * FROM departamentos WHERE dept_no LIKE '%d'", dept_no);

		boolean value = sentencia.execute(sqlDeptNo);
		ResultSet rs = sentencia.getResultSet();

		if (!rs.next()) {
			System.out.println("Departamento no existe");
		} else {
			System.out.println("Completando registro...");
			empNoVerify(emp_no, sentencia);
		}
	}

	// Metodo donde verificamos que el numero de empleado exista
	public static void empNoVerify(int emp_no, Statement sentencia) throws SQLException {
		String sqlEmpNo = String.format("SELECT * FROM empleados WHERE emp_no LIKE '%d'", emp_no);

		boolean value = sentencia.execute(sqlEmpNo);
		ResultSet rs = sentencia.getResultSet();

		if (rs.next()) {
			System.out.println("Empleado ya registrado");
		} else {
			System.out.println("Continuando con el registro...");
			dirVerify(director, sentencia);
		}
	}

	// Metodo donde verificamos que el numero de diretor exista
	public static void dirVerify(int director, Statement sentencia) throws SQLException {
		String sqlDir = String.format("SELECT * FROM empleados WHERE director LIKE '%d'", director);

		boolean value = sentencia.execute(sqlDir);
		ResultSet rs = sentencia.getResultSet();

		if (!rs.next()) {
			System.out.println("Director no existe");
		} else {
			System.out.println("Continuando con el registro...");
			insertData(sentencia);
		}
	}

	// Metodo para hacer el insert al terminar de recabar todos los datos
	public static void insertData(Statement sentencia) throws SQLException {
		String sqlInsert = String.format("INSERT INTO empleados VALUES ('%d', '%s', '%s', '%d', '%d', '%d', '%d', %s)",
				emp_no, apellido, profesion, director, salario, comision, dept_no, fecha_alta);

		sentencia.executeUpdate(sqlInsert);

		System.out.println("Empleado registrado!!");
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

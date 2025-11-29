package PracticaFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String URL = "jdbc:mysql://localhost:3306/jugueteria";
    private static final String USER = "jugueteria_user"; //jugueteria_user
    private static final String PASSWORD = "cfgs";

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error conectando a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}

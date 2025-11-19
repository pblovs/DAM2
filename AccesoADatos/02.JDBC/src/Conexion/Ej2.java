package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ej2 {
	
	 
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/nba";
        String usuario = "root";
        String password = "cfgs";

        while (true) {
            System.out.println("\nMENÚ NBA");
            System.out.println("1. Borrar jugador");
            System.out.println("2. Fichar jugador");
            System.out.println("3. Inserta partido");
            System.out.println("4. Mostrar estadísticas por equipo");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> BorrarJugadores(sc, getConnection(url, usuario, password));
                case 2 -> FicharJugador(sc, getConnection(url, usuario, password));
                case 3 -> InsertarPartido(sc, getConnection(url, usuario, password));
                case 4 -> EstadisticasEquipo(sc, getConnection(url, usuario, password));
                case 0 -> {
                    System.err.println("Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.err.println("Opción no válida.");
            }
        }
    }
	
	public static Connection getConnection(String url, String usuario, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, usuario, password);
	}

	private static void BorrarJugadores(Scanner sc, Connection conexion) {
		System.out.print("Introduce un ID: ");
        int id = sc.nextInt();

        String consulta = "DELETE FROM jugadores WHERE codigo = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(consulta);){
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            System.err.println("Jugador "+id+" borrado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private static void FicharJugador(Scanner sc, Connection conexion) {
		
	}

	private static void InsertarPartido(Scanner sc, Connection conexion) {
		
	}

	private static void EstadisticasEquipo(Scanner sc, Connection conexion) {
		
	}
}

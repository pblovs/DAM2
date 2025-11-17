package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ej2 {
	
	 
	
	public static void main(String[] args) {
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

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> BorrarJugadores(sc, url, usuario, password);
                case 2 -> FicharJugador(sc, url, usuario, password);
                case 3 -> InsertarPartido(sc, url, usuario, password);
                case 4 -> EstadisticasEquipo(sc, url, usuario, password);
                case 0 -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

	private static void BorrarJugadores(Scanner sc, String url, String usuario, String password) {
		System.out.print("Introduce un ID: ");
        int id = sc.nextInt();

        String consulta = "DELETE FROM jugadores WHERE codigo = ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sentencia.setInt(1, id);
            int resultado = sentencia.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private static void FicharJugador(Scanner sc, String url, String usuario, String password) {
		// TODO Auto-generated method stub
	}

	private static void InsertarPartido(Scanner sc, String url, String usuario, String password) {
		// TODO Auto-generated method stub
	}

	private static void EstadisticasEquipo(Scanner sc, String url, String usuario, String password) {
		// TODO Auto-generated method stub
	}
}

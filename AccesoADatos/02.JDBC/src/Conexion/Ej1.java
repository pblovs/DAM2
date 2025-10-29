package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ej1 {
	
	public static void jugadoresPorLetra(Scanner sc, String url, String usuario, String password) {
		try {
			// 1) Cargar driver de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2) Crear conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado la base de datos.");
			// 3.2) Crear un preparedStatement
			String consulta = "Select * from jugadores where nombre like ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			System.out.println("Introduce una letra: ");
			String letra = sc.nextLine();
			sentencia.setString(1, letra + "%");
			ResultSet resultado = sentencia.executeQuery();
			
			//Mostrar resultados
			while(resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String nombre = resultado.getString("Nombre");
				String procedencia = resultado.getString("Procedencia");
				String altura = resultado.getString("Altura");
				int peso = resultado.getInt("Peso");
				String posicion = resultado.getString("Posicion");
				String equipo = resultado.getString("Nombre_Equipo");
				System.out.println("Codigo: "+codigo+", Nombre: "+nombre+", Procedencia: "+procedencia+
						", Altura: "+altura+", Peso: "+peso+", Posicion: "+posicion+", Equipo: "+equipo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void pesoMedio(String url, String usuario, String password) {
		try {
			// 1) Cargar driver de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2) Crear conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			// 3) Crear un Statement
			Statement sentencia = conexion.createStatement();
			String consulta = "select avg(Peso) AS peso_medio from jugadores";
			ResultSet resultado = sentencia.executeQuery(consulta);
			
			//Mostrar resultados
			while(resultado.next()) {
				
				int peso = resultado.getInt("peso_medio");
				
				System.out.println("Peso medio: "+peso);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void jugadoresPorEquipo(Scanner sc, String url, String usuario, String password) {
		try {
			// 1) Cargar driver de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2) Crear conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			// 3.1) crear un statement
			Statement sentencia = conexion.createStatement();
			String consulta = "select Nombre from equipos";
			ResultSet resultado = sentencia.executeQuery(consulta);
			// 3.2) Crear un preparedStatement
			String consulta2 = "Select * from jugadores where Nombre_equipo=?";
			PreparedStatement sentencia2 = conexion.prepareStatement(consulta2);
			System.out.println("Introduce el nombre del equipo: ");
			String nombreEquipo = sc.nextLine();
			sentencia2.setString(1, nombreEquipo);
			ResultSet resultado2 = sentencia2.executeQuery();
			
			//Mostrar resultados
			while(resultado.next()) {
				String nombre = resultado.getString("nombre");
				System.out.println(" Nombre: "+nombre);
			}
			while(resultado2.next()) {
				int codigo = resultado2.getInt("codigo");
				String nombre = resultado2.getString("Nombre");
				String procedencia = resultado2.getString("Procedencia");
				String altura = resultado2.getString("Altura");
				int peso = resultado2.getInt("Peso");
				String posicion = resultado2.getString("Posicion");
				String equipo = resultado2.getString("Nombre_Equipo");
				System.out.println("Codigo: "+codigo+", Nombre: "+nombre+", Procedencia: "+procedencia+
						", Altura: "+altura+", Peso: "+peso+", Posicion: "+posicion+", Equipo: "+equipo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";
		
		jugadoresPorLetra(sc, url, usuario, password);
		pesoMedio(url, usuario, password);
		jugadoresPorEquipo(sc, url, usuario, password);
		//insertarJugador(url, usuario, password);
		
		
		
		sc.close();
	}
}

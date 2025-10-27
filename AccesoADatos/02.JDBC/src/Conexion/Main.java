package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql:localhost:3306/mydb";
		String usuario = "root";
		String password = "cfgs";
		
		try {
			// 1) Cargar driver de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2) Crear conexión
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado la base de datos.");
			// 3) crear un statement
			Statement sentencia = conexion.createStatement();
			String consulta = "select*from usuario";
			ResultSet resultado = sentencia.executeQuery(consulta);
			
			//Mostrar resultados
			while(resultado.next()) {
				int idUSUARIO = resultado.getInt("idUSUARIO");
				String nombre = resultado.getString("nombre");
				//Date fecha = new Date();
				String genero = resultado.getString("genero");
				System.out.println("idUSUARIO: "+idUSUARIO+" Nombre: "+nombre+" Genero: "+genero);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

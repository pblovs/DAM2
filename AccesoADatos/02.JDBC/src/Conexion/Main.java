package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			// 3.1) crear un statement
			Statement sentencia = conexion.createStatement();
			String consulta = "select*from usuario";
			ResultSet resultado = sentencia.executeQuery(consulta);
			// 3.2) Crear un preparedStatement
			String consulta2 = "Select * from usuario where idUSUARIO=? or nombre=?";
			PreparedStatement sentencia2 = conexion.prepareStatement(consulta2);
			sentencia2.setInt(1, 1); //Lo que va en los interrogantes
			sentencia2.setString(2, "Leo");
			ResultSet resultado2 = sentencia2.executeQuery();
			
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

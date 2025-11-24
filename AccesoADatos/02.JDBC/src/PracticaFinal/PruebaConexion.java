package PracticaFinal;

import java.sql.Connection;

public class PruebaConexion {
	public static void main(String[] args) {
	    Connection conn = Conexion.getConexion();
	    if (conn != null) {
	        System.out.println("Conexión probada correctamente!");
	    } else {
	        System.out.println("No se pudo conectar a la base de datos.");
	    }
	}

}

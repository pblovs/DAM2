package PracticaFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empleado {
	
    private int idEmpleado;
    private String nombre;
    private String cargo;
    private String fechaIngreso;

    public Empleado() {}

    public Empleado(int idEmpleado, String nombre, String cargo, String fechaIngreso) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdEmpleado() {
    	return idEmpleado; 
    }
    public void setIdEmpleado(int idEmpleado) { 
    	this.idEmpleado = idEmpleado; 
    }

    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }

    public String getCargo() { 
    	return cargo; 
    }
    public void setCargo(String cargo) { 
    	this.cargo = cargo; 
    }

    public String getFechaIngreso() { 
    	return fechaIngreso; 
    }
    public void setFechaIngreso(String fechaIngreso) { 
    	this.fechaIngreso = fechaIngreso; 
    }

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaIngreso="
				+ fechaIngreso + "]";
	}

	public static boolean insertar() {

	    Scanner sc = new Scanner(System.in);
	    
	    int idEmpleado = 0;

	    System.out.print("Introduce el nombre del empleado: ");
	    String nombre = sc.nextLine();

	    System.out.print("Introduce el cargo (jefe/cajero): ");
	    String cargo = sc.nextLine();

	    System.out.print("Introduce fecha de ingreso (YYYY-MM-DD): ");
	    String fechaIngreso = sc.nextLine();

	    String sqlMax = "SELECT COALESCE(MAX(idEMPLEADO), 0) FROM empleado";

	    try (Connection con = Conexion.getConexion();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sqlMax)) {

	        if (rs.next()) {
	            idEmpleado = rs.getInt(1) + 1;
	        }

	    } catch (SQLException e) {
	        System.out.println("Error obteniendo MAX ID: " + e.getMessage());
	        return false;
	    }

	    String sqlInsert = "INSERT INTO empleado (idEMPLEADO, Nombre, Cargo, Fecha_ingreso) VALUES (?, ?, ?, ?)";

	    try (Connection con = Conexion.getConexion();
	         PreparedStatement stmt = con.prepareStatement(sqlInsert)) {

	        stmt.setInt(1, idEmpleado);
	        stmt.setString(2, nombre);
	        stmt.setString(3, cargo);
	        stmt.setString(4, fechaIngreso);

	        stmt.executeUpdate();
	        System.out.println("Empleado insertado correctamente con ID = " + idEmpleado);
	        return true;

	    } catch (SQLException e) {
	        System.out.println("Error insertando empleado: " + e.getMessage());
	        return false;
	    }
	}

    public static List<Empleado> obtenerTodos() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Empleado e = new Empleado(
                        rs.getInt("idEMPLEADO"),
                        rs.getString("Nombre"),
                        rs.getString("Cargo"),
                        rs.getString("Fecha_ingreso")
                );
                empleados.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo empleados: " + e.getMessage());
        }

        return empleados;
    }

    public boolean actualizar() {
        String sql = "UPDATE empleado SET Nombre=?, Cargo=?, Fecha_ingreso=? WHERE idEMPLEADO=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, cargo);
            stmt.setString(3, fechaIngreso);
            stmt.setInt(4, idEmpleado);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando empleado: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminar(int idEmpleado) {
        String sql = "DELETE FROM empleado WHERE idEMPLEADO=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idEmpleado);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando empleado: " + e.getMessage());
            return false;
        }
    }
}


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
	    
	    System.out.print("Introduce el nombre del empleado: ");
	    String nombre = sc.nextLine();

	    System.out.print("Introduce el cargo (jefe/cajero): ");
	    String cargo = sc.nextLine();

	    System.out.print("Introduce fecha de ingreso (YYYY-MM-DD): ");
	    String fechaIngreso = sc.nextLine();

	    String sqlInsert = "INSERT INTO empleado (Nombre, Cargo, Fecha_ingreso) VALUES (?, ?, ?)";

	    try (Connection con = Conexion.getConexion();
	         PreparedStatement stmt = con.prepareStatement(sqlInsert)) {

	        stmt.setString(1, nombre);
	        stmt.setString(2, cargo);
	        stmt.setString(3, fechaIngreso);

	        stmt.executeUpdate();
	        System.out.println("Empleado insertado correctamente");
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
                        rs.getInt("ID_Empleado"),
                        rs.getString("Nombre"),
                        rs.getString("Cargo"),
                        rs.getString("Fecha_ingreso")
                );
                empleados.add(e);
                System.out.println(
                        "ID: " + e.getIdEmpleado() +
                        "  Nombre: " + e.getNombre() +
                        "  Cargo: " + e.getCargo() +
                        "  Fecha ingreso: " + e.getFechaIngreso()
                    );
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo empleados: " + e.getMessage());
        }

        return empleados;
    }

    public static boolean actualizar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el ID del empleado que quieres actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Introduce el nuevo nombre: ");
        String nuevoNombre = sc.nextLine();

        System.out.print("Introduce el nuevo cargo: ");
        String nuevoCargo = sc.nextLine();

        System.out.print("Introduce la nueva fecha de ingreso (YYYY-MM-DD): ");
        String nuevaFecha = sc.nextLine();

        String sql = "UPDATE empleado SET Nombre=?, Cargo=?, Fecha_ingreso=? WHERE ID_Empleado=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoCargo);
            stmt.setString(3, nuevaFecha);
            stmt.setInt(4, id);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Empleado actualizado correctamente.");
                return true;
            } else {
                System.out.println("No existe un empleado con ese ID.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error actualizando empleado: " + e.getMessage());
            return false;
        }
    }


    public static boolean eliminar(int idEmpleado) {
        String sql = "DELETE FROM empleado WHERE ID_Empleado=?";

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


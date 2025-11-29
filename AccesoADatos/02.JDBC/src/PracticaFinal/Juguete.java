package PracticaFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juguete {
	
	int id;
	String nombre;
	String desc;
	double precio;
	int stock;
	
	public Juguete(int id, String nombre, String desc, double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.desc = desc;
		this.precio = precio;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Juguete [id=" + id + ", nombre=" + nombre + ", desc=" + desc + ", precio=" + precio + ", stock=" + stock
				+ "]";
	}
	
	public static boolean insertar() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del juguete: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce la descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Introduce el precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.print("Introduce la cantidad en stock: ");
        int cantidad = Integer.parseInt(sc.nextLine());


        String sqlInsert = "INSERT INTO juguete (Nombre, Descripcion, Precio, Cantidad_stock) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sqlInsert)) {

            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setDouble(3, precio);
            stmt.setInt(4, cantidad);

            stmt.executeUpdate();
            System.out.println("Juguete insertado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando juguete: " + e.getMessage());
            return false;
        }
    }

    public static List<Juguete> obtenerTodos() {

        List<Juguete> juguetes = new ArrayList<>();
        String sql = "SELECT * FROM juguete";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Juguete j = new Juguete(
                        rs.getInt("ID_Juguete"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion"),
                        rs.getDouble("Precio"),
                        rs.getInt("Cantidad_en_stock")
                );

                juguetes.add(j);

                System.out.println(
                        "ID: " + j.getId() +
                        "  Nombre: " + j.getNombre() +
                        "  Descripción: " + j.getDesc() +
                        "  Precio: " + j.getPrecio() +
                        "  Stock: " + j.getStock() 
                );
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo juguetes: " + e.getMessage());
        }

        return juguetes;
    }

    public static boolean modificar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el ID del juguete que quieres actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Nuevo precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.print("Nueva cantidad en stock: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        

        String sql = "UPDATE juguete SET Nombre=?, Descripcion=?, Precio=?, Cantidad_stock=? WHERE idJuguete=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setDouble(3, precio);
            stmt.setInt(4, cantidad);
            stmt.setInt(5, id);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Juguete actualizado correctamente.");
                return true;
            } else {
                System.out.println("No existe un juguete con ese ID.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error actualizando juguete: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminar(int idJuguete) {

        String sql = "DELETE FROM juguete WHERE idJuguete=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idJuguete);
            stmt.executeUpdate();
            System.out.println("Juguete eliminado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando juguete: " + e.getMessage());
            return false;
        }
    }
}

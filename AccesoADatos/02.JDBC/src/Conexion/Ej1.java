package Conexion;

import java.sql.*;
import java.util.Scanner;

public class Ej1 {

    public static void jugadoresPorLetra(Scanner sc, String url, String usuario, String password) {
        System.out.print("Introduce una letra: ");
        String letra = sc.nextLine();

        String consulta = "SELECT * FROM jugadores WHERE nombre LIKE ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            sentencia.setString(1, letra + "%");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                System.out.println(
                        "Codigo: " + resultado.getInt("codigo") +
                                ", Nombre: " + resultado.getString("Nombre") +
                                ", Procedencia: " + resultado.getString("Procedencia") +
                                ", Altura: " + resultado.getString("Altura") +
                                ", Peso: " + resultado.getInt("Peso") +
                                ", Posicion: " + resultado.getString("Posicion") +
                                ", Equipo: " + resultado.getString("Nombre_Equipo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pesoMedio(String url, String usuario, String password) {
        String consulta = "SELECT AVG(Peso) AS peso_medio FROM jugadores";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consulta)) {

            if (resultado.next()) {
                double peso = resultado.getDouble("peso_medio");
                System.out.printf("Peso medio: %.2f kg\n", peso);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jugadoresPorEquipo(Scanner sc, String url, String usuario, String password) {
        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             Statement sentencia = conexion.createStatement()) {

            // Mostrar equipos disponibles
            ResultSet equipos = sentencia.executeQuery("SELECT Nombre FROM equipos");
            System.out.println("Equipos disponibles:");
            while (equipos.next()) System.out.println("- " + equipos.getString("Nombre"));

            // Pedir equipo
            System.out.print("Introduce el nombre del equipo: ");
            String nombreEquipo = sc.nextLine();

            String consulta = "SELECT * FROM jugadores WHERE Nombre_equipo = ?";
            PreparedStatement sentencia2 = conexion.prepareStatement(consulta);
            sentencia2.setString(1, nombreEquipo);
            ResultSet resultado2 = sentencia2.executeQuery();

            // Mostrar jugadores
            while (resultado2.next()) {
                System.out.println(
                        "Codigo: " + resultado2.getInt("codigo") +
                                ", Nombre: " + resultado2.getString("Nombre") +
                                ", Procedencia: " + resultado2.getString("Procedencia") +
                                ", Altura: " + resultado2.getString("Altura") +
                                ", Peso: " + resultado2.getInt("Peso") +
                                ", Posicion: " + resultado2.getString("Posicion") +
                                ", Equipo: " + resultado2.getString("Nombre_Equipo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarJugador(Scanner sc, String url, String usuario, String password) {
        System.out.println("Introduce los datos del jugador:");

        System.out.print("Código: ");
        int codigo = Integer.parseInt(sc.nextLine());

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Procedencia: ");
        String procedencia = sc.nextLine();

        System.out.print("Altura (ej: 2.05): ");
        String altura = sc.nextLine();

        System.out.print("Peso: ");
        int peso = Integer.parseInt(sc.nextLine());

        System.out.print("Posición: ");
        String posicion = sc.nextLine();

        System.out.print("Nombre del equipo: ");
        String equipo = sc.nextLine();

        String query = "INSERT INTO jugadores VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement ps = conexion.prepareStatement(query)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, procedencia);
            ps.setString(4, altura);
            ps.setInt(5, peso);
            ps.setString(6, posicion);
            ps.setString(7, equipo);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("✅ Jugador insertado correctamente.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error al insertar jugador.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/nba";
        String usuario = "root";
        String password = "cfgs";

        while (true) {
            System.out.println("\n📌 MENÚ NBA");
            System.out.println("1. Buscar jugadores por letra");
            System.out.println("2. Peso medio jugadores");
            System.out.println("3. Jugadores por equipo");
            System.out.println("4. Insertar jugador");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> jugadoresPorLetra(sc, url, usuario, password);
                case 2 -> pesoMedio(url, usuario, password);
                case 3 -> jugadoresPorEquipo(sc, url, usuario, password);
                case 4 -> insertarJugador(sc, url, usuario, password);
                case 0 -> {
                    System.out.println("👋 Saliendo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("❌ Opción no válida.");
            }
        }
    }
}

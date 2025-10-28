package ExamenPracticaFicheros;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class CrearEmpDat {
	public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(aleatorio(), "Juan Pérez", "Vendedor", "12345"));
        empleados.add(new Empleado(aleatorio(), "Ana Gómez", "Gestor", "abcde"));
        empleados.add(new Empleado(aleatorio(), "Luis Rojas", "Vendedor", "xyz789"));
        empleados.add(new Empleado(aleatorio(), "Pedro Sánchez", "Gestor", "qwerty"));
        empleados.add(new Empleado(aleatorio(), "Lucía Fernández", "Vendedor", "abcd123"));
        empleados.add(new Empleado(aleatorio(), "Carlos Méndez", "Gestor", "pass456"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.dat"))) {
            oos.writeObject(empleados);
            System.out.println("Archivo empleado.dat creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static int aleatorio() {
		Random random = new Random();
        int numero = 1000 + random.nextInt(9000);
        return numero;
	}
}

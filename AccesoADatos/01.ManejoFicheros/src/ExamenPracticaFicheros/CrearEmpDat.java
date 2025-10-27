package ExamenPracticaFicheros;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CrearEmpDat {
	public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Juan Pérez", "Ventas", "1234"));
        empleados.add(new Empleado(2, "Ana Gómez", "Contabilidad", "abcd"));
        empleados.add(new Empleado(3, "Luis Rojas", "IT", "xyz789"));
        empleados.add(new Empleado(4, "Pedro Sánchez", "Marketing", "qwerty"));
        empleados.add(new Empleado(5, "Lucía Fernández", "RRHH", "abcd123"));
        empleados.add(new Empleado(6, "Carlos Méndez", "Logística", "pass456"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.dat"))) {
            oos.writeObject(empleados);
            System.out.println("Archivo empleado.dat creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

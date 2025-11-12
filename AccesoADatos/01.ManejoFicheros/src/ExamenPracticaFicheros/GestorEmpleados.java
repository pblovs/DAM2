package ExamenPracticaFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
	
    private static final String EMPLEADOS = "EMPLEADOS/empleados.dat";
    private static final String EMPLEADOS_BAJA = "EMPLEADOS/BAJA/empleadosBaja.dat";

    private static ArrayList<Empleado> empleados;
    private static ArrayList<Empleado> empleadosBaja;

    
    static {
    	File dirEmpleados = new File("EMPLEADOS");
        if (!dirEmpleados.exists()) dirEmpleados.mkdirs();

        File dirBaja = new File("EMPLEADOS/BAJA");
        if (!dirBaja.exists()) dirBaja.mkdirs();
        
    	empleados = cargarEmpleados(EMPLEADOS);
        empleadosBaja = cargarEmpleados(EMPLEADOS_BAJA);
    }

    
    @SuppressWarnings("unchecked")
    private static ArrayList<Empleado> cargarEmpleados(String nombreFichero) {
        File f = new File(nombreFichero);
        if (!f.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (ArrayList<Empleado>) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error al cargar " + nombreFichero + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public static void guardar(String fichero, ArrayList<Empleado> lista) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fichero))) {
            ous.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void agregarEmpleado(Empleado e) {
        empleados.add(e);
        guardar(EMPLEADOS, empleados);
    }

    public static void mostrarEmpleados() {
    	for (Empleado e : empleados) {
    		System.out.println(e.toString());
    	}
    }
    
    public static Empleado buscarPorId(int id) {
        for (Empleado e : getEmpleados()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
    public static Empleado buscarPorIdBaja(int id) {
        for (Empleado e : getEmpleadosBaja()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
    public static ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    
    public static ArrayList<Empleado> getEmpleadosBaja() {
        return empleadosBaja;
    }

}

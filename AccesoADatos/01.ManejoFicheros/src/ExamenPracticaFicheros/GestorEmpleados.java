package ExamenPracticaFicheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorEmpleados {
	
    private static final String FICHERO = "empleados.dat";
    private ArrayList<Empleado> empleados;
    
    private ArrayList<Empleado> cargarEmpleados(){
    	
    	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))){
    		return (ArrayList<Empleado>) ois.readObject();
    	}
    	catch(IOException | ClassNotFoundException e) {
    		System.out.println("No se pudo leer el fichero, se creará una lista vacía.");
            return new ArrayList<>();
    	}
		
    }
    
    public void guardar() {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            ous.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
        guardar();
    }

    public ArrayList<Empleado> listar() { 
    	return empleados; 
    }
}

package read_write;

import java.io.File;
import java.io.IOException;

public class ComprobarArchivos {
	
	public static void comprobar(String archivo) {
		
		//File carpeta = new File("/Resources/Archivos");
		
		File f = new File(archivo);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

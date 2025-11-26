package read_write;

import java.io.FileWriter;
import java.io.IOException;

public class GuardarPreferencias {
	
	public static void guardar(int id, boolean d, boolean p, boolean c, boolean n, boolean i) {
		
		String archivo = "preferencias.txt";
		
		StringBuilder sb = new StringBuilder();
		sb.append("##").append(id);
		if(d) {
			sb.append("D");
		}
		if (p) {
			sb.append("P");
		}
		if (c) {
			sb.append("C");
		}
		if (n) {
			sb.append("N");
		}
		if (i) {
			sb.append("I");
		}
		
		try(FileWriter fw = new FileWriter(archivo)){
			fw.write(sb.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

package read_write;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logic.GestorUsuario;
import model.Preferencia;
import model.Usuario;

public class GuardarPreferencias {
	
	static String archivo = "preferencias.txt";
	
	public static void guardar(int id, boolean d, boolean p, boolean c, boolean n, boolean i) {
				
		StringBuilder sb = new StringBuilder();
		sb.append("##").append(id).append("-");
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
		sb.append("/#");
		
		try(FileWriter fw = new FileWriter(archivo)){
			fw.write(sb.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void cargar() {
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
		    String linea;
		    int inicio, fin, finId;
		    while ((linea = br.readLine()) != null) {
		    	inicio = linea.indexOf("##"); 
		    	String trozo = linea.substring(inicio);
		    	fin = trozo.indexOf("/#");
		    	String idYprefs = linea.substring(inicio+2, fin);
		    	//System.out.println(idYprefs);
		    	
		    	finId = idYprefs.indexOf("-");
		    	String id1 = idYprefs.substring(0, finId);
		    	int id = Integer.valueOf(id1);
		    	String prefs = idYprefs.substring(finId+1);
		    
		    	Usuario user = GestorUsuario.buscarPorId(id);
		    	
		    	ArrayList<Preferencia> preferencias = new ArrayList<>();
		    	for (int i = 0; i < prefs.length(); i++) {
		    		Preferencia p = null;
		    		String pref = prefs.substring(i, i+1);
		    		p.setTipo(pref);
		    		//System.out.println(pref);
		    		preferencias.add(p);
		    	}
		    	user.setPrefs(preferencias);
		    	
		    	//System.out.println(id);
		    	//System.out.println(prefs);
		    }
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

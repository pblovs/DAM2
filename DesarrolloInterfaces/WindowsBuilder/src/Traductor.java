import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Traductor {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una palabra en inglés: ");
		String palabraBuscar = sc.nextLine();
		
		/*URL dir = new URL("https://www.spanishdict.com/translate/"+palabraBuscar);
		
		String html = obtenerHTML(dir);
		String palabraTraducida = cortarHTML(html);
		//System.out.println(html);
		
		System.out.println(palabraTraducida);*/
		String web = "https://www.spanishdict.com/translate/"+palabraBuscar;
		Document doc = Jsoup.connect(web).get();
		Element el = doc.select("div#quickdef1-en a.tCur1iYh").get(0);
		String a = el.html();
	
		System.out.println(a);
		
		sc.close();
	}

	private static String cortarHTML(String html) {
		
		//?langFrom=es" class="tCur1iYh">
		int inicio, puntoFinal;
		
		inicio = html.indexOf("?langFrom=es\" class=\"tCur1iYh\">"); //34
		
		String trozo = html.substring(inicio); //Corta desde después de inicio hasta el final del html
		puntoFinal = trozo.indexOf("</a>"); //En ese trozo busca la primera aparición de </a> y devuelve el índice empezando desde inicio
		
		String palabra = html.substring(inicio+34, inicio + puntoFinal);
		return palabra;
	}

	private static String obtenerHTML(URL dir) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(dir.openStream()));
		String linea, codigo="";
		while((linea=br.readLine())!=null) {
			codigo+=linea;
		}
		br.close();
		
		return codigo;
	}
	
	

}

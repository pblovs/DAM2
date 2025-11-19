import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {

	public static String traducir(String text) throws IOException {
		
		String web = "https://www.spanishdict.com/translate/"+text;
		Document doc = Jsoup.connect(web).get();
		Element el = doc.select("div#quickdef1-en a.tCur1iYh").get(0);
		String resultado = el.html().toUpperCase();
		
		return resultado;
	}

}

package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerFrutas {

	public static void main(String[] args) {

		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ( );
			Document documento = null;
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    documento = builder.parse( new File("frutas.xml") );
		   
		    documento.getDocumentElement().normalize();
		   
		    // recorre todos los elementos de <fruta>
		    NodeList listaFrutas = documento.getElementsByTagName("fruta");
		    
		    List<Fruta> frutas = new ArrayList<>();
		   
		    for (int i = 0; i < listaFrutas.getLength(); i++) {
			    Node nodo = listaFrutas.item(i);
			    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				    Element fruta = (Element) nodo;
				    String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
				    String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
				    String color = fruta.getElementsByTagName("color").item(0).getTextContent();
				    String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
				    String precio = fruta.getElementsByTagName("precio").item(0).getTextContent();
				    String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
				    NodeList listaNutrientes = fruta.getElementsByTagName("nutriente");
                    List<String> nutrientes = new ArrayList<>();
                    for (int j = 0; j < listaNutrientes.getLength(); j++) {
                    	String nutriente = listaNutrientes.item(j).getTextContent();
                        nutrientes.add(nutriente);
                    }
                    Fruta frutilla = new Fruta(nombre, tipo, color, origen, precio, temporada, nutrientes);
                    frutas.add(frutilla);
				   
			    }
		    }
		    
		    for (Fruta f : frutas) {
                System.out.println(f.toString());
            }

		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }

	}

}

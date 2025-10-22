package ExamenPracticaFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import XML.Fruta;

public class GestorPlantas {
	
	public void cargarPlantas() {
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ( );
			Document documento = null;
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    documento = builder.parse( new File("plantas.xml") );
		   
		    documento.getDocumentElement().normalize();
		   
		    NodeList listaPlantas = documento.getElementsByTagName("planta");
		    
		    ArrayList<Planta> plantas = new ArrayList<>();
		   
		    for (int i = 0; i < listaPlantas.getLength(); i++) {
			    Node nodo = listaPlantas.item(i);
			    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				    Element planta = (Element) nodo;
				    String codigo = planta.getElementsByTagName("codigo").item(0).getTextContent();
				    String nombre = planta.getElementsByTagName("nombre").item(0).getTextContent();
				    String foto = planta.getElementsByTagName("foto").item(0).getTextContent();
				    String descripcion = planta.getElementsByTagName("descripcion").item(0).getTextContent();
				    
				    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("plantas.dat"))){ //plantas.dat tiene precio y cantidad
			    	}
			    	catch(IOException | ClassNotFoundException e) {
			    		System.out.println("No se pudo leer el fichero, se creará una lista vacía.");
			    	}
				   
                    Planta plantita = new Planta(codigo, nombre, foto, descripcion, precio, cantidad);
                    plantas.add(plantita);
				   
			    }
		    }

		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
	}
}

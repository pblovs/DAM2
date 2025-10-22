package ExamenPracticaFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
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
				    int codigo = Integer.parseInt(planta.getElementsByTagName("codigo").item(0).getTextContent());
				    String nombre = planta.getElementsByTagName("nombre").item(0).getTextContent();
				    String foto = planta.getElementsByTagName("foto").item(0).getTextContent();
				    String descripcion = planta.getElementsByTagName("descripcion").item(0).getTextContent();
				    
				 // Precio y stock desde el archivo binario
                    float precio = 0;
                    int cantidad = 0;

                    try (RandomAccessFile raf = new RandomAccessFile("plantas.dat", "r")) {
                        long tamRegistro = 12; // int(4) + float(4) + int(4)
                        long posicion = (codigo - 1) * tamRegistro;
                        if (posicion < raf.length()) {
                            raf.seek(posicion);
                            int cod = raf.readInt();
                            precio = raf.readFloat();
                            cantidad = raf.readInt();
                        }
                    } catch (IOException ex) {
                        System.out.println("Error leyendo plantas.dat: " + ex.getMessage());
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

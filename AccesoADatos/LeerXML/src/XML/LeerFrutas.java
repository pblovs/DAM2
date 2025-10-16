package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerFrutas {
	
	public static void filtrarPorPrecio(Scanner sc, List<Fruta> frutas) {
		System.out.println("Filtrar por precio, > (1), < (2), = (3): ");
		int opcion = sc.nextInt();
		System.out.println("Introduce el precio: ");
		double precioFiltrar = sc.nextDouble();
		for (Fruta f : frutas) {
			switch(opcion) {
			case 1: 
				if (precioFiltrar < Double.parseDouble(f.precio)) {
					System.out.println(f.toString());
				}
				break;
			case 2: 
				if (precioFiltrar > Double.parseDouble(f.precio)) {
					System.out.println(f.toString());
				}
				break;
			case 3: 
				if (precioFiltrar == Double.parseDouble(f.precio)) {
					System.out.println(f.toString());
				}
				break;
			default:
                System.out.println("Opción no válida");
                break;
			}
		}
	}
	
	public static void filtrarPorNutriente(Scanner sc, List<Fruta> frutas) {
		System.out.println("Introduce el nutriente: ");
		sc.nextLine();
		String nutri = sc.nextLine();
		for (Fruta f : frutas) {
			if (f.nutrientes.contains(nutri)) {
				System.out.println(f.toString());
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		    
		    filtrarPorPrecio(sc, frutas);
		    System.out.println();
		    filtrarPorNutriente(sc, frutas);

		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		
		sc.close();
	}

}

package JavaNIO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class main01 {
	
	public static void ReadFiles() {
		Path rute = Paths.get("planetas.txt");
		try {
			String contenido = Files.readString(rute);
			System.out.println(contenido);
			System.out.println("------------------------");
			List<String> listaContenido = Files.readAllLines(rute);
			for (String linea : listaContenido) {
				System.out.println("Linea: "+linea);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void WriteFiles() {
		Path rute = Paths.get("FicheroEscritura.txt");
		try {
			String contenido = "Hola esta es mi primera escritura";
			Files.write(rute, contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Copy() {
		Path originRute = Paths.get("FicheroEscritura.txt");
		Path destRute = Paths.get("FicheroCopia.txt");
		try {
			Files.copy(originRute, destRute, StandardCopyOption.REPLACE_EXISTING);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ListContents() {
		System.out.println("--------------");
		Path directory = Path.of(".");
		try {
			Stream<Path> flujo = Files.list(directory);
			flujo.forEach(archivo-> System.out.println(archivo.getFileName()));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void FileProperties() {
		System.out.println("--------------");
		Path rute = Path.of("planetas.txt");
		System.out.println("Fichero existe: "+Files.exists(rute));
		System.out.println("Fichero es  directorio: "+Files.isDirectory(rute));
	}
	
	public static void DeleteFile() {
		Path rute = Path.of("planetas.txt");
			try {
				Files.deleteIfExists(rute);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	}

	public static void main(String[] args) {
		
		ReadFiles();
		WriteFiles();
		Copy();
		ListContents();
		FileProperties();
		//DeleteFile();
	}

}

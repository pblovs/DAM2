import java.util.Random;

public class Hilo03 implements Runnable{
	private int idZona;
	private ResultadosEncuesta respuestas;
    private Random random = new Random();

	
	public Hilo03(int idZona, ResultadosEncuesta respuestas) {
		super();
		this.idZona = idZona;
		this.respuestas = respuestas;
	}
	
	public void run() {
		int numRespuestas = 200 + random.nextInt(101);

        for (int i = 0; i < numRespuestas; i++) {
            String respuesta;
            int valor = random.nextInt(10); 
            respuesta = (valor == 0) ? null : "respuesta" + valor; //si el valor es 0 respuesta = null y sino = resuesta+valor

            respuestas.registrarRespuesta(idZona);
        }
	}
}

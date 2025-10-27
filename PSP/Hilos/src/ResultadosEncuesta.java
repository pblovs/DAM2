
class ResultadosEncuesta {
    private int conteoRespuestas;
    private int[] encuestadosPorZona; 

    public ResultadosEncuesta(int numZonas) {
        encuestadosPorZona = new int[numZonas];
    }

	synchronized public void registrarRespuesta(int zona) {
        encuestadosPorZona[zona - 1]++;
        conteoRespuestas++;
    }
    
    synchronized public void mostrarRespuestas() {
    	System.out.println("Cantidad de votos total: "+conteoRespuestas);
    }
    
    synchronized public void mostrarRespuestasPorZona() {
    	for (int i = 0; i < encuestadosPorZona.length; i++) {
    		System.out.println("Zona "+(i+1)+": "+encuestadosPorZona[i]);
    	}
    }
}

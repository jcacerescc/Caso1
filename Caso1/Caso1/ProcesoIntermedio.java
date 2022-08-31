package Caso1;

public class ProcesoIntermedio extends Thread {
    
    private String posicion;
    
    private Buzon buzonAnterior;
    private Buzon buzonSiguiente;

    
    public ProcesoIntermedio(String posicion, Buzon buzonAnterior, Buzon buzonSiguiente) {
		super();
		this.posicion = posicion;
		this.buzonAnterior = buzonAnterior;
		this.buzonSiguiente = buzonSiguiente;
	}
	public void run() {
        while (true) {
            String mensaje = buzonAnterior.extraer();
            
            buzonSiguiente.almacenar(mensaje);
        }
    }


}

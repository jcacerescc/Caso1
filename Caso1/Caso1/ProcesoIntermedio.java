package Caso1;

import java.util.concurrent.ThreadLocalRandom;

public class ProcesoIntermedio extends Thread {
    
    private String posicion; 
    
    private Buzon buzonAnterior;
    private Buzon buzonSiguiente;
    

    public ProcesoIntermedio(String posicion, Buzon buzonAnterior, Buzon buzonSiguiente) {
        
		this.posicion = posicion;
		this.buzonAnterior = buzonAnterior;
		this.buzonSiguiente = buzonSiguiente;
	}
    

	public void run() {
        while (true) {
            String mensaje = buzonAnterior.extraer();
            System.out.println("ProcesoIntermedio "+posicion+" extrae: "+mensaje);

           
           try {
                if (mensaje.equals("FIN")) {
                    buzonSiguiente.almacenar(mensaje);
                    ProcesoIntermedio.sleep(10);
                }
                mensaje+="T"+posicion;
                System.out.println("ProcesoIntermedio "+posicion+" transforma: "+mensaje);
				ProcesoIntermedio.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
            buzonSiguiente.almacenar(mensaje);
            System.out.println("ProcesoIntermedio "+posicion+" almacena: "+mensaje);
           
            
        }
    }


}

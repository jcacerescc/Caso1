package Caso1;

import java.util.concurrent.ThreadLocalRandom;

public class ProcesoIntermedio extends Thread {
    
    private String posicion; 
    
    private Buzon buzonAnterior;
    private Buzon buzonSiguiente;
    private Boolean estado= true;
    

    public ProcesoIntermedio(String posicion, Buzon buzonAnterior, Buzon buzonSiguiente) {
        
		this.posicion = posicion;
		this.buzonAnterior = buzonAnterior;
		this.buzonSiguiente = buzonSiguiente;
	}

	public void run() {
        while (estado) {
            String mensaje = buzonAnterior.extraer();
            System.out.println("ProcesoIntermedio "+posicion+" extrae: "+mensaje);

           
            if (mensaje.equals("FIN")) {
                estado=false;
                buzonSiguiente.almacenar("FIN");

            }
            else{
                mensaje+="T"+posicion;
                System.out.println("ProcesoIntermedio "+posicion+" transforma: "+mensaje);
				try {
                    ProcesoIntermedio.sleep(ThreadLocalRandom.current().nextInt(40, 501));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                buzonSiguiente.almacenar(mensaje);
                System.out.println("ProcesoIntermedio "+posicion+" almacena: "+mensaje);

            }


        }
            
        
    }


}

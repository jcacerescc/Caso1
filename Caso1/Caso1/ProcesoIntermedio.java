package Caso1;

import java.util.concurrent.ThreadLocalRandom;

public class ProcesoIntermedio extends Thread {
    /*
     * @param buzonAnterior: buzon del proceso anterior
     * @param buzonSiguiente: buzon del proceso siguiente
     * @param estado: estado del proceso
     * @param posicion: posicion del proceso intermedio
     */
     
    
    private String posicion; 
    private Buzon buzonAnterior;
    private Buzon buzonSiguiente;
    private Boolean estado= true;
    
    //Constructor
    public ProcesoIntermedio(String posicion, Buzon buzonAnterior, Buzon buzonSiguiente) {
        
		this.posicion = posicion;
		this.buzonAnterior = buzonAnterior;
		this.buzonSiguiente = buzonSiguiente;
	}
    //Metodo que ejecuta el proceso intermedio
	public void run() {
        while (estado) {
            //se extrae un mensaje del buzon anterior 
            String mensaje = buzonAnterior.extraer();
            System.out.println("ProcesoIntermedio "+posicion+" extrae: "+mensaje);
            //se evalua si el mensaje es FIN
           
            if (mensaje.equals("FIN")) {
                // Si el mensaje es FIN se cambia el estado y se almacena en el buzon siguiente
                estado=false;
                buzonSiguiente.almacenar("FIN");

            }
            else{
                //Si el mensaje no es FIN se evalua si procede a realizar la transformacion del mensaje
                mensaje+="T"+posicion;
                System.out.println("ProcesoIntermedio "+posicion+" transforma: "+mensaje);
				try {
                    //Despues de transfrormar el mensaje, el proceso intermedio duerme un tiempo aleatorio
                    ProcesoIntermedio.sleep(ThreadLocalRandom.current().nextInt(50, 501));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //Se almacena el mensaje en el buzon siguiente
                buzonSiguiente.almacenar(mensaje);
                System.out.println("ProcesoIntermedio "+posicion+" almacena: "+mensaje);

            }


        }
            
        
    }


}

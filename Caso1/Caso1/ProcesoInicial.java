package Caso1;
import java.util.ArrayList;

public class ProcesoInicial extends Thread {
    private Boolean estado = true;
    private Buzon buzonSiguiente;
    private ArrayList<String> mensajes = new ArrayList <String>();

    private int nMensajes;
    public ProcesoInicial(Buzon buzonSiguiente, int nMensajes) {
        System.out.println("ProcesoInicial creado");
        this.buzonSiguiente = buzonSiguiente;
        this.nMensajes=nMensajes;
    }
    
    
    //Crea un ArrayList con los mensajes solicitados por consola
    public void crearMensajes() {
    	for(int i = 1; i <= nMensajes;i ++)
    	{   
    		mensajes.add("M"+i);
    	}
    }
    
    public void run() {
        crearMensajes();
        while ( estado) {
        	//Se depositan los mensajes que quepan dentro del buffer(Buzon)
        if(mensajes.isEmpty())
        {   
            for(int i = 1; i <= 3;i ++){
             buzonSiguiente.almacenar("FIN");

        }
        estado=false;    
    }
        else{ 
            buzonSiguiente.almacenar(mensajes.get(0));
            mensajes.remove(0);
            ProcesoInicial.yield();
        }
                
    }
}}
    

package Caso1;
import java.util.ArrayList;

public class ProcesoInicial extends Thread {
    
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
        while (!mensajes.isEmpty()) {
        	//Se depositan los mensajes que quepan dentro del buffer(Buzon)
        buzonSiguiente.almacenar(mensajes.get(0));
        
        mensajes.remove(0);
      
    
        if(mensajes.isEmpty())
        {   
             
            for(int i = 1; i <= 3;i ++){
             buzonSiguiente.almacenar("FIN");
        }
        try {
            ProcesoInicial.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
        
        


        }
        ProcesoInicial.yield();
        
    }
}
    

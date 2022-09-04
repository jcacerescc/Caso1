package Caso1;
import java.util.ArrayList;

public class ProcesoInicial extends Thread {
    /* Atributos 
        * estado: indica si el proceso esta activo o no
        * buzonSiguiente: buzon al que se le va a enviar el mensaje
        * mensajes: ArrayList que contiene los mensajes 
        *nmensajes: numero de mensajes a generar y enviar
        */
        

    private Boolean estado = true;
    private Buzon buzonSiguiente;
    private ArrayList<String> mensajes = new ArrayList <String>();
    private int nMensajes;

    //Constructor
    public ProcesoInicial(Buzon buzonSiguiente, int nMensajes) {
        System.out.println("ProcesoInicial creado");
        this.buzonSiguiente = buzonSiguiente;
        this.nMensajes=nMensajes;
    }
    
    
    //Crea un ArrayList con la cantidad de mensajes solicitados en main
    public void crearMensajes() {
    	for(int i = 1; i <= nMensajes;i ++)
    	{   
    		mensajes.add("M"+i);
    	}
    }
    //ejecucion del proceso
    public void run() {
        //Se crea el ArrayList de mensajes
        crearMensajes();

        while ( estado) {
        //se verifica si hay mensajes por procesar, si ya no hay se envian los "FIN" para terminar la ejecucion
        if(mensajes.isEmpty())
        {   //Se envian los "FIN" a los procesos intermedios
            for(int i = 1; i <= 3;i ++){
             buzonSiguiente.almacenarSemiactivamente("FIN");

        }
        // Se acaba el proceso si ya no hay mensajes por procesar y se enviaron los 3 FIN
        estado=false;    
    }
        else{ 
            //Se verifica si el buzon esta lleno, si es el caso se aplica espera semiactiva por medio del yield
            while(buzonSiguiente.estaLleno()){
                ProcesoInicial.yield();
            }
            // Una vez el buzon ya no esta lleno, Se extrae el primer mensaje del ArrayList
            String mensaje = mensajes.remove(0);
            //Se envia el mensaje al buzon
            buzonSiguiente.almacenarSemiactivamente(mensaje);
            //Se remueve el mensaje del ArrayList porque este ya fue almacenado en el siguiente buzon
            System.out.println("ProcesoInicial almacena: "+mensaje);
        }
                
    }
}}
    

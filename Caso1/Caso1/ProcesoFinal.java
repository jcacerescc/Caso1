package Caso1;

import java.util.ArrayList;

public class ProcesoFinal extends Thread {
    /*
        * @param buzonAnterior: buzon del proceso anterior
        * @param estado: estado del proceso
        * @param Fins: cantidad de mensajes FIN que se han recibido
        * @param MensajeFinal: arreglo con los mensajes transformados por los procesos intermedios
                */
        private Boolean estado= true;
        private int Fins=0; 
        private Buzon buzonAnterior;
        private ArrayList<String> MensajeFinal= new ArrayList<String>();
       //Constructor
        public ProcesoFinal( Buzon buzonAnterior ) {
            this.buzonAnterior = buzonAnterior;
        }
        
        // metodo que ejecuta el proceso final
		public void run(){ 
            while(estado){
                //Si llegan 3 mensajes FIN se cambia el estado para terminar la ejecucion
                if (Fins==3){
                    estado=false;
                    System.out.println(MensajeFinal);

                }
                else{
                    //Se verifica si el buzon anterior esta vacio para saber si no es posible extraer un mensaje, si es el caso se aplica espera semiactiva por medio del yield
                    while( buzonAnterior.estaVacio()){
                        ProcesoFinal.yield();
                    }
                    //Una vez sabemos que el buzon anterior  no esta vacio, se extrae el mensaje
                    String mensaje = buzonAnterior.extraerSemiactivamente( );
                    System.out.println("ProcesoFinal extrae: "+mensaje);
                    if (mensaje.equals("FIN")){
                        //Si el mensaje es FIN se aumenta la cantidad de mensajes FIN recibidos
                        Fins++;
                    }
                    //se agrega el mensaje al ArrayList de mensajes transformados
                    MensajeFinal.add(mensaje);

                }

            }
               

        }
        

    
}

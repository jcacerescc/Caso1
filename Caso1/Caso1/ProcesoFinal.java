package Caso1;

import java.util.ArrayList;

public class ProcesoFinal extends Thread {
        private Boolean estado= true;
        private int Fins=0; 
        private Buzon buzonAnterior;
        private ArrayList<String> MensajeFinal= new ArrayList<String>();
       
        public ProcesoFinal( Buzon buzonAnterior ) {
            this.buzonAnterior = buzonAnterior;
        }
        
   
		public void run(){ 
            while(estado){
                if (Fins==3){
                    estado=false;
                    System.out.println(MensajeFinal);

                }
                else{
                    String mensaje = buzonAnterior.extraer();
                    ProcesoFinal.yield();
                    System.out.println("ProcesoFinal extrae: "+mensaje);
                    if (mensaje.equals("FIN")){
                        Fins++;
                    }
                    else{

                    }
                    MensajeFinal.add(mensaje);

                }

            }
               

        }
        

    
}

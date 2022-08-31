package Caso1;

public class ProcesoFinal extends Thread {
        
        private String posicion;
        private Buzon buzonAnterior;
        
        public ProcesoFinal(String posicion, Buzon buzonAnterior) {
            this.posicion = posicion;
            this.buzonAnterior = buzonAnterior;
            
        }
        public void run(){
            while(true){
                String mensaje = buzonAnterior.extraer();
                System.out.println(mensaje);
            }
        }

    
}

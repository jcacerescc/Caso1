package Caso1;


public class ProcesoFinal extends Thread {
        
        private Buzon buzonAnterior;
        private static String MensajeFinal="";
       
        public ProcesoFinal( Buzon buzonAnterior ) {
            this.buzonAnterior = buzonAnterior;
            
            
        }
        public static String getMensajeFinal() {
			return MensajeFinal;
		}
		public void run(){
            
            for(int i = 1; i <= 6;i ++){
                String mensaje = buzonAnterior.extraer();
                MensajeFinal+= ", "+mensaje;
            
            ProcesoFinal.yield();}
            System.out.println("ssse: "+MensajeFinal);

        }
        

    
}

package Caso1;

public class ProcesoInicial extends Thread {
    
    private Buzon buzonSiguiente;
    
    
    public ProcesoInicial(Buzon buzonSiguiente) {
        this.buzonSiguiente = buzonSiguiente;
    }
    
    public void run() {
        while (true) {
           
            buzonSiguiente.almacenar("M1");
        }
    }
    
}

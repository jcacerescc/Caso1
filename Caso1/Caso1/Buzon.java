package Caso1;

import java.util.ArrayList;

public class Buzon {
    int tamanio;
    ArrayList <String> mensajes;
    Buzon(int tamanio) {
        this.tamanio = tamanio;
        this.mensajes = new ArrayList <String>();
    }

    public synchronized void almacenar(String mensaje) {
        while (this.mensajes.size() == this.tamanio) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        this.mensajes.add(mensaje);
    }


    
    public synchronized String extraer() {
        while (this.mensajes.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String mensaje = this.mensajes.remove(0);
        notifyAll();
        return mensaje;
    }
    
    
}

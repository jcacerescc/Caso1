package Caso1;

import java.util.ArrayList;

public class Buzon {
    /*atributos
    @param capacidad: capacidad del buzon
    @param mensajes: ArrayList que contiene los mensajes
    */
    int tamanio;
    ArrayList <String> mensajes;

    //Constructor
    Buzon(int tamanio) {
        this.tamanio = tamanio;
        this.mensajes = new ArrayList <String>();
    }
    //Metodo que almacena un mensaje en el buzon, evalua si puede almacenarlo, si no puede ejecuta wait(espera semiactiva )
    /*@param mensaje: mensaje a almacenar
    */
    public synchronized void almacenar(String mensaje) {
        while (mensajes.size() == tamanio) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        mensajes.add(mensaje);
        notifyAll();
    }
    /*Metodo que almacena un mensaje en el buzon semiactivamente, esta comprobacion se realiza en el proceso inicial
    @param mensaje: mensaje a almacenar
     */
    public synchronized void almacenarSemiactivamente(String mensaje) {
        mensajes.add(mensaje);
        notifyAll();
    }
    /*
     * Metodo que extrae un mensaje del buzon semiaactivamente, esta comprobacion se realiza en el Proceso final
     */
    public synchronized String extraerSemiactivamente() {
     
        String mensaje = mensajes.get(0);
        mensajes.remove(0);
        notifyAll();
        return mensaje;
    }

    /*
     * Metodo que extrae un mensaje del buzon, evalua si puede extraerlo, si no puede ejecuta wait(espera pasiva)
     */
    
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
    
    /*
     * Metodo que devuelve si el buzon esta vacio
     */
     
    public Boolean estaVacio() {
        return this.mensajes.size() == 0;
    }
    /*
     * Metodo que devuelve si el buzon esta lleno
     */
    public Boolean estaLleno() {
        return this.mensajes.size() == tamanio;
    }
}

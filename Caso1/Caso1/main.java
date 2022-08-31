package Caso1;
import java.util.Scanner;
public class main{
    public static void main(String[] args) {
    	//se recibe por consola el numero de mensajes y el tamanio de los buzones intermedios y extremos.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de mensajes: ");
        int n = sc.nextInt();
        System.out.println(n);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Ingrese el número de tamanio buzones intermedios: ");
        int tamanioBuzonintermedio = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese el número de tamanio buzones de extremos: ");
        int tamanioBuzonExtremo = sc2.nextInt();
        //se crea buzon inicial y final 
        Buzon b0 = new Buzon(tamanioBuzonExtremo);
        Buzon bf = new Buzon(tamanioBuzonExtremo);
        

        ProcesoInicial p1 = new ProcesoInicial(b0);
        }
    }
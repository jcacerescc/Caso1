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
        int tamanioBuzonIntermedio = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese el número de tamanio buzones de extremos: ");
        int tamanioBuzonExtremo = sc2.nextInt();
        //se crea buzon inicial y final 
        
        
        
        
        
        
        
        Buzon b0 = new Buzon(tamanioBuzonExtremo);
        
        Buzon bf = new Buzon(tamanioBuzonExtremo);
        
        Buzon b1112 = new Buzon(tamanioBuzonIntermedio);
        Buzon b1213 = new Buzon(tamanioBuzonIntermedio);
        
        Buzon b2122 = new Buzon(tamanioBuzonIntermedio);
        Buzon b2223 = new Buzon(tamanioBuzonIntermedio);
        
        Buzon b3132 = new Buzon(tamanioBuzonIntermedio);
        Buzon b3233 = new Buzon(tamanioBuzonIntermedio);
        

        ProcesoInicial p0 = new ProcesoInicial(b0,n);
        ProcesoIntermedio p11= new ProcesoIntermedio("11", b0, b1112);
        ProcesoIntermedio p12= new ProcesoIntermedio("12", b1112,b1213);
        ProcesoIntermedio p13= new ProcesoIntermedio("13", b1213, bf);

        ProcesoIntermedio p21= new ProcesoIntermedio("21", b0, b2122);
        ProcesoIntermedio p22= new ProcesoIntermedio("22", b2122, b2223);
        ProcesoIntermedio p23= new ProcesoIntermedio("23", b2223, bf);

        ProcesoIntermedio p31= new ProcesoIntermedio("31", b0, b3132);
        ProcesoIntermedio p32= new ProcesoIntermedio("32", b3132, b3233);
        ProcesoIntermedio p33= new ProcesoIntermedio("33", b3233, bf);


        ProcesoFinal pf=new ProcesoFinal(bf);
      
        
        
        
        p0.start();
        p11.start();
        p12.start();
        p13.start();
        p21.start();
        p22.start();
        p23.start();
        p31.start();
        p32.start();
        p33.start();
        
        
        pf.start();
        
        
        
        
        }
    }
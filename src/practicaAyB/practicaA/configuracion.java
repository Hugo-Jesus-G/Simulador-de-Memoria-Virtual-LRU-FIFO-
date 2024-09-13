/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaAyB.practicaA;
import java.util.Scanner;
/**
 *
 * @author Hugog
 */



public class configuracion {
    
     Scanner s=new Scanner(System.in);
private int n,marco;
private String cadena[];
int cadenaSize;
    public configuracion(){}
    
    
    public void datos(){
    
    System.out.println("Ingresa el tamaño de la cadena de referencia");
        cadenaSize=s.nextInt();
         cadena=new String[cadenaSize];
          
              System.out.println("ingresa la cadena de referencia ...");
        for(int i=0;i<cadena.length;i++){
            cadena[i]=s.nextLine();
        }
          System.out.println("ingresa el numero de marco:");
       marco=s.nextInt();}
    
  
    public String[] getCadena(){
    return cadena;
    }
    
    public void mostrarCAdena(){ 
        
        System.out.print("CADENA DE REFERECNIA=");
        System.out.print("[");
        for(String  c :cadena){
        
           System.out.print(c+",");
           
       }
        System.out.println("]");
    }
    
  
    
    public int getMarco(){
    
    return marco;
    }
    
}

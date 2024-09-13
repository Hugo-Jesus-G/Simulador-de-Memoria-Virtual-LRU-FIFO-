/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaAyB.practicaA;

import java.io.FileWriter;

/**
 *
 * @author Hugog
 */
public class Archivos {
    int tabla[][];
    int cadena[];
    int cola[];
    
    public void Archivos(){
    
    
  }
    
    
    public void setCadena(){}
    public void setTabla(int tabla[][]){}
    
    public void setCola(){}
  public void escribir(String msg){
  
      try {
          FileWriter file=new FileWriter("informacion.txt",true);
          
          file.write(msg);
          file.close();
      } catch (Exception e) {
          System.out.println("Archivo no encontrado ");
      }
  
  }  
    
    public static void main(String[] args) {
      
    
}
}
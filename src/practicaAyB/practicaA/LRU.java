package practicaAyB.practicaA;

import java.util.*;
import javax.swing.JOptionPane;


public class LRU {
	
	private int cantidadCadena;
	private int cantidadMarcos;
	String []cadenaReferencia,cadena;
	String [][]matriz;
	String []fallos;
	int []distancia;
        int cantidadFallos=0;
String matrizString="";
	public LRU(){
	}
 public String[] getFallos(){
    
    return fallos;
    }
  public String[][] getMatriz(){
    
    return matriz;
    }
	public void setCadena(String []cadenaReferencia) {
		this.cadenaReferencia = cadenaReferencia;
                this.cadena=cadenaReferencia;
	}

	public void setTamanoCadena(int cantidadCadena) {
		this.cantidadCadena = cantidadCadena;
	}

	public void setCantidadMarcos(int cantidadMarcos) {
		this.cantidadMarcos = cantidadMarcos;
	}
	
	public void iniciarxfallos(){
		for(int i=0;i<cantidadCadena;i++){
			fallos[i]="0";
		}
	}
	public String getMatrizString(){
        
        return matrizString;
        
        }
        
	private void iniciarMatriz(){
		for(int i=0;i<cantidadMarcos;i++){
			for(int j=0;j<cantidadCadena;j++){
				matriz[i][j]=" ";
			}
		}
	}
	
	private boolean buscar(int elementoActual){
		boolean encontrado=false;
		for(int i=0;i<cantidadMarcos;i++){
			if(cadenaReferencia[elementoActual].equals(matriz[i][elementoActual])){
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	private void llenarFila(int elementoActual, int marco){
            
		for(int j=elementoActual;j<cantidadCadena;j++){
                    matriz[marco][j]=cadenaReferencia[elementoActual];
		}
	}
	//este método me devolverá el frame que fue el mas antiguo en ser liberado
	private int MayorDistancia(int elementoActual){
		int mayorDist=0;
		for(int i=0;i<cantidadMarcos;i++){
			for(int j=elementoActual;j>=0;j--){
				if(matriz[i][elementoActual].equals(cadenaReferencia[j])){
					distancia[i]=elementoActual-j;
					break;
				}
			}
		}
		
		for(int i=0;i<cantidadMarcos;i++){
			if(distancia[i]>distancia[mayorDist]){
				mayorDist=i;
			}
		}
		return mayorDist;
	}
	
	private void modificar(int elementoActual){
		boolean encontradoMarcoLibre=false;
		int i;
		for(i=0;i<cantidadMarcos;i++){
			if(matriz[i][elementoActual].equals(" ")){
				encontradoMarcoLibre=true;
				break;
			}
		}
		
		if(!encontradoMarcoLibre){
			llenarFila(elementoActual, MayorDistancia(elementoActual));
		}else{
			llenarFila(elementoActual, (i));
		}
		
		fallos[elementoActual]="1";
		
	}
	
	public void algoritmoLru(){
		matriz=new String [cantidadMarcos][cantidadCadena];
		fallos= new String [cantidadCadena];
		distancia= new int[cantidadMarcos];
		iniciarxfallos();
		iniciarMatriz();
		//Recorremos todas las paginas
		for(int j=0;j<cantidadCadena;j++){
			if(!buscar(j)){
				modificar(j);
			}
		}
		mostrarTabla();
       
colaActulizacion();
 calculos();
mostrarCola();
	}
	
	public void mostrarTabla(){
		
                System.out.print("Referecnia|");
               for (int i = 0; i < cadena.length; i++) {
                   System.out.print(" "+cadena[i]);
            }
               System.out.print("\n----------------------------------\n");
               
		for(int i=0;i<cantidadMarcos;i++){
                    System.out.print("Marco "+i+"   |");
                    
			for(int j=0;j<cantidadCadena;j++){
				if(matriz[i][j].equals("")){
					System.out.print("  ");//para que no se muestre el -1 en la matriz
                                        matrizString+=" \n ";
				}else
				System.out.print(" "+matriz[i][j]);
                                
                                matrizString+=" "+matriz[i][j];
                                
			}
			System.out.println(" ");
                        matrizString+="\n ";
		}
		          System.out.print("Fallos    |");
                          matrizString+="Fallos    |";
		for(int i=0;i<cantidadCadena;i++){
			if(fallos[i].equals("1")){
				cantidadFallos++;
			}
			System.out.print(" "+fallos[i]);
                        matrizString+=" "+fallos[i];
		}
                System.out.println("");
                matrizString+="\n ";
	}
        
        
 

//codigo para la actualizacion de la cola
    
    ArrayList cola= new ArrayList<>();
    
    
   
    public void colaActulizacion() {
     //lista de los marcos
        ArrayList marcosLista = new ArrayList<>();
        //iteracion de la cadena de referencia
        for (String elementoCadena : cadena) {
            // Si el elemento de la cadena de ya esta en  la memoria, lo movemos al frente.
            if (marcosLista.contains(elementoCadena)) {
                marcosLista.remove((String)elementoCadena);
                
            } else {
                // Si no está en la memoria y la memoria está llena, eliminamos el elemento más antiguo.
                if (marcosLista.size() == cantidadMarcos) {
                    
                    marcosLista.remove(0);
                }
            }
            // Agregamos el elemento actual al frente.
            marcosLista.add(elementoCadena);
            
            // Creamos una copia de la cola actual de marcos y la agregamos a la lista de colas.
           ArrayList<Integer> copiaMarcosLista = new ArrayList<>(marcosLista);
            cola.add(copiaMarcosLista);
        }
         
         
    
        
        
    }
    String calculos="";

    public void calculos(){
        
        float razon = (float) cantidadFallos / cantidadCadena;
        float rendimiento = (float) (1 - (razon));
        System.out.println("Numero de Fallos=" + cantidadFallos);
        System.out.println("Razon de fallos=" + razon);
        System.out.println("Rendimiento=" + rendimiento*100+"%");
        calculos="\nNumero de Fallos=" + cantidadFallos+"\nRazon de fallos=" + razon+"\nRendimiento=" + rendimiento*100+"%";
razon=0;
rendimiento=0;
cantidadFallos=0;
    }
    
     public String calculo(){
  
  
  return calculos;
  }
     
         String colaString="";
          public void mostrarCola(){
     System.out.println("-------------Colas de estado del algoritmo LRU:-----------------------------");
        for (int i = 0; i < cola.size(); i++) {
            System.out.println( (i + 1) + ": " + cola.get(i));
                        colaString+=cola.get(i)+"\n";

        }}
          public String getCola(){
    return colaString;
    }
           public void limpiarDatos(){
   
   iniciarMatriz();
   iniciarxfallos();
   cola.clear();
   colaString="";
   calculos="";
   
   
   
   
   }
             Archivos file=new Archivos();
public void mandarInformacion(){
String infortmacion="Algoritmo Lru-------------------\n"+"\n"+getMatrizString()+"\n"+calculo()+"\n"+getCola();
    file.escribir(infortmacion);
    
        JOptionPane.showMessageDialog(null, "Informacion guardada con exito");

}
    

     
     
     
    /*
    public static void main(String[] args) {
       int cadena[]={4,3,2,1,4,3,5,4,3,2,1,5};
        int marcos = 3;
        LRU lru =new LRU();
        
   
          
		lru.setTamanoCadena(12);
		lru.setCantidadMarcos(3);
		lru.setCadena(cadena);
		lru.algoritmoLru();
                
                
    }*/
}

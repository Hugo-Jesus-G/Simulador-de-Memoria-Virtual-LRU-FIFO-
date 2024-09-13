package practicaAyB.practicaA;

import java.util.Scanner;

/**
 *
 * @author Hugog
 */
public class main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        configuracion c = new configuracion();
        Fifo f = new Fifo();
        LRU lru = new LRU();
        String defaultcadena[] = {"4","3", "2", "1","4", "3","5", "4", "3", "2", "1", "5"};
        int deafultMarco = 3;
        int defaultCadenaSize;

        int opcion;
        do {
            System.out.println("--------------------Gestion Virtual de Memoria--------------\n"
                    + "1:configuracion del sistema\n"
                    + "2-Algoritmo Fifo \n"
                    + "3-Algoritmo LRU \n"
                    + "4-Enviar a un archivo\n"
                    + "5-Salir");
            opcion = s.nextInt();
            switch (opcion) {

                case 1:

                    c.datos();

                    c.mostrarCAdena();
                    break;
                case 2:
                    System.out.println("----------Algoritmo FIFO------------------\n");

                    if (c.getCadena() == null) {

                        f.setTamanoCadena(defaultcadena.length);
                        f.setCantidadMarcos(deafultMarco);
                        f.setCadena(defaultcadena);
                        f.algoritmoFifo();

                    } else {

                        f.setTamanoCadena(c.getCadena().length);
                        f.setCantidadMarcos(c.getMarco());
                        f.setCadena(c.getCadena());
                        f.algoritmoFifo();

                    }
                    break;
                case 3:
                    System.out.println("---------Algoritmo LRU------------");
                    if (c.getCadena() == null) {
                        lru.setTamanoCadena(defaultcadena.length);
                        lru.setCantidadMarcos(deafultMarco);;
                      lru.setCadena(defaultcadena);
                        lru.algoritmoLru();

                    } else {

                        lru.setTamanoCadena(c.getCadena().length);
                        lru.setCantidadMarcos(c.getMarco());
                        lru.setCadena(c.getCadena());
                        lru.algoritmoLru();
                    }

                    break;
                case 4:
                    
                  
                   f.mandarInformacion();
                   lru.mandarInformacion();
                       System.out.println("informacion enviada correctamente ");
                   
                   
                  
                    break;
                case 5:

                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opcion incorrecta");

            }
        } while (opcion != 5);

    }

}

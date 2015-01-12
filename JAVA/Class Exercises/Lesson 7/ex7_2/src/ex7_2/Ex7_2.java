/*
 Programa que faça el següent:
- Definir constant N amb valor 10
- Definir un vector v de N enters.
- Omplir el vector amb dades per teclat.
- Mostrar el contingut del vector en 1 línia, separant amb comes. No ho implementes amb un for tradicional sinó amb l’altra forma que hem vist.

 */
package ex7_2;
import java.io.*;

/**
 *
 * @author Rumil
 */
public class Ex7_2 {

    static BufferedReader dataIn = 
            new BufferedReader (new InputStreamReader(System.in));
    static final int N = 10;
    
    public static void main(String[] args) {
        int v[]= new int[N];
        
        for (int i = 0; i < N; i++) {
            try {
                System.out.print("Escribe una cadena: ");
                String cadena = dataIn.readLine();
                int num = Integer.parseInt(cadena);
                v[i] = num;
            } catch (Exception e) {
            }
        }
        
        for(int value:v){
          
            System.out.print( value + ", ");
         
        }
        
        System.out.println("\b\b.");
    }
    
}

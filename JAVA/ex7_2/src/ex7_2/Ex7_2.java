/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7_2;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Rumil
 */
public class Ex7_2 {

    static BufferedReader dataIn = new BufferedReader (new InputStreamReader(System.in));
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
        
        System.out.println("\b.");
    }
    
}

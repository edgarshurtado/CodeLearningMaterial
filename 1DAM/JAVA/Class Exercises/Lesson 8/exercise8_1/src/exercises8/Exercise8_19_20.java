/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises8;

import java.util.Collections;
/**
 *
 * @author Rumil
 */
public class Exercise8_19_20 {
    public static void line(int n){
        //With for loop
//        for (int i = 0; i < n; i++) {
//            System.out.print("*");
//        }
//        System.out.println("");
        
        //Without for loop
        System.out.println(String.join("", Collections.nCopies(n, "*")));
    }
    public static void graphic(int[] vector){
        for(int i = 0; i < vector.length; i++){
            System.out.print(i + " : ");
            line(vector[i]);
        }
    }
    
}

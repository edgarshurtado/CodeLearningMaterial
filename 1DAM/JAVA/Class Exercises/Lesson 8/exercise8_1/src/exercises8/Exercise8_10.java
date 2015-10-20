/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises8;

/**
 *
 * @author Rumil
 */
public class Exercise8_10 {
    
    public static boolean isTriangle(int a, int b, int c){
        return a < (b+c) && b < (a+c) && c < (a+b);
    }
    
    public static String triangleType(int a, int b, int c){
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b ^ b == c ^ a == c) {
            return "Isosceles";
        } else return "Scalene";
        
    }
}

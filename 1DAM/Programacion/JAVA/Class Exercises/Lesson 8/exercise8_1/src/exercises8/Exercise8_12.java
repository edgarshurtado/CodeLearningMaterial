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
public class Exercise8_12 {
    public static int factorial(int num){
        int result = 1;
        for (int i = num; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}

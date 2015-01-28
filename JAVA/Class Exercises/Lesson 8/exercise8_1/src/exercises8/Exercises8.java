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
public class Exercises8 {
    
    public static void main(String[] args) {
        long perfectNumber;
        int i = 17;
        perfectNumber = (long) (Math.pow(2, i - 1) * (Math.pow(2, i) - 1));
        System.out.println(Exercise8_14.perfectNumber(perfectNumber));
    }
}

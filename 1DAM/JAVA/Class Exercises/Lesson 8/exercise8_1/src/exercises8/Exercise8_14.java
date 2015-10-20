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
public class Exercise8_14 {
    public static boolean perfectNumber(long number){
        long suma = 1;
        for (long i = 2; i <= number/2; i++) {
            if (number%i == 0) suma += i;
            System.out.println(suma);
        }
        return number == suma;
    }
    
    public static void fivePerfectNumbers(){
        long perfectNumber;
        int perfectNumbersFound = 0;
        
        for (int i = 2; perfectNumbersFound < 8; i++) {
            if (Exercise8_13.primeNumber(i)) {
                System.out.println(i);
                perfectNumber = (long) (Math.pow(2, i-1)*(Math.pow(2, i)-1));
                if (perfectNumber(perfectNumber)) {
                    System.out.println(perfectNumber);
                    perfectNumbersFound++;
                }
            }
        }
    }
}

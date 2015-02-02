/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Rumil
 */
public class UsefulFunctions {
    static BufferedReader dataIn = new BufferedReader
        (new InputStreamReader(System.in));
    
    public static int randomNumber(int maxNumber){
        int randomNumber;
        
        Random randomGenerator = new Random();
        
        randomNumber = randomGenerator.nextInt(maxNumber);
        
        return randomNumber;
    }
    
    static int intImput(){
        //Function for allow keyboard integer inputs
        
        int tempInt = 0;
        boolean correctInput = false;
        while(!correctInput){
            try {
                tempInt = Integer.parseInt(dataIn.readLine());
                correctInput = true;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Bad input, try again");
            }
        }
        return tempInt;
    } 
}

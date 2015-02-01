/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Random;

/**
 *
 * @author Rumil
 */
public class UsefulFunctions {
    
    public static int randomNumber(int maxNumber){
        int randomNumber;
        
        Random randomGenerator = new Random();
        
        randomNumber = randomGenerator.nextInt(maxNumber);
        
        return randomNumber;
    }
}

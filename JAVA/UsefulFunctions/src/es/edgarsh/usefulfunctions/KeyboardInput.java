/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.edgarsh.usefulfunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Rumil
 */
public class KeyboardInput {
    
    static BufferedReader dataIn = new BufferedReader
        (new InputStreamReader(System.in));
    
    public static int intImput(){
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
    
    public static String strInput(){
        String tempInput = "";
        boolean correctInput = false;
        while(!correctInput){
            try {
                tempInput = dataIn.readLine();
                correctInput = true;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Bad input, try again");
            }
        }
        return tempInput;
    }
    
    
}

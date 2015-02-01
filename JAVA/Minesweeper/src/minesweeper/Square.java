/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Rumil
 */
public class Square {
    private int minesAround;
    private String value;
    private boolean showValue;
    
    public Square(){
        this.value = " ";
        this.showValue = false;
    }
    
    public boolean getShowValue(){
        return this.showValue;
    }
    public String getValue(){
        return this.value;
    }    
}

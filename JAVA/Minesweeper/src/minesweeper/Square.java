
package minesweeper;

/**
 *
 * @author Edgar S. Hurtado
 */
public class Square {
    private int minesAround;
    private String value;
    private boolean showValue;
    
    public Square(){
        this.value = "0";
        this.showValue = false;
    }
    public void mine(){
        this.value = "M";
    }
    
    public void flag(){
        this.value = "F";
    }
    
    public void increaseValueBy1(){
        if (this.value != "M" && this.value != "F") {
            this.value = Integer.toString(Integer.parseInt(this.value) + 1);
        }
    }
    
    public void flipSquare(){
        this.showValue = true;
    }
    
    public boolean getShowValue(){
        return this.showValue;
    }
    public String getValue(){
        return this.value;
    }    
}

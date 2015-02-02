
package minesweeper;

/**
 *
 * @author Edgar S. Hurtado
 */
public class Square {
    private int minesAround;
    private String value;
    private boolean showValue;
    private boolean flagged;
    
    public Square(){
        this.value = "0";
        this.showValue = false;
        this.flagged = false;
    }
    public void mine(){
        this.value = "M";
    }
    
    public void flag(){
        this.flagged = true;
    }
    
    public void increaseValueBy1(){
        if (!"M".equals(this.value)) {
            this.value = Integer.toString(Integer.parseInt(this.value) + 1);
        } else {
        }
    }
    
    public void flipSquare(){
        this.showValue = true;
    }
    
    public boolean getShowValue(){
        return this.showValue;
    }
    
    public boolean getFlagged(){
        return this.flagged;
    }
    public String getValue(){
        return this.value;
    }    
}

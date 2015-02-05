
package minesweeper;

/**
 *
 * @author Edgar S. Hurtado
 */
public class Square {
    private int minesAround;
    private int value;
    private boolean flippedSquare;
    private boolean flagged;
    private boolean isMined;
    
    public Square(){
        this.value = 0;
        this.flippedSquare = false;
        this.flagged = false;
    }
    public void newMine(){
        this.isMined = true;
    }
    
    public boolean isMined(){
        return this.isMined;
    }
    
    public void flag(){
        this.flagged = true;
    }
    
    public void increaseValueBy1(){
        if (!this.isMined) {
            this.value++;
        } else {
        }
    }
    
    public void flipSquare(){
        this.flippedSquare = true;
    }
    
    public boolean isFlipped(){
        return this.flippedSquare;
    }
    
    public boolean isFlagged(){
        return this.flagged;
    }
    public int getValue(){
        return this.value;
    }    
}

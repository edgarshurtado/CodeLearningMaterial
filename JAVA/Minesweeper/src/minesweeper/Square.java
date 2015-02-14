
package minesweeper;

/**
 *
 * @author Edgar S. Hurtado
 */
public class Square {
    //The value is equal of the number of mines surrounding.
    private int minesAround; 
    //Possible square states
    private boolean flippedSquare;
    private boolean flagged;
    private boolean isMined;
    
    public Square(){
        this.minesAround = 0;
        this.flippedSquare = false;
        this.flagged = false;
    }
    public void newMine(){
        this.isMined = true;
    }
    public boolean isMined(){
        return this.isMined;
    }
    public void setFlag(){
        this.flagged = true;
    }
    public void removeFlag(){
        this.flagged = false;
    }    
    public void increaseValueBy1(){
        if (!this.isMined) {
            this.minesAround++;
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
        return this.minesAround;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Edgar S. Hurtado
 */

public class Board {
    private final Square[][] boardMatrix;
    private int numberOfMines;
    private int numberOfHidedSquares;
    private boolean minesExploded;
    //Characters legend for the board.
    private final char MINE = '*';
    private final char FLAG = 'F';
    private final char HIDE_SQUARE = 'X';
    //Helpful vector
    private final int[][] positionsAround; 
    
    public Board(int numberOfMines, int matrixSize){
        //Atributes asignations
        int[][] minesPositions;
        positionsAround = 
                new int[][]{{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        minesExploded = false;
        this.boardMatrix = new Square[matrixSize][matrixSize];
        this.numberOfHidedSquares = matrixSize*matrixSize;
        this.numberOfMines = numberOfMines;
        
        //Create the grid of squares
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                boardMatrix[row][col] = new Square();
            }
        }
        //Operations for set the mines
        minesPositions = generateMinesPositions(numberOfMines);
        plantMines(minesPositions);
        calcMinesAround(minesPositions);      
    }
    /**
     * Function to now if the game is over either if we have exploded the mines
     * or if we have won (flipped all the squares but the mines).
     * @return a boolean value equal to True when the game is over and false 
     * when the game stills.
     */
    public boolean isGameOver(){
        return this.minesExploded || this.numberOfHidedSquares == this.numberOfMines;
    }
    /**
     * Function that allows to know if the playar has explode the mines.
     * @return boolean value equal to True if the mines are exploded or equal
     * to false if the mines hasn't been exploded yet.
     */
    private boolean getMinesExploded(){
        return this.minesExploded;
    }
    
    /**
     * Function to flip a single square. If the player doesn't explode a mine
     * doing this, the function calls the recursive function flipCascade.
     * @param position array with the row as firt element and column as second.
     * The up-left corner position is 0,0
     */
    public void flipSquare(int[] position){
        try {
            if (this.boardMatrix[position[0]][position[1]].isMined()) {
            this.minesExploded = true;
        }else{
            flipCascade(position);
        }
            
        } catch (ArrayIndexOutOfBoundsException e) {
        }        
    }
    /**
     * Prints the values of the squares that are flipped and show an X in the squares of
     * unknown value.
     * 
     * If the game is over prints all the values.
     * @param cheats True if the user wants to see the mines position on the board
     * while the game is on going. This feature was added for testing.
     */
    public void printBoard(boolean cheats){
        //Go through the board matrix
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                if (cheats && this.boardMatrix[row][col].isMined()) {
                    //Print the mines if the player have activated the cheats
                    System.out.print(MINE + "|");
                }else {
                //Print logic without cheats.The condition allows to print
                    //a diferent matrix wheter the game stills going or not.
                    if (this.boardMatrix[row][col].isFlipped() || this.minesExploded) {
                        if (this.boardMatrix[row][col].isMined()) {
                            System.out.print(MINE + "|");
                        } else {
                            System.out.print(this.boardMatrix[row][col].getValue() + "|");
                        }
                    } else {
                        if (this.boardMatrix[row][col].isFlagged()) {
                            System.out.print(FLAG + "|");
                        } else {
                            System.out.print(HIDE_SQUARE + "|");
                        }
                    }
                }
            }//Print the row number at the left of the board
            System.out.println(" " + (row + 1) + " ");
        }
        System.out.println("");
        //Print the cols number at the bottom of the board
        for (int col = 0; col < this.boardMatrix[0].length; col++) {
            System.out.print((col + 1) + " ");
        }
        System.out.println(""); //scape line
    }
    /**
     * When the game is over, prints if we have won or if we have lost.
     */
    public void printGameOver(){
        printBoard(false);
        if (minesExploded) {
            System.out.println("You've lost");            
        }else{
            System.out.println("You've won");            
        }          
    }
    /**
     * Given a number of mines, generates that amount of random positions on the
     * board.
     * @param numberMines the number of mines we want to create for the game.
     * @return a matrix with the generated positions
     */
    private int[][] generateMinesPositions(int numberMines){
        int vectorIndex = 0;
        int[][] tempMinesVector = new int[this.numberOfHidedSquares][2];
        int[][] minesPositions = new int[numberMines][2];
        int[] transponserVector = new int[2];
        int maxIndex = numberOfHidedSquares;
        int coordIndex;
        //Generate a vector with all the possible positions
        for (int row = 0; row < this.boardMatrix.length; row++) {
            for (int col = 0; col < this.boardMatrix[0].length; col++) {
                tempMinesVector[vectorIndex][0] = row;
                tempMinesVector[vectorIndex][1] = col;
                vectorIndex++;
            }    
        }
        //Select the positions
        for (int minePositionIndex = 0; 
                minePositionIndex < minesPositions.length; minePositionIndex++) {
            coordIndex = UsefulFunctions.randomNumber(maxIndex);
            //Copy chosen values to the final vector
            minesPositions[minePositionIndex][0]=tempMinesVector[coordIndex][0];
            minesPositions[minePositionIndex][1]=tempMinesVector[coordIndex][1];
            //Save last position, copy to the used index, reduce the vector max index
            transponserVector[0] = tempMinesVector[maxIndex - 1][0];
            transponserVector[1] = tempMinesVector[maxIndex - 1][1];
            tempMinesVector[coordIndex][0] = transponserVector[0];
            tempMinesVector[coordIndex][1] = transponserVector[1];
            maxIndex--;
        }
        return minesPositions;
    }
    /**
     * Function that plant mines on the positions given by the parameter positions
     * @param positions array of arrays where each positionas has an array where
     * the first item is the mine row position and the second one is the mine
     * column position.
     */
    private void plantMines(int[][] positions){
        int row;
        int col;
        
        for (int coords = 0; coords < positions.length; coords++){
            row = positions[coords][0];
            col = positions[coords][1];
            this.boardMatrix[row][col].newMine();
        }
    }
    
    /**
     * Given a matrix with all the mines positions, calculates the number of mines
     * each square of the board is in touch. The resulting values are stored in each square.
     * @param minesPositions Matrix with the positions of the mines.
     */
    private void calcMinesAround(int[][] minesPositions){        
        int tempValue;
        for(int[] minePos : minesPositions){
            for(int[] posAr: this.positionsAround){
                try {
                    this.boardMatrix[minePos[0]+posAr[0]][minePos[1]+posAr[1]].increaseValueBy1();
                } catch (Exception e) {
                }
            }
        }
    }
    /**
     * Sets a square as flagged
     * @param position the position enetered by the player where he or she 
     * wants to set the flag.
     * @return 
     */
    public void newFlag(int[] position){
        if (!this.boardMatrix[position[0]][position[1]].isFlipped()){
            this.boardMatrix[position[0]][position[1]].setFlag();
        }
    }
    
    public void removeFlag(int[] position){
        if (!this.boardMatrix[position[0]][position[1]].isFlagged()){
            this.boardMatrix[position[0]][position[1]].setFlag();
        }
    }
    
    /**
     * Recursive function with the logic for the response of the player moves.
     * This function flips the initial square and all the surrounding sqares that
     * doesn't have mines. The recursiveness stops in the squares in touch with
     * some mine.
     * @param initialPosition The position to start flipp every square recursively.
     */
    private void flipCascade (int[] initialPosition){
        int[] newPos;
        boolean isFlagged;
        boolean isMined;
        boolean squareAlreadyFlipped;
        try {
            //Store some values to use them lately with a simplier sintax.
            squareAlreadyFlipped
                    = this.boardMatrix[initialPosition[0]][initialPosition[1]].isFlipped();
            isFlagged = 
                    this.boardMatrix[initialPosition[0]][initialPosition[1]].isFlagged();
            isMined =
                    this.boardMatrix[initialPosition[0]][initialPosition[1]].isMined();
            int minesAround =                    
                    this.boardMatrix[initialPosition[0]][initialPosition[1]].getValue();
            
            //Conditions to flip the square.
            if (!squareAlreadyFlipped && !isMined && !isFlagged) {
                this.boardMatrix[initialPosition[0]][initialPosition[1]].flipSquare();
                this.numberOfHidedSquares--;
                //Recursiveness
                if (minesAround == 0) {
                    for (int[] posAr : this.positionsAround) {
                        newPos = new int[]{posAr[0] + initialPosition[0],
                            posAr[1] + initialPosition[1]};
                        flipCascade(newPos);
                    }
                } else {
                }
        }
        } catch (Exception e) {
        }
    }  
}

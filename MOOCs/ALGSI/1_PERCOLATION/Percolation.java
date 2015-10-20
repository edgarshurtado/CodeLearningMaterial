public class Percolation {
    private int[][] grid;
    private boolean[][] isOpen;
    private int[] roots; 
    private UF rootsUF;
    
    public Percolation(int N){
        this.grid = new int[N][N];
        this.isOpen = new boolean[N][N];
        int sitesAmount = N*N;
        int siteID;
        rootsUF = new UF(sitesAmount+2); //UF instance. We add 2 because we need for the model an entry point
                                             //and an exit point.
        
        //For-loop to fill the data structure
        siteID=1;
        for(int row=0; row < N; row++){
            for(int site=0; site < N; site++){
                //Give to each site its ID
                this.grid[row][site]=siteID++;
                //Grid to keep track of the open and full sites
                this.isOpen[row][site]=false;
            }
        }         
    }
    
    public void open (int i, int j){
        //Convert the integers into grid indices
        int iIndex = i-1;
        int jIndex = j-1;
        //Get the site number ID
        int siteOpened;
        int siteAround;
        //Helpful vector for get the index of the sites around
            //the opened one
        int[][] positionsAround=
                new int[][]{{1,0},{0,-1},{0,1},{-1,0}}; 
        
        //Throw error if indices are out of the grid
        if (iIndex > this.grid.length || jIndex > this.grid.length){
            throw new IndexOutOfBoundsException();
        }
        
        //Open and union logic.
        if(!isOpen(i, j)){
            this.isOpen[iIndex][jIndex] = true; //Open the site if it's not open already
            siteOpened = this.grid[iIndex][jIndex]; //Save the number ID of the opened site.
            if(iIndex == 0){ //Union with the enter or exit point on sites at the top or bottom of the grid
                rootsUF.union(siteOpened, 0);                
            } else if(iIndex == (this.grid.length - 1)){
                rootsUF.union(siteOpened, (this.grid.length * this.grid.length) + 1);
            }
            for(int posVect = 0; posVect < positionsAround.length; posVect++){ //For-loop for the sites around
                try{
                    int newRowPos = iIndex + positionsAround[posVect][0];
                    int newColPos = jIndex + positionsAround[posVect][1];
                    siteAround = this.grid[newRowPos][newColPos];                   
                    if(this.isOpen[newRowPos][newColPos]){ //Union of the 2 sites if both are open
                        rootsUF.union(siteAround, siteOpened);                
                    }
                }catch(ArrayIndexOutOfBoundsException e){}  
            }
        }else {
            System.out.println("Already open");
        }
        
    }
    
    public boolean isOpen(int i, int j){
        //Convert the integers into grid indices
        int iIndex = i-1;
        int jIndex = j-1;
        
        return this.isOpen[iIndex][jIndex];
    }
    public boolean isFull(int i, int j){
        //Convert the integers into grid indices
        int iIndex = i-1;
        int jIndex = j-1;
        
        return !this.isOpen[iIndex][jIndex]; //If the site is open it's not full. I'm Mr. Obvious
    }
    public boolean percolates(){
        int enterPoint = 0;
        int exitPoint = (this.grid.length * this.grid.length) + 1;
        return rootsUF.connected(enterPoint, exitPoint);
    }
    
    public static void main(String[] args){
        Percolation test = new Percolation(4);

        test.open(1,1);

        test.open(2,1);

        test.open(3,2);

        test.open(4,1);
     
        System.out.println(test.percolates());
        
        for(int i= 0; i < test.isOpen.length; i++){
            for(int j = 0; j < test.isOpen.length; j++){
                System.out.print(test.isOpen[i][j]);
            }
            System.out.println();
        }
    }
}

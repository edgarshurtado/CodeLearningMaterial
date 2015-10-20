public class PercolationStats { 
    
    private double[] thresholdPerExperiment;
    private double meanThreshold;

    public PercolationStats(int N, int T) {
        Percolation test;
        this.thresholdPerExperiment = new double[T];
        for (int experiment = 0; experiment < T; experiment++) {
            test = new Percolation(N);
            int[][] positions = new int[N*N][2];
            
            int pos = 0; //helping counter for filling the positions array
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    //row and col + 1 because Percolation.open() corner 
                    //position is 1,1
                    positions[pos][0] = row+1;
                    positions[pos][1] = col+1; 
                    pos++; //increase the counter for the next iteration
                }
            }
            //Open random numbers since the experiment percolates.
            double openedSites = 0;
            while (!test.percolates()) {
                int randomPosition = StdRandom.uniform(pos);
                test.open(positions[randomPosition][0], 
                          positions[randomPosition][1]);
                positions[randomPosition][0] = positions[pos-1][0];
                positions[randomPosition][1] = positions[pos-1][1];
                pos--;
                openedSites++;
            }
            this.thresholdPerExperiment[experiment] = openedSites/(N*N);
        }
    }
    
    public void print() {
        for (double value : this.thresholdPerExperiment) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public double mean() {
        return StdStats.mean(this.thresholdPerExperiment);
    }
    
    public double stddev() {
        return StdStats.stddev(this.thresholdPerExperiment);
    }
    
    public double confidenceLo() {
  
        return this.mean() - (1.96*stddev()
                                  /Math.sqrt(this.thresholdPerExperiment.length));
        
    }
    
    public double confidenceHo() {
  
        return this.mean() + (1.96*stddev()
                                  /Math.sqrt(this.thresholdPerExperiment.length));
        
    }
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats test = new PercolationStats(N, T);
        
        System.out.println("mean:\t\t\t\t= "+test.mean());
        System.out.println("stddev:\t\t\t\t= "+test.stddev());
        System.out.println("95% conficence interval:\t= "+test.confidenceLo()
                               + " " + test.confidenceHo());
    }
}
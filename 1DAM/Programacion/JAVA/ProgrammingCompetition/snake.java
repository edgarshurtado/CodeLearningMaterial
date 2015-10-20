import java.util.Scanner;

public class Problema4 {


   static Scanner tec = new Scanner(System.in);

    //Problema H
    public static void main(String[] args) {

        int c = tec.nextInt();

        for (int i = 0; i < c; i++){
            caso(i+1);
        }
    }
    private static void caso(int c) {
        System.out.println("Caso " + c);

        int M = tec.nextInt();


        int N = tec.nextInt();

        boolean flag = false;

        if(M%2!=0){
            for(int i=0; i<M; i++){
                if(i%2==0 || i==0){
                    for (int j = 0; j < N; j++) {
                        System.out.print("#");
                    }
                    System.out.println("");
                }
                else{
                    for (int j = 0; j < N; j++) {
                        if (flag == false){
                            if (j < (N - 1)){
                                System.out.print(".");
                            }else {
                                System.out.print("#");
                                flag = true;
                            }
                            
                        }else {
                            if (j == 0){
                                System.out.print("#");
                            }else {
                                System.out.print(".");
                         
                            }
                            if (j == N - 1) {
                                flag = false;
                            }
                            

                        }

                    }
                    System.out.println();
                }

            }
        }
 
    }

}





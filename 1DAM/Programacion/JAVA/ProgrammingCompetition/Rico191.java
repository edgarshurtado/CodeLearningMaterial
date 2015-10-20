import java.util.*;

public class Rico191 {

    public static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        int casos = tec.nextInt();

        for (int i = 0; i < casos ; i++) {
            int cTanques = tec.nextInt();
            int capMay = tec.nextInt();
            int difTanq = tec.nextInt();

            int acTot = 0;
            for (int j = 0; j < cTanques ; j++) {
                acTot += capMay;
                capMay = capMay - difTanq;
            }
            System.out.println(acTot);
        }
    }
}

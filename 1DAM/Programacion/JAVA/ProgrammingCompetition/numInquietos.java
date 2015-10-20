
import java.util.*;

public class Problema3 {

    static Scanner tec = new Scanner(System.in);

    //Problema C
    public static void main(String[] args) {

        //Primer parametro
        int cPrueba = tec.nextInt();

        for (int prueba = 0; prueba < cPrueba; prueba++){
            casoPrueba();
        }

    }

    public static void casoPrueba() {
        //Segundo parametro
        int n = tec.nextInt();

        int mayor = 0;

        for (int i = 0; i <= n ; i++) {
            if (isInquieto(i)) {
                if (n % i == 0 ){
                    mayor = i;
                }
            }
        }

        if (mayor == 0){
            System.out.println("IMPOSIBLE");
        }else {
            System.out.println(mayor);
        }
    }

    public static boolean isInquieto(int n){

        boolean isInq = false;
        int cifN = cifras(n);

        for (int i = 0; i < cifN ; i++) {
                if (n % 10  == 5 || n % 10 == 8){
                    isInq = true;
                }else {
                    return false;
                }
            n /= 10;
        }
        return isInq;
    }

    public static int cifras(int n){
        int cifras = 0;

         while (n > 0) {
             n /= 10;
             cifras++;
         }

        return cifras;
    }
}

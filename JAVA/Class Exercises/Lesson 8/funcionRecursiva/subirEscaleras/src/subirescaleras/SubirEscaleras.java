/*
    Exercise description
*/

package subirescaleras;

/**
 *
 * @author Edgar S. Hurtado
 * 
 */



public class SubirEscaleras {

    static void subirEscalera(int escalones){
       if (escalones -1  > 0) {
            subirEscalera(escalones - 1);
        }
        System.out.println("Estoy en el escalón " + escalones);
}
    
    static void bajarEscalera(int escalones){
        System.out.println("Estoy en el escalón " + (escalones -1));
        if (escalones -1  > 0) {
            
            bajarEscalera(escalones - 1);
        }
    }
    
    static void bajarSubirEscalera(int escalones){
        System.out.println("Estoy en el escalón " + (escalones - 1));
        if (escalones - 1 > 0) {
            bajarSubirEscalera(escalones - 1);
        }
        System.out.println("Estoy en el escalón " + escalones);
    }
    
    static void writeSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            System.out.println("1\n1");
        } else {
            System.out.println(n -1);
            writeSequence(n - 1);
            System.out.println(n-1);
        }
    }
    
    static void upDown(int n, int m) {        
        if (n < 0) throw new IllegalArgumentException();
        
        if (n < m) {
            System.out.println(n);
            upDown(n+1, m);
        }

        if (n == m) {
            System.out.println(n);
        }
        
        if (n > 0 && n != m) {
            System.out.println(n);
        }
    }
    
    static void upDown2(int n, int m) {
    System.out.println(n);
    if (n < m) {
        upDown(n+1, m);
        System.out.println(n);
    }
}
    
   
    public static void main(String[] args) {
        upDown2(1, 6);
    }

}

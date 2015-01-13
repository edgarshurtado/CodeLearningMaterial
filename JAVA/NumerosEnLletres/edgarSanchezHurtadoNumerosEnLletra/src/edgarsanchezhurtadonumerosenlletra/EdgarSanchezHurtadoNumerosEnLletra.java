/*
    Exercise description
*/

package edgarsanchezhurtadonumerosenlletra;

import java.io.*;

/**
 *
 * @author Edgar S. Hurtado
 */


public class EdgarSanchezHurtadoNumerosEnLletra {

    static int digitUnitats(int q){
        int unitat;
        
        unitat= q % 10;
        
        return unitat;
        
    }
    
    static int digitDesenes(int q){
        int desenes;
        
        desenes = (q / 10) % 10;
        
        return desenes;
    }
    
    static int digitCentenes(int q){
        int centenes;
        
        centenes = q / 100;
        
        return centenes;
    }
    
    static String desenaEnLletres(int dig){
        String desena;
        
        switch (dig) {
            case 1:
                desena = "deu";
                break;
            case 2:
                desena = "vint";
                break;
            case 3:
                desena = "trenta";
                break;
            case 4:
                desena = "quaranta";
                break;
            case 5:
                desena = "cincuanta";
                break;
            case 6:
                desena = "seixanta";
                break;
            case 7:
                desena = "setanta";
                break;
            case 8:
                desena = "huitanta";
                break;
            case 9:
                desena = "noranta";
                break;
            case 0:
                desena = "";
                break;
            default:
                throw new AssertionError();
        }
        
        return desena;
    }
    
    static String digitEnLletres(int dig){
        
        String digit;
        
        switch (dig) {
            case 1:
                digit = "ú";
                break;
            case 2:
                digit = "dos";
                break;
            case 3:
                digit = "tres";
                break;
            case 4:
                digit = "quatre";
                break;
            case 5:
                digit = "cinq";
                break;
            case 6:
                digit = "sis";
                break;
            case 7:
                digit = "set";
                break;
            case 8:
                digit = "huit";
                break;
            case 9:
                digit = "nou";
                break;
            case 0:
                digit = "zero";
                break;
            default:
                throw new AssertionError();
        }
        
        return digit;
    }
    
    static String tresDigitsEnLletres(int q3){
        
        String unitats;
        String desenes;
        String centenes;
        
        unitats = digitEnLletres(digitUnitats(q3));
        desenes = desenaEnLletres(digitDesenes(q3));
        centenes = digitEnLletres(digitCentenes(q3));
        if(centenes.equals("ù")){
            centenes = "cent";
        }else{
            centenes += "-cent"; 
        }
        
        return centenes + " " + desenes + "-i-" + unitats;
    }
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            System.out.println(desenaEnLletres(i));
        }
       
    }

}

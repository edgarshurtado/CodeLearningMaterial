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
        
        String unitatsLletra;
        String desenesLletra;
        String centenesLletra;
        int unitatsNumero;
        int desenesNumero;
        int centenesNumero;

        unitatsNumero = digitUnitats(q3);
        desenesNumero = digitDesenes(q3);
        centenesNumero = digitCentenes(q3);

        if (centenesNumero != 0) {
            if (centenesNumero == 1) {
                centenesLletra = "cent";
            } else {
                centenesLletra = digitEnLletres(centenesNumero) + "-cents ";
            }
        }else{
                centenesLletra = "";
                }
        
        if (desenesNumero != 0) {
            if (desenesNumero == 1) {
                
            } 
        
        return centenesLletra;
    }
    
    public static void main(String[] args) {
        
       System.out.println(tresDigitsEnLletres(321)); 
        
        System.out.println(tresDigitsEnLletres(300));
        System.out.println(tresDigitsEnLletres(303));
        System.out.println(tresDigitsEnLletres(330));
        System.out.println(tresDigitsEnLletres(30));
        System.out.println(tresDigitsEnLletres(3));
        System.out.println(tresDigitsEnLletres(067));
        
       
    }

}

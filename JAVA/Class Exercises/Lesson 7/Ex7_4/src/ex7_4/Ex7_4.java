/*
Programa que treballe amb cadenes que faça el següent:
- Demanar nom i cognoms i deixar-ho en 3 variables String (nom, c1, c2).
- Mostrar el missatge “ Hola, Neus Garcia i Marqués! ” suposant que s’han 
teclejat les cadenes Neus Garcia Marqués
- Posar nom i cognoms en altra variable String (nomComplet).
- Mostrar quantes lletres ocupa el nom complet.
- Informar si els 2 cognoms són iguals o diferents.
 */
package ex7_4;
import java.io.*;
/**
 *
 * @author Rumil
 */
public class Ex7_4 {

    static BufferedReader dataIn =
            new BufferedReader (new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        String name = "";
        String c1 = "";
        String c2 = "";
        String fullName;
        int fullNameLength;
        String fullNameNWS;
        int charInFullName = 0;
       
        try {
            System.out.print("Nombre: ");
            name = dataIn.readLine();
            System.out.println("");
            
            System.out.print("1er Apellido: ");
            c1 = dataIn.readLine();
            System.out.println("");
            
            System.out.print("2º Apellido: ");
            c2 = dataIn.readLine();
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("Input Error");
        }
        
        System.out.println("Hola, " + name + " " + c1 + " y " + c2);
        
        fullName = name + " " + c1 + " " + c2;
        System.out.println("Nombre completo: " + fullName);

        
        fullNameNWS = fullName.replaceAll(" ", "");
        charInFullName = fullNameNWS.length();
        
        System.out.println("Letras en el nombre =" + charInFullName);
    }
    
}

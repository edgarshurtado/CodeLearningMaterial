/*
Programa que demane les 3 notes que han tret cadascun dels 15 alumnes i
ho guarde en una matriu. Després mostra el resultat, també en forma de matriu.
 */
package ex7_3;

import java.io.*;



/**
 *
 * @author Rumil
 */
public class Ex7_3 {

    static final int STUDENTS = 15;
    static final int SUBJECTS = 3;
    static BufferedReader dataIn = 
            new BufferedReader (new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        int academicRecord[][] = new int[STUDENTS][SUBJECTS];
        
        for(int student = 0; student < STUDENTS; student++){
            System.out.println("Estudiante nº " + (student + 1));
            for (int subject = 0; subject < SUBJECTS; subject++){
                System.out.println("Escribe la nota " + (subject + 1));
                
                
                try {
                    academicRecord[student][subject] =
                            Integer.parseInt(dataIn.readLine());
                    
                } catch (Exception e) {
                }
            }
        }
        
        for (int student = 0; student < STUDENTS; student++) {
            
            System.out.print("Student " + (student+1) + ":\t");
            
            for (int mark:academicRecord[student]){
                System.out.print(mark + " ");
            }
            System.out.println("");
        }
    }
    
}

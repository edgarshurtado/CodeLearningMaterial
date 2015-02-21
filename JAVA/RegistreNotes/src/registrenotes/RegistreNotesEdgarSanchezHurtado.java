/*
    Exercise description
*/

package registrenotes;

import java.io.*;
import es.edgarsh.usefulfunctions.KeyboardInput;

/**
 *
 * @author Edgar S. Hurtado
 */


public class RegistreNotesEdgarSanchezHurtado {

    /**
     * Creates a new Student instance and ask the user to introduce the student
     * personal data
     * @return a Student object with the values inicialiced.
     */
    static Student altaAlumne() {
        Student student = new Student();
        System.out.print("Student name (first name and surnames): ");
        student.setName(KeyboardInput.strInput());
        System.out.println("");
        
        while (true) {
            try {
                System.out.print("Student phone number: ");
                student.setTelef(KeyboardInput.intImput());
                break;
            } catch (Error e) {
                System.out.println("Error in number. It should have 9 digits");
            }
        }
        
        System.out.println("");
        System.out.print("Student street: ");
        student.setAdress(KeyboardInput.strInput());
        System.out.println("");
        System.out.print("Student adress number: ");
        student.setAdressNumber(KeyboardInput.intImput());
        System.out.println("");
        System.out.print("Student cp: ");
        student.setCp(KeyboardInput.intImput());
        
        return student;
    }
    
    public static void main(String[] args) {
        Student student1 = altaAlumne();
        
    }

}

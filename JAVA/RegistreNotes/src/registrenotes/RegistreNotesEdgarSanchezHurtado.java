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

    static Student altaAlumne() {
        Student student = new Student();
        System.out.print("Student name (first name and surnames): ");
        student.setName(KeyboardInput.strInput());
        System.out.println("");
        System.out.print("Student phone number: ");
        student.setTelef(KeyboardInput.intImput());
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
       
    }

}

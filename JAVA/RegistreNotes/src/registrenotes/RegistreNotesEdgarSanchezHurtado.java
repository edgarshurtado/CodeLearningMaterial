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
                student.setTelef(KeyboardInput.intInput());
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
        student.setAdressNumber(KeyboardInput.intInput());
        System.out.println("");
        System.out.print("Student cp: ");
        student.setCp(KeyboardInput.intInput());
        
        return student;
    }
    
    /**
     * Promps the user for a subject and trimester and changes the mark of
     * every student on that combination.
     * @param students 
     */
    static void evaluateTrimester(Student[] students) {
        int trimester;
        String subject;
        int mark;
        
        System.out.print("Wich subject: ");
        subject = Transcript.subjectInput();
        System.out.print("Wich trimester: ");
        trimester = Transcript.trimesterInput();
        
        for (Student student : students){
            System.out.print("Mark for " + student.getName() + " : ");
            mark = Transcript.markInput();
            student.setMark(mark, trimester, subject);
        }
    }
    /**
     * Scan an array for a student's name
     * @param name
     * @return int index of the array where's the student. Returns -1 if the
     * student hasn't been found
     */
    static int searchStudent(String name, Student[] students) {
        
        for (int i = 0; i < students.length; i++) {
            if (name.equals(students[i].getName())) {
                return i; //If the student name is in the array
            }
        }
        
        return -1; //If the student isn't in the array
    }
    
    /**
     * Prints the student personal data and his/her transcript
     * @param students 
     */
    static void showStudentData(Student[] students) {
        
        System.out.print("Please, insert a student's name: ");
        
        String student = KeyboardInput.strInput();
        int studentIndex = searchStudent(student, students);
        
        if (studentIndex >= 0) {
            System.out.println("Name: " + students[studentIndex].getName());;
            System.out.println("Adress: " + students[studentIndex].getAdress() +
                    " nº " + students[studentIndex].getNumber() + 
                    " cp " + students[studentIndex].getCp());
            System.out.println("");
            students[studentIndex].printTranscript();
        } else {
            System.out.println("Student wasn't found");
        }
    }
    
    /**
     * Testing set of students.
     * @return 
     */
    static Student[] testStudents() {
        Student[] students = new Student[3];
        //Student 1
        students[0] = new Student();
        students[0].setName("Edgar Sánchez Hurtado");
        students[0].setAdress("C/ Benicanena");
        students[0].setTelef(123456789);
        students[0].setAdressNumber(32);
        students[0].setCp(46702);
        //Student 2
        students[1] = new Student();
        students[1].setName("Mari Hurtado Segura");
        students[1].setAdress("C/ Rotova");
        students[1].setTelef(987654321);
        students[1].setAdressNumber(12);
        students[1].setCp(46701);
        //Student 3
        students[2] = new Student();
        students[2].setName("Aida Hurtado Ortí");
        students[2].setAdress("C/ Ferrocaril");
        students[2].setTelef(987123654);
        students[2].setAdressNumber(5);
        students[2].setCp(36000);
        
        return students;
    }
    
    public static void main(String[] args) {
        Student[] students = testStudents();
        
        showStudentData(students);
        
    }
}

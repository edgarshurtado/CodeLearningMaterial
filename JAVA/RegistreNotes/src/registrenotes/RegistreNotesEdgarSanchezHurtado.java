/*
    Exercise description
*/

package registrenotes;

import java.io.*;
import es.edgarsh.usefulfunctions.KeyboardInput;
import java.util.ArrayList;

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
    static void newStudent(ArrayList<Student> students) {
        Student student = new Student();
        System.out.print("Student name (first name and surnames): ");
        student.setName(KeyboardInput.strInput());
        System.out.println("");
        student.setPersonalData();        
        students.add(student);
    }
    
    /**
     * Promps the user for a subject and trimester and changes the mark of
     * every student on that combination.
     * @param students 
     */
    static void evaluateTrimester(ArrayList<Student> students) {
        int trimester;
        String subject;
        int mark;
        
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
     * Search for a student name in an ArrayList.
     * @param students
     * @param searchString
     * @return The position of the student in the array or -1 if the student
     * isn't found.
     */
    static int searchStudent(ArrayList<Student> students, String searchString) {
        int index = 0;
        
        for (Student student : students) {
            if (searchString.equals(student.getName())) {
                System.out.println(student.getName());
                return index;
            }
            index++;
        }
        return -1;
    }
        
    /**
     * Prints the student personal data and his/her transcript
     * @param students ArrayList of objects type Student
     */
    static void showStudentData(ArrayList<Student> students) {
        int studentIndex;
        
        System.out.print("Please, insert a student's name: ");
            
        String searchingString = KeyboardInput.strInput();
        
        studentIndex = searchStudent(students, searchingString);
        
        try {
            Student studentObject = students.get(studentIndex);
             //Personal data
            System.out.println("");
            System.out.println("Name: " + studentObject.getName());;
            System.out.println("Adress: " + studentObject.getAdress() +
                    " nº " + studentObject.getNumber() + 
                    " cp " + studentObject.getCp());
            System.out.println("Phone number: " + 
                    studentObject.getTelef());
            System.out.println("");
            System.out.println("Transcript");
            System.out.println("");
            studentObject.printTranscript();
        } catch (Exception e) {
            System.out.println("Student " + searchingString + " didn't find");
        } 
    }
    
    /**
     * Testing set of students.
     */
    static void testStudents(ArrayList<Student> students) {
        Student tempStudent;
        
        //Student 1
        tempStudent = new Student();
        tempStudent.setName("Edgar Sánchez Hurtado");
        tempStudent.setAdress("C/ Benicanena");
        tempStudent.setTelef(123456789);
        tempStudent.setAdressNumber(32);
        tempStudent.setCp(46702);
        tempStudent.setMark(7, 1, "PRG");
        students.add(tempStudent);
        //Student 2
        tempStudent = new Student();
        tempStudent.setName("Mari Hurtado Segura");
        tempStudent.setAdress("C/ Rotova");
        tempStudent.setTelef(987654321);
        tempStudent.setAdressNumber(12);
        tempStudent.setCp(46701);
        tempStudent.setMark(7, 2, "BDA");
        students.add(tempStudent);
        //Student 3
        tempStudent = new Student();
        tempStudent.setName("Niko");
        tempStudent.setAdress("C/ Falsa");
        tempStudent.setTelef(987123654);
        tempStudent.setAdressNumber(123);
        tempStudent.setCp(36000);
        tempStudent.setMark(7, 3, "EDD");
        students.add(tempStudent);
        
    }
    /**
     * Prints the posible options.
     */
    static void menu() {
        System.out.println("");
        System.out.println("1. New Student");
        System.out.println("2. Evaluate Trimester");
        System.out.println("3. Buscar alumne");
        System.out.println("0. Exit");
        System.out.println("");
    }
    /**
     * Asks the user for a int value in a range of values that corresponds to 
     * the available options of the menu.
     * @return int option value validated
     */
    static int selectOption() {
        int option;
        System.out.print("Select an option: ");
        option = KeyboardInput.intInput();
        while(option < 1 || option > 8) {
            System.out.print("Bad option, try again");
            option = KeyboardInput.intInput();
        }
        return option;        
    }
    
    /**
     * Do the math for the percentatges of students who passed the exams.
     * @param students
     * @return a matrix[3][3] with all the statistics data
     */
    static int[][] calcStatistics(ArrayList<Student> students) {
        int[][] passExam = new int[3][3];
        int[][] studentTranscript;
        
        for(Student student : students) {
            studentTranscript = student.getTranscript();
            for (int subj = 0; subj < 3; subj++) {
                for (int trim = 0; trim < 3; trim++) {
                    if (studentTranscript[subj][trim] >= 5) {
                        passExam[subj][trim]+= (1/(float)students.size())*100;
                    }
                }
            }
        }
        
        return passExam;
    }
    /**
     * Print the statics of students who passed the exams.
     * @param rawStatistics 
     */
    static void printStatistics(ArrayList<Student> students) {
        int[][] rawStatistics = calcStatistics(students);
        int[] subjectTotals = new int[3];
        
        System.out.println("\t1er trimestre\t2º trimestre\t3º trimestre\t"
                + "      Total"); //Table header
        
        for (int subjectIndex = 0; subjectIndex < 3; subjectIndex++) {
            //Subjec name
            System.out.print(Transcript.getSingleSubject(subjectIndex) + "\t\t");
            for (int trimester = 0; trimester < 3; trimester++) {
                //Subjec trimester mark
                System.out.print(rawStatistics[subjectIndex][trimester] + "\t\t");
            }
            //Subject total
            subjectTotals[subjectIndex] = (rawStatistics[subjectIndex][0] + 
                    rawStatistics[subjectIndex][1] + 
                    rawStatistics[subjectIndex][2])/3;
            System.out.print(subjectTotals[subjectIndex]);
            System.out.println(""); //change line
        }
        //Trimester totals
        System.out.print("TOTAL\t\t");
        System.out.print((rawStatistics[0][0] + rawStatistics[1][0] +
                rawStatistics[2][0])/3 + "\t\t");
        System.out.print((rawStatistics[0][1] + rawStatistics[1][1] +
                rawStatistics[2][1])/3 + "\t\t");
        System.out.print((rawStatistics[0][2] + rawStatistics[1][2] +
                rawStatistics[2][2])/3 + "\t\t");
        //Total of totals
        System.out.println((subjectTotals[0] + subjectTotals[1] + 
                subjectTotals[2])/3);
    }
    
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        testStudents(students);
        
        printStatistics(students);
   
//        int option;
//        boolean exit = false;
//
//        while  (!exit) {  
//            menu();
//            option = selectOption();
//            switch (option) {
//                case 1:
//                    newStudent(students);
//                    break;
//                case 2:
//                    evaluateTrimester(students);
//                    break;
//                case 3:
//                    showStudentData(students);
//                    break;
//                case 0:
//                    exit = true;
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//        }
    }
}

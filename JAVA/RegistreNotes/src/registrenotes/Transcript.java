/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrenotes;

import es.edgarsh.usefulfunctions.KeyboardInput;

/**
 *
 * @author Edgar S. Hurtado
 */
public class Transcript {
    
    private static final String[] subjects = {"PRG", "BDA", "EDD"};
    private int[][] transcript;
    
    public Transcript(){
        this.transcript = new int[Transcript.subjects.length][3];
        
        for (int i = 0; i < subjects.length; i++) {
            for (int j = 0; j < subjects.length; j++) {
                this.transcript[i][j] = -1;    
            }
        }
    }
    
    /**
     * Changes a single mark in the transcript
     * @param eval A value between 1 and 3.
     * @param subject The code of a subject.
     * @param newMark The mark to add.
     * @throws Error if the newMark es negative or either eval or subject are 
     * incorrect.
     */
    public void setSingleMark(int newMark, int eval, String subject) {
        int subjectIndex = -1;
        int evalIndex = eval -1;
        
        //Error control
        if (newMark > 10 || newMark < 0) {
            throw new Error();
        }
        
        if (evalIndex < 0 || evalIndex >= Transcript.subjects.length) {
            throw new Error();
        }
        
        for (int i = 0; i < Transcript.subjects.length; i++) {
            if (subject.equals(subjects[i])) {
                subjectIndex = i;                        
            }
        }
        if (subjectIndex == -1) throw new Error();
        
        // Value assignment
        this.transcript[subjectIndex][evalIndex] = newMark;
    }
    
    /**
     * Waits for the user input. If the mark isn't within 0-10, prompts the 
     * user for another value.
     * @return a int within 0-10
     */
    public static int markInput () {
        int mark = KeyboardInput.intInput();
        while (mark > 10 || mark < 0) {
            System.out.println("Invalid mark. Try again: ");
            mark = KeyboardInput.intInput();
        }
        return mark;
    }
    
    /**
     * Ask for a trimester between 1 and 3.
     * @return a valid trimester.
     */
    public static int trimesterInput() {
        int trimester = KeyboardInput.intInput();
        while (trimester < 1 || trimester > 3) {
            System.out.println("Error.");
            System.out.println("Trimester range is between 1 and 3.");
            System.out.print("Try again: ");
            trimester = KeyboardInput.intInput();
        }
        return trimester;
    }
    
    /**
     * Prompts the diferent subjects available and asks the user to insert 1 
     * option until it's correct.
     * @return String of a subject in subjects
     */
    public static String subjectInput() {
        System.out.println("---Select a subject--");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i+1) + ". " + subjects[i]); //i + 1 for the options
        }
        
        int option = KeyboardInput.intInput();
        
        while (option < 1 || option > subjects.length ){
            System.out.print("Bad input. Try again: ");
            option = KeyboardInput.intInput();
        }
        
        return subjects[option - 1]; // option - 1 to use subjects index
    }
    
    /**
     * getter for the transcript
     * @return A matrix with the marks. Each row represents a subject and each
     * column represents an evaluation
     */
    public int[][] getTranscript (){
        return this.transcript;
    }
    
    public static String[] getSubjects () {
        return subjects;
    }
}

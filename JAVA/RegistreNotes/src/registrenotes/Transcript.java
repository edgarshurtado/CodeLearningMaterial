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
     * @param subject The code of a subject. Choose between PRG, BDA or EDD
     * @param newMark The mark to add.
     * @throws Error if the newMark es negative or either eval or subject are 
     * incorrect.
     */
    public void setSingleMark(int newMark, int eval, String subject) {
        int subjectIndex = -1;
        int evalIndex = eval -1;
        
        //Error control
        newMark = evaluateMark(newMark);
        
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
     * Evaluates whether the mark isn't lower than 0 or greater than 10. If the 
     * mark parameter isn't within this range, prompts the user for another 
     * value.
     * @param mark int
     * @return a int within 0-10
     */
    private int evaluateMark (int mark) {
        while (mark > 10 || mark < 0) {
            System.out.println("Invalid mark. Try again: ");
            mark = KeyboardInput.intImput();
        }
        return mark;
    }
    
    /**
     * Ask for a trimester between 1 and 3.
     * @return a valid trimester.
     */
    public static int trimesterInput() {
        int trimester = KeyboardInput.intImput();
        while (trimester < 1 || trimester > 3) {
            System.out.println("Error.");
            System.out.println("Trimester range is between 1 and 3.");
            System.out.print("Try again: ");
            trimester = KeyboardInput.intImput();
        }
        return trimester;
    }
    
    /**
     * getter for the transcript
     * @return A matrix with the marks. Each row represents a subject and each
     * column represents an evaluation
     */
    public int[][] getTranscript (){
        return this.transcript;
    }
}

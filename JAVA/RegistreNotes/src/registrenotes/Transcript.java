/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrenotes;

/**
 *
 * @author Rumil
 */
public class Transcript {
    private static String[] subjects = {"PRG", "BDA", "EDD"};
    private int[][] transcript = new int[3][3];
    
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
        if (newMark < -1) throw new Error();
        
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
}

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
public class Student {
    
    private String name;
    private int telef;
    private String adress;
    private int adressNumber;
    private int cp;
    private Transcript transcript;

    public int getTelef() {
        return telef;
    }

    /**
     * Set the telef if the phone number parameter is valid.
     * @param telef int
     * @throws Error if the number isn't valid
     */
    public void setTelef(int telef) {
        if (KeyboardInput.validateTelef(telef)) {
            this.telef = telef;
        } else {
            throw new Error();
        }
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumber() {
        return adressNumber;
    }

    public void setAdressNumber(int number) {
        this.adressNumber = number;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
    
    public Student(){
        this.transcript = new Transcript();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
   
    public void setMark(int newMark, int eval, String Subject) {
        this.transcript.setSingleMark(newMark, eval, Subject);
    }
    
    public int[][] getTranscript() {
        return this.transcript.getTranscript();
    }
    
    public void setPersonalData() {
        
        while (true) {
            try {
                System.out.print("Student phone number: ");
                this.setTelef(KeyboardInput.intInput());
                break;
            } catch (Error e) {
                System.out.println("Error in number. It should have 9 digits");
            }
        }
        
        System.out.println("");
        System.out.print("Student street: ");
        this.setAdress(KeyboardInput.strInput());
        System.out.println("");
        System.out.print("Student adress number: ");
        this.setAdressNumber(KeyboardInput.intInput());
        System.out.println("");
        System.out.print("Student cp: ");
        this.setCp(KeyboardInput.intInput());
    }
    
    /**
     * Prints the student transcript formated.
     */
    public void printTranscript() {
        int[][] studentTranscript = this.getTranscript();
        String[] subjects = Transcript.getSubjects();
        
        System.out.println("Subject \t1 Trimester\t2 Trimester\t3 Trimester");
        System.out.println("--------------------------------------------------"
                + "----------");
        for (int subjectIndex = 0; subjectIndex < subjects.length 
                ; subjectIndex++) {
            System.out.print(subjects[subjectIndex] + " \t\t");
            for (int mark : studentTranscript[subjectIndex]) {
                if (mark == -1 ) {
                    System.out.print("NP \t\t");
                } else {
                    System.out.print(mark + " \t\t");
                }                
            }
            System.out.println("");
        }
    }
}

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
    private Transcript transcript;
    
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
    
}

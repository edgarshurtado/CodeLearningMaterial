/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Rumil
 */
public class datosChat {
	private ArrayList<String[]> historialChat;

	public datosChat() {
 		historialChat = new ArrayList<>();
	}

	public void addMessage(String user, String message){
		String[] newMessage = {user, message};
		this.historialChat.add(newMessage);
	}

	public ArrayList<String[]> getHistorial(){
		return this.historialChat;
	}


}

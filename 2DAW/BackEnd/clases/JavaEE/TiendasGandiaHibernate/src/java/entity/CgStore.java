/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rumil
 */

@Entity
@Table(name="cg_store")
public class CgStore implements Serializable{
	@Id
	@Column(name="store_id")
	private int store_id;
	@Column
	private String store_name;
	@Column
	private String store_address;
	@Column
	private String store_phone;

	public CgStore() {
	}

	public CgStore(String store_name, String store_address, String store_phone) {
		this.store_name = store_name;
		this.store_address = store_address;
		this.store_phone = store_phone;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}

	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Rumil
 */
@Entity
@Table(name="gnr_post")
public class Post implements Serializable{
	@Id
	@Column
	int post_id;

	@Column
	String post_title;

	@Column
	String post_slug;

	@Column
	String post_image;

	@Column
	String post_body;

	@Column
	Date post_date;

	public Post() {
	}

	public Post(String post_title, String post_slug, String post_body) {
		this.post_title = post_title;
		this.post_slug = post_slug;
		this.post_body = post_body;
		this.post_date = new Date();
	}


	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_slug() {
		return post_slug;
	}

	public void setPost_slug(String post_slug) {
		this.post_slug = post_slug;
	}

	public String getPost_image() {
		return post_image;
	}

	public void setPost_image(String post_image) {
		this.post_image = post_image;
	}

	public String getPost_body() {
		return post_body;
	}

	public void setPost_body(String post_body) {
		this.post_body = post_body;
	}

	
	
}

package com.atrium.messenger.model;



import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	

}

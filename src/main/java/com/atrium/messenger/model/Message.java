package com.atrium.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.xml.bind.annotation.XmlTransient;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;

	@XmlTransient
	private Map<Long, Comment> comments = new HashMap<>();

	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}

}

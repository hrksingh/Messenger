package com.atrium.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
public class Comment {

	private long id;
	private String message;
	private Date created;
	private String author;

	public Comment(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}

}

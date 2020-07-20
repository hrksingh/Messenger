package com.atrium.messenger.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
	private String userName;
	private String firstName;
	private String lastName;
	private Date created;
	
	
	public Profile(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}
	
	

}

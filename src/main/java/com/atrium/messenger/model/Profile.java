package com.atrium.messenger.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
	private long id;
	private String firstName;
	private String lastName;
	private Date created;

}

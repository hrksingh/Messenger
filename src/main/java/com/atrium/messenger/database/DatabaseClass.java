package com.atrium.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.atrium.messenger.model.Message;
import com.atrium.messenger.model.Profile;

import lombok.Getter;


public class DatabaseClass {
	
	@Getter
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	
	@Getter
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();

}

package com.atrium.messenger.services;

import java.util.ArrayList;
import java.util.List;

import com.atrium.messenger.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		
		Message m1 = new Message(1L, "hello from Hrk", "Hrk Singh");
		Message m2 = new Message(2L, "hello from Ash", "Ash");

		List<Message> messageList = new ArrayList<Message>();
		messageList.add(m1);
		messageList.add(m2);
		
		return messageList;

	}

}

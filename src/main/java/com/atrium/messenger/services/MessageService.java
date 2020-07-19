package com.atrium.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import com.atrium.messenger.database.DatabaseClass;
import com.atrium.messenger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	//Mock message data for database stub
	 public MessageService() {
		 
		 messages.put(1L, new Message(1, "its Hrk", "Hrk Singh"));
		 messages.put(2L, new Message(2, "hello from Ash", "Ash"));
		 
	 }

	public List<Message> getAllMessages() {

		return new ArrayList<Message>(messages.values());

	}

	public Message getMessage(long id) {
		if (!messages.containsKey(id)) {
			throw new RuntimeErrorException(new Error("No message with this message id: "+id+" found"));
		}
		return messages.get(id);

	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			throw new RuntimeErrorException(new Error("Message id should be greater then O"));
		}
		messages.put(message.getId(), message);

		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);

	}

}

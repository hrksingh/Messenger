package com.atrium.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.atrium.messenger.model.Message;
import com.atrium.messenger.services.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") long messageid) {

		return messageService.getMessage(messageid);
	}
	
	@POST
	public Message addMessage(Message message) {
		
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageid}")
	public Message updateMessage(Message message, @PathParam("messageid") long messageid) {
		message.setId(messageid);
		return messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messagesid}")
	public void removeMessage(@PathParam("messagesid") long messageid) {
        messageService.removeMessage(messageid);
	}
	 
}

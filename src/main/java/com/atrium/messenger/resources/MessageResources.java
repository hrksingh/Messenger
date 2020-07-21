package com.atrium.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.atrium.messenger.model.Message;
import com.atrium.messenger.resources.beans.MessageFilterBean;
import com.atrium.messenger.services.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean, @Context UriInfo uriInfo) {
		
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}

		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		List<Message> allMessages = messageService.getAllMessages();
		return allMessages;
	}
	
	@GET
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") long messageid, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(messageid);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");

		return message;
	}
	
	//<----------------------------------Different Uri's to for Links ArrayList---------------------------------------------->
	private String getUriForComments(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder().path(MessageResources.class)
				.path(MessageResources.class, "getCommentResource").path(CommentResource.class)
				.resolveTemplate("messageId", message.getId()).build();
		return uri.toString();
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder().path(ProfileResources.class).path(message.getAuthor()).build();
		return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder().path(MessageResources.class).path(Long.toString(message.getId()))
				.build().toString();
		return uri;
	}
	private String getUriForSelf(UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder().path(MessageResources.class)
				.build().toString();
		return uri;
	}
	
	//<-------------------------------------------------------------------------------------------------------------------->
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {

		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId)
				.build();
		
		return Response
				.created(uri)
				.entity(newMessage)
				.build();
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
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	 
}

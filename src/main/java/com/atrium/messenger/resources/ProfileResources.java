package com.atrium.messenger.resources;

import java.util.Date;
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

import com.atrium.messenger.model.Profile;
import com.atrium.messenger.services.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResources {

	ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}

	@GET
	@Path("/{username}")
	public Profile getProfile(@PathParam("username") String userName) {

		return profileService.getProfile(userName);
	}

	@POST
	public Profile addProfile(Profile profile) {
		profile.setCreated(new Date());
		return profileService.addProfile(profile);
	}

	@PUT
	@Path("/{username}")
	public Profile updateProfile(Profile profile, @PathParam("username") String userName) {
		profile.setUserName(userName);
		profile.setCreated(new Date());
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{username}")
	public void removeProfile(@PathParam("username") String userName) {
		profileService.removeProfile(userName);
	}

}

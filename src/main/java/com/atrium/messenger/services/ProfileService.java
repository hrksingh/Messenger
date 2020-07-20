package com.atrium.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.management.RuntimeErrorException;

import com.atrium.messenger.database.DatabaseClass;
import com.atrium.messenger.model.Profile;

public class ProfileService {

	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();

	// Mock message data for database stub
	public ProfileService() {
		profiles.put("Hrk123", new Profile("Hrk123","Hrk","Singh"));

	}

	public List<Profile> getAllProfiles() {

		return new ArrayList<Profile>(profiles.values());

	}

	public Profile getProfile(String userName) {
		if (!profiles.containsKey(userName)) {
			throw new RuntimeErrorException(new Error("No Profile with User Name : " + userName + " found"));
		}
		return profiles.get(userName);

	}

	public Profile addProfile(Profile profile) {
		profiles.put(profile.getUserName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getUserName().isEmpty()) {
			throw new RuntimeErrorException(new Error("Profile should have User Name"));
		}
		profiles.put(profile.getUserName(), profile);

		return profile;
	}

	public Profile removeProfile(String userName) {
		return profiles.remove(userName);

	}

}

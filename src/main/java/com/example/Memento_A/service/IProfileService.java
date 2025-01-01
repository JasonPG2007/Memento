package com.example.Memento_A.service;

import com.example.Memento_A.model.Profile;

import java.util.List;

public interface IProfileService {
    List<Profile> getProfiles();

    Profile getProfileById(int profileId);

    boolean createProfile(Profile profile);

    boolean updateProfile(Profile profile);

    void deleteProfile(int profileId);
}

package com.example.Memento_A.service;

import com.example.Memento_A.model.Profile;
import com.example.Memento_A.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService implements IProfileService {

    // Variable
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> getProfiles() {
        List<Profile> profileList = profileRepository.findAll();
        if (profileList.isEmpty()) {
            return List.of();
        }
        return profileList;
    }

    @Override
    public Profile getProfileById(int profileId) {
        Optional<Profile> profile = profileRepository.findById(profileId);
        if (profile.isPresent()) {
            return profile.get();
        }
        return null;
    }

    @Override
    public boolean createProfile(Profile profile) {
        boolean status = false;
        Profile profCheck = getProfileById(profile.getProfileId());
        if (profCheck == null) {
            Profile profSuccess = profileRepository.save(profile);
            if (profSuccess.getProfileId() > 0) {
                status = true;
            }
        }
        return status;
    }

    @Override
    public boolean updateProfile(Profile profile) {
        return false;
    }

    @Override
    public void deleteProfile(int profileId) {

    }
}

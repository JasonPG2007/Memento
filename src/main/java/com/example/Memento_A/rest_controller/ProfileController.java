package com.example.Memento_A.rest_controller;

import com.example.Memento_A.model.Account;
import com.example.Memento_A.model.Profile;
import com.example.Memento_A.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    // Variable
    @Autowired
    private ProfileService profileService;

    // GET: Profiles
    @GetMapping("/")
    public ResponseEntity<?> getProfiles() {
        List<Profile> profileList = profileService.getProfiles();
        return ResponseEntity.ok(profileList);
    }

    // GET BY ID: Profile
    @GetMapping("/{profileId}")
    public ResponseEntity<?> getProfileById(@PathVariable("profileId") int profileId) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.ok(Collections.singletonMap("msg", "This profile could not be found by id: " + profileId));
        }
        return ResponseEntity.ok(profile);
    }

    // POST: Create profile
    @PostMapping("/create")
    public ResponseEntity<?> createProfile(@Valid @RequestBody Profile profile, BindingResult result) {
        // Validate
        if (result.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (var item : result.getFieldErrors()) {
                errorMessages.add("Error: " + item.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMessages);
        }
        boolean isCreateSuccess = profileService.createProfile(profile);
        if (isCreateSuccess) {
            return ResponseEntity.ok(Collections.singletonMap("msg", "Created successfully"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("msg", "Creation failed. Please try again"));
    }
}

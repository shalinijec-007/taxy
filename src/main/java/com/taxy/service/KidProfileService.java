package com.taxy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxy.dto.KidProfileRequest;
import com.taxy.dto.KidProfileResponse;
import com.taxy.entity.KidProfile;
import com.taxy.exception.KidProfileNotFoundException;
import com.taxy.exception.UsernameAlreadyExistsException;
import com.taxy.repository.KidProfileRepository;

@Service
public class KidProfileService {

    private final KidProfileRepository kidProfileRepository;

    public KidProfileService(KidProfileRepository kidProfileRepository) {
        this.kidProfileRepository = kidProfileRepository;
    }

    public KidProfileResponse createProfile(KidProfileRequest request) {
    	
    	// Check whether the username is already taken
    	if (kidProfileRepository.existsByUsername(request.getUsername())) {
    	    throw new UsernameAlreadyExistsException(
    	        request.getUsername()
    	    );
    	}

        KidProfile profile = new KidProfile();

        profile.setName(request.getName());
        profile.setAge(request.getAge());
        profile.setTotalXp(0);
        profile.setLevel(1);
        profile.setUsername(request.getUsername());

        KidProfile savedProfile = kidProfileRepository.save(profile);

        return new KidProfileResponse(
                savedProfile.getId(),
                savedProfile.getName(),
                savedProfile.getAge(),
                savedProfile.getTotalXp(),
                savedProfile.getLevel()
        );
    }
    
    // Find an existing kid using the username
    public KidProfile getProfileByUsername(String username) {

    	return kidProfileRepository
                .findByUsername(username)
                .orElseThrow(() ->
                    new KidProfileNotFoundException(username)
                );
    }

    public List<KidProfile> getAllProfiles() {
        return kidProfileRepository.findAll();
    }
    
    public KidProfile getProfileById(Long id) {

        return kidProfileRepository
                .findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Kid profile not found")
                );
    }
    
 // Add earned XP to a kid profile
    public KidProfile addXp(Long id, Integer earnedXp) {

        // Find the kid in the database
        KidProfile profile = getProfileById(id);

        // Add the earned XP to the existing XP
        profile.setTotalXp(
            profile.getTotalXp() + earnedXp
        );

        // Save the updated profile back to PostgreSQL
        return kidProfileRepository.save(profile);
    }
}

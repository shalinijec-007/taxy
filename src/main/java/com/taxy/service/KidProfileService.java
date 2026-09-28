package com.taxy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxy.dto.KidProfileRequest;
import com.taxy.dto.KidProfileResponse;
import com.taxy.entity.KidProfile;
import com.taxy.exception.KidProfileNotFoundException;
import com.taxy.exception.UsernameAlreadyExistsException;
import com.taxy.repository.KidProfileRepository;

import jakarta.transaction.Transactional;

@Service
public class KidProfileService {

    private final KidProfileRepository kidProfileRepository;
    private final KidLessonProgressService progressService;

    public KidProfileService(KidProfileRepository kidProfileRepository,KidLessonProgressService progressService) {
        this.kidProfileRepository = kidProfileRepository;
        this.progressService = progressService;
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
    
    @Transactional
    // Add earned XP to a kid profile
    public KidProfile addXp(
            Long id,
            Long lessonId,
            Integer earnedXp) {
    	
    	// Do not award XP twice for the same lesson
        if (progressService.hasCompletedLesson(id, lessonId)) {
            return getProfileById(id);
        }

        // Find the kid in the database
        KidProfile profile = getProfileById(id);

        // Add the earned XP to the existing XP
        profile.setTotalXp(
            profile.getTotalXp() + earnedXp
        );

        KidProfile updatedProfile =
                kidProfileRepository.save(profile);

        // Remember that this lesson is completed
        progressService.markLessonCompleted(id, lessonId);

        return updatedProfile;
    }
}

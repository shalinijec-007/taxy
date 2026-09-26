package com.taxy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taxy.dto.KidProfileRequest;
import com.taxy.dto.KidProfileResponse;
import com.taxy.entity.KidProfile;
import com.taxy.service.KidProfileService;


@RestController
@RequestMapping("/api/kids")
public class KidProfileController {

    private final KidProfileService	 kidProfileService;

    public KidProfileController(KidProfileService kidProfileService) {
        this.kidProfileService = kidProfileService;
    }

    @PostMapping
    public ResponseEntity<KidProfileResponse> createProfile(
            @RequestBody KidProfileRequest request) {

        KidProfileResponse response =
                kidProfileService.createProfile(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<KidProfile>> getAllProfiles() {

        return ResponseEntity.ok(
                kidProfileService.getAllProfiles()
        );
    }
    
 // Add XP earned by a kid
    @PutMapping("/{id}/xp")
    public ResponseEntity<KidProfile> addXp(
            @PathVariable Long id,
            @RequestParam Integer earnedXp) {

        KidProfile updatedProfile =
                kidProfileService.addXp(id, earnedXp);

        return ResponseEntity.ok(updatedProfile);
    }
    
    @GetMapping("/username/{username}")
    public ResponseEntity<KidProfile> getProfileByUsername(
            @PathVariable String username) {

        KidProfile profile =
                kidProfileService.getProfileByUsername(username);

        return ResponseEntity.ok(profile);
    }
}

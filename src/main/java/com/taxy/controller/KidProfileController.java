package com.taxy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

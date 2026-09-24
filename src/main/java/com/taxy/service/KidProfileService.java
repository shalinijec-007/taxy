package com.taxy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxy.dto.KidProfileRequest;
import com.taxy.dto.KidProfileResponse;
import com.taxy.entity.KidProfile;
import com.taxy.repository.KidProfileRepository;

@Service
public class KidProfileService {

    private final KidProfileRepository kidProfileRepository;

    public KidProfileService(KidProfileRepository kidProfileRepository) {
        this.kidProfileRepository = kidProfileRepository;
    }

    public KidProfileResponse createProfile(KidProfileRequest request) {

        KidProfile profile = new KidProfile();

        profile.setName(request.getName());
        profile.setAge(request.getAge());
        profile.setTotalXp(0);
        profile.setLevel(1);

        KidProfile savedProfile = kidProfileRepository.save(profile);

        return new KidProfileResponse(
                savedProfile.getId(),
                savedProfile.getName(),
                savedProfile.getAge(),
                savedProfile.getTotalXp(),
                savedProfile.getLevel()
        );
    }

    public List<KidProfile> getAllProfiles() {
        return kidProfileRepository.findAll();
    }
}

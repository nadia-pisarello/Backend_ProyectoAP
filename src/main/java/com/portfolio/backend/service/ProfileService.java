package com.portfolio.backend.service;

import com.portfolio.backend.model.Profile;
import com.portfolio.backend.repository.ProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepo;

    public List<Profile> getProfile() {
        return profileRepo.findAll();
    }

    public void createProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public void delete(Long id) {
        profileRepo.deleteById(id);
    }

    public Profile findProfile(Long id) {
        return profileRepo.findById(id).orElse(null);
    }

    public void editProfile(Long id, Profile profile) {

        profileRepo.findById(id).map(
                editProfile -> {
                    editProfile.setName(profile.getName());
                    editProfile.setLastname(profile.getLastname());
                    editProfile.setPosition(profile.getPosition());
                    editProfile.setDescription(profile.getDescription());

                    return profileRepo.save(editProfile);
                });
    }
    
    public Boolean existsProfile(Long id){
        try { profileRepo.findById(id);
            return true;
        } catch(Exception e){return false;}
                    
    }

}

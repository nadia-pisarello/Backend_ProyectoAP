
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Profile;
import com.portfolio.backend.service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")

public class ProfileController {
    
    @Autowired ProfileService profileServ;
    
    @GetMapping("/profile/getAll")
    public List<Profile> getProfile(){
        return profileServ.getProfile();
    }
    @PostMapping("/profile/create")
    public String createUser(@RequestBody Profile profile){
        profileServ.createProfile(profile);
        return "Successful operation";
        
    }
    
    @DeleteMapping("/profile/delete/{id}")
    public String deleteProfile(@PathVariable Long id){
        profileServ.delete(id);
        return "Successful operation";
    }
        
    @PutMapping("/profile/update/{id}")
    public Profile editProfile(@PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("position") String position,
            @RequestParam("description") String description){
        Profile profile = profileServ.findProfile(id);
        profile.setName(name);
        profile.setLastname(lastname);
        profile.setPosition(position);
        profile.setDescription(description);
        profileServ.createProfile(profile);
        return profile;
    }    
    
    @GetMapping("/profile/getProfile")
    public Profile findProfile(){
        return profileServ.findProfile((long)1);
    }
}

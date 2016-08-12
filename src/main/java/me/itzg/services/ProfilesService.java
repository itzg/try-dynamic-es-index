package me.itzg.services;

import me.itzg.model.UserDoc;
import me.itzg.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simulates storing a user's details into ES
 */
@Service
public class ProfilesService {
    @Autowired
    private UserRepository userRepository;

    public void storeUser(String name) {
        final UserDoc userDoc = new UserDoc();
        userDoc.setName(name);
        userRepository.save(userDoc);
    }
}

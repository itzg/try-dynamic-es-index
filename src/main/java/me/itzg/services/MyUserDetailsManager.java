package me.itzg.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Very simple (incomplete) user details manager that stores the given details as-is, in memory
 */
public class MyUserDetailsManager implements UserDetailsManager {
    private Map<String, UserDetails> users =
            new HashMap<>();

    @Override
    public void createUser(UserDetails userDetails) {
        users.put(userDetails.getUsername().toLowerCase(), userDetails);
    }

    @Override
    public void updateUser(UserDetails userDetails) {

    }

    @Override
    public void deleteUser(String s) {

    }

    @Override
    public void changePassword(String s, String s1) {

    }

    @Override
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserDetails userDetails = users.get(username.toLowerCase());
        if (userDetails != null) {
            return userDetails;
        }
        else {
            throw new UsernameNotFoundException("Does not exist");
        }
    }
}

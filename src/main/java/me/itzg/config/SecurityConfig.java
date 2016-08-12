package me.itzg.config;

import me.itzg.model.RegionalUser;
import me.itzg.services.MyUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.Collections;

/**
 * Sets up our user details manager and adds 'user' suitable for unit testing
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsService() {
        final MyUserDetailsManager userDetailsManager =
                new MyUserDetailsManager();

        final RegionalUser user = new RegionalUser("user", "", Collections.singleton(new SimpleGrantedAuthority("ROLE_USE")));
        user.setRegion("sw");
        userDetailsManager.createUser(user);

        return userDetailsManager;
    }
}

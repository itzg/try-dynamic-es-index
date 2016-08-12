package me.itzg.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * A customized user that is regionally aware.
 */
public class RegionalUser extends org.springframework.security.core.userdetails.User {
    private String region;

    public RegionalUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

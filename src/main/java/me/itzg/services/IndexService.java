package me.itzg.services;

import me.itzg.model.RegionalUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Helps to resolve Elasticsearch index parameters.
 */
@Service
public class IndexService {

    public String getRegion() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final Object principal = authentication.getPrincipal();
            return ((RegionalUser) principal).getRegion();
        }
        else {
            return "default";
        }
    }
}

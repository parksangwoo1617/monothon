package com.example.ddip.facade;

import com.example.ddip.exception.CredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public String getId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication.getPrincipal() == null) {
            throw new CredentialsNotFoundException();
        }

        return authentication.getName();
    }
}

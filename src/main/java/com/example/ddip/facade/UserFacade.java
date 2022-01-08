package com.example.ddip.facade;

import com.example.ddip.exception.CredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public String getId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("testsetstsetsetsetse " + authentication.getName());
        if(authentication == null || authentication.getPrincipal() == null) {
            System.out.println("NULL CHECK");
            throw new CredentialsNotFoundException();
        }

        return authentication.getName();
    }
}

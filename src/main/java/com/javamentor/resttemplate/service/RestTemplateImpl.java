package com.javamentor.resttemplate.service;

import com.javamentor.resttemplate.model.Role;
import com.javamentor.resttemplate.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestTemplateImpl implements RestTemplate {
    @Override
    public User getUserAfterLogin() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Role> rolesUser = (List<Role>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        user.setRoles(rolesUser);
        return user;
    }
}

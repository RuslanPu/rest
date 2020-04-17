package com.javamentor.resttemplate.service;

import com.javamentor.resttemplate.model.Role;
import com.javamentor.resttemplate.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void add(User user, String[] checkboxRoles);

    void edit(User user, String[] checkboxRoles);

    void delete(User user);

    User getUserById(Long id);

    void addRole(Role role);

    boolean unicEmail(String email);

    List<Role> getAllRole();
}

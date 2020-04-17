package com.javamentor.resttemplate.dao;

import com.javamentor.resttemplate.model.User;


public interface UserDetailsDao {

    User getUserByName(String username);

}

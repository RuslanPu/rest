package com.javamentor.client.dao;

import com.javamentor.client.model.User;


public interface UserDetailsDao {

    User getUserByName(String username);

}

package com.javamentor.client.service;

import com.javamentor.client.model.JsonObject;
import com.javamentor.client.model.Role;
import com.javamentor.client.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateImpl extends RestTemplate {

    public User getUserAfterLogin(String email) {

        final String uri = "http://localhost:8081/user/getUser/{email}";
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(uri, User.class, email);

        return user;
    }

    public List<User> getUsersList() {
        String uri = "http://localhost:8081/admin/getUserList";
        RestTemplate restTemplate = new RestTemplate();
        JsonObject jsonObject = restTemplate.getForObject(uri, JsonObject.class);

        return jsonObject.getListUsers();
    }

}

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

    public User getUserAfterLogin(Long id) {

        final String uri = "http://localhost:8081/user/getUser/{id}";
//        String strId = id.toString();
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(uri, User.class, id);

        return user;
    }

}

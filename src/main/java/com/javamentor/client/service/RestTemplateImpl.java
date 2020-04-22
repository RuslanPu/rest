package com.javamentor.client.service;

import com.javamentor.client.model.JsonObject;
import com.javamentor.client.model.Role;
import com.javamentor.client.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateImpl extends RestTemplate {

    public String deleteUserById(Long id) {
        final String uri = "http://localhost:8081/admin/deleteUser/{id}";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class, id);
    }

    public User getUserAfterLogin(String email) {

        final String uri = "http://localhost:8081/user/getUser/{email}";
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(uri, User.class, email);

        return user;
    }

    public List<Role> getAllRoles(){
        String uri = "http://localhost:8081/admin/getAllRole";
        RestTemplate restTemplate = new RestTemplate();
        JsonObject jsonObject = restTemplate.getForObject(uri, JsonObject.class);
        return jsonObject.getAllRoles();
    }

    public List<User> getUsersList() {
        String uri = "http://localhost:8081/admin/getUserList";
        RestTemplate restTemplate = new RestTemplate();
        JsonObject jsonObject = restTemplate.getForObject(uri, JsonObject.class);

        return jsonObject.getListUsers();
    }
    public User getUserById(Long id) {
        String uri = "http://localhost:8081/admin/getUser/{id}";
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(uri, User.class, id);
        return user;
    }



    public String editUser(User user, String[] roles) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.setCurrentSelectedRolesForEdit(roles);
        jsonObject.setCurrentUserForEdit(user);


        String uri = "http://localhost:8081/admin/editUser";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(uri, jsonObject, String.class);
        return "edit";
    }

    public String addUser(User user, String[] roles) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.setCurrentSelectedRolesForEdit(roles);
        jsonObject.setCurrentUserForEdit(user);

        String uri = "http://localhost:8081/admin/addUser";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(uri, jsonObject, String.class);
        return "add";

    }

}

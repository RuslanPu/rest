package com.javamentor.client.controller;

import com.javamentor.client.model.JsonObject;
import com.javamentor.client.model.Role;
import com.javamentor.client.model.User;
import com.javamentor.client.service.RestTemplateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping()
public class CrudController {

    @Autowired
    private RestTemplateImpl restTemplate;

    @GetMapping("/admin/getUsersAfterLogin")
    public ResponseEntity<JsonObject> getAdminData(Principal principal) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.setUser(restTemplate.getUserAfterLogin(principal.getName()));
        jsonObject.setListUsers(restTemplate.getUsersList());
        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
    }

    @GetMapping("/user/getUserAfterLogin")
    public ResponseEntity<JsonObject> getUserdata(Principal principal) {
        JsonObject jsonObject = new JsonObject();
        String email = principal.getName();
        jsonObject.setUser(restTemplate.getUserAfterLogin(email));
        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);

    }

    @GetMapping("/admin/add")
    public ResponseEntity<JsonObject> getRoles() {

        JsonObject jsonObject = new JsonObject();
        jsonObject.setAllRoles(restTemplate.getAllRoles());

        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
    }

    @PostMapping("/admin/requestById")
    public ResponseEntity<JsonObject> getUserById(@RequestBody User user) {
        Long id = user.getId();
        User userById = restTemplate.getUserById(id);
        List<Role> allRoles = restTemplate.getAllRoles();
        JsonObject jsonObject = new JsonObject();
        jsonObject.setUser(userById);
        jsonObject.setAllRoles(allRoles);

        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);
    }

    @PostMapping("/admin/updateUser")
    public ResponseEntity<JsonObject> updateUser(@RequestBody User user) {
        System.out.println(user.getRoles());
        String[] roles = new String[user.getRoles().size()];
        for (int i = 0; i < user.getRoles().size(); i++) {
            roles[i] = user.getRoles().get(i).getName();
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.setUpdateUser(restTemplate.editUser(user, roles));
        return new ResponseEntity<JsonObject>(jsonObject, HttpStatus.OK);

    }


    @PostMapping("/admin/delete")
    public String deleteUser(@RequestBody User user) {
        Long id = user.getId();
        System.out.println(id);
        return restTemplate.deleteUserById(id);
    }

    @PostMapping("/admin/add")
    public String addUser(@RequestBody User user) {
        String[] roles = new String[user.getRoles().size()];
        User addUser = new User(user.getName(),user.getLastName(),user.getAge(),user.getPassword(),user.getEmail());
        for (int i = 0; i < user.getRoles().size(); i++) {
            roles[i] = user.getRoles().get(i).getName();
        }
        restTemplate.addUser(addUser, roles);
        return "add";
    }


}

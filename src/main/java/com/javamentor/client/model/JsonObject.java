package com.javamentor.client.model;

import java.util.List;
import java.util.Objects;

public class JsonObject {
    private User user;
    private List<Role> allRoles;
    private boolean unicEmail;
    private List<User> listUsers;

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public boolean isUnicEmail() {
        return unicEmail;
    }

    public void setUnicEmail(boolean unicEmail) {
        this.unicEmail = unicEmail;
    }

    public JsonObject() {
    }

    public JsonObject(User user, List<Role> allRoles) {
        this.user = user;
        this.allRoles = allRoles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<Role> allRoles) {
        this.allRoles = allRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonObject that = (JsonObject) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(allRoles, that.allRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, allRoles);
    }
}

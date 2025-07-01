package com.domhelder.reserve.dto;

import com.domhelder.reserve.entity.UserRoles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UserDTO {
    private String email;
    private String userName;
    private UserRoles role;

    private String rawPassord;

    public String getRawPassord() {
        return rawPassord;
    }

    public void setRawPassord(String rawPassord) {
        this.rawPassord = rawPassord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}

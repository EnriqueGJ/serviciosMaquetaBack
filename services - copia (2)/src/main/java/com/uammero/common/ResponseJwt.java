package com.uammero.common;

import com.uammero.entity.UserEntity;

public class ResponseJwt {

    private UserEntity user;
    private String Token;

    public ResponseJwt(UserEntity user, String Token) {
        this.user = user;
        this.Token = Token;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }
}

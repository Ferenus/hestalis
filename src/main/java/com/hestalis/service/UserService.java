package com.hestalis.service;

import com.hestalis.model.json.Login;

public class UserService {

    public Login getDefaultLogin() {
        Login login = new Login();
        login.setUsername("daniel");
        login.setPassword("aaa");
        return login;
    }
}

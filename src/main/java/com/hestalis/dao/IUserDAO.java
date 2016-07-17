package com.hestalis.dao;

import com.hestalis.model.entity.User;

/**
 * Created by Daniel on 2016-07-14.
 */
public interface IUserDAO {
    User getUserByUsername(String username);
    void setUser(User user);
}

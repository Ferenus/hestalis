package com.hestalis.dao.impl;

import com.hestalis.dao.IUserDAO;
import com.hestalis.model.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniel on 2015-10-14.
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserDAO implements IUserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List players = session.createQuery("from User where username='" + username +"'").list();
        if (players.size()==1) {
            return (User) players.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void setUser (User user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update User set username=:username, password=:password, enabled=:enabled, last_login=:last_login where id=:id");
        query.setInteger("id", user.getId());
        query.setString("username",user.getUsername());
        query.setString("password",user.getPassword());
        query.setBoolean("enabled", user.getEnabled());
        query.setDate("last_login", user.getLastLogin());
        query.executeUpdate();
        System.out.println("[UPDATE] User " + user.getUsername() + " is updated.");
    }
}

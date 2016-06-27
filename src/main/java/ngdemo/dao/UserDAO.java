package ngdemo.dao;

import ngdemo.model.entity.User;
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
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List players = session.createQuery("from User where username='" + username +"'").list();
        if (players.size()==1) {
            return (User) players.get(0);
        }
        return null;
    }

    @Transactional
    public void setUser (User user) {

    }
}

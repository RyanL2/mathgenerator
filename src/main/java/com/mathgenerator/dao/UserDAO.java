package com.mathgenerator.dao;

import com.mathgenerator.module.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;
import java.util.UUID;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }
    public Optional<User> findById(UUID id){
        return Optional.of(get(id));
    }
}

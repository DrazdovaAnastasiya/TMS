package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.JdbcUserStorage;
import by.tms.storage.UserStorage;


import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private static UserService instance;
    private final UserStorage storage = JdbcUserStorage.getInstance();
    private UserService() throws SQLException {

    }
    public static UserService getInstance() throws SQLException {
        if (instance == null){
            instance = new UserService();
        }
        return instance;
    }

    public void save(User user) {
        storage.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return storage.findByEmail(email);
    }

    public boolean checkEmail(String email) {
        return storage.checkEmail(email);
    }

    public boolean checkUsername(String username) {
        return storage.checkUsername(username);
    }
}

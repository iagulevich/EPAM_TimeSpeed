package dao;

import domain.dao_models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserStorage {
    private static UserStorage instance;
    private List<User> users;

    private UserStorage() {
    }

    private UserStorage(List<User> users) {
        this.users = users;
    }

    public static synchronized UserStorage getInstance(){
        if (instance == null) instance = new UserStorage(Collections.singletonList(new User("USER","123")));
        return instance;
    }

    public boolean isFound(User user){
        return users.contains(user);
    }
}

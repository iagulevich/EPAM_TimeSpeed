package domain.dao_models;

import support.exception.MyException;

import java.util.Arrays;

public class UserFactory {

    public static User create(String login, String password) throws Exception {
        if (validate(login, password)) return new User(login, password);
        throw new MyException("incorrect data");
    }

    public static User create(String name, String login, String password) throws Exception {
        if (validate(name,login, password)) return new User(name,login, password);
        throw new MyException("incorrect data");
    }

    /*private static boolean validate(String login, String password){
        if (login == null || password == null) return false;
        return !login.isEmpty() && !password.isEmpty();
    }*/

    private static boolean validate(String ... args) {
        return Arrays.stream(args).noneMatch(s -> s == null || s.isEmpty());
    }
}

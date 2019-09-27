package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {
    private static final List<User> userDb = new ArrayList<>();
    public void regist(User user) {
        userDb.add(user);
    }
    public int login(String username, String password) {
        if (userDb != null) {
            for (int i = 0; i < userDb.size(); i++) {
                if (userDb.get(0).getName().equals(username)) {
                    if (userDb.get(0).getPassword().equals(password)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    public static List<User> getUserDb() {
        return userDb;
    }
}

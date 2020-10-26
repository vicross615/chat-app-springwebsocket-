package storage;

import java.util.HashSet;
import java.util.Set;

public class UserRepo {
    private static UserRepo instance;
    private Set<String> users;

    private UserRepo() {
        users = new HashSet<String>();
    }

    public static synchronized UserRepo getInstance() {

        if(instance == null) {
            instance = new UserRepo();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUser(String userName) throws Exception {
        if(users.contains(userName)) {
            throw new Exception("User already exist--" + userName);
        }
    }
}


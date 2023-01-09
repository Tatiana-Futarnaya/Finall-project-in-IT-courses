package by.itclass.model.memory;

import by.itclass.model.beans.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserMemory {
    private static Map<User, String> usersMap;

    static {
        usersMap = new HashMap<>();
        usersMap.put(new User(1, "admin", "admin@gmail.com"), "q123");
    }

    //new User(login), pass
    public static User selectByLoginAndPassword(String login, String password) {
        Set<User> users=usersMap.keySet();
        User user=null;

        for(User us: users){
            if(us.getLogin().equals(login)){
                String pass=usersMap.get(us);
                if(pass.equals(password)){
                    user=us;
                }
            }
        }
        return user;
    }

    public static void addUser(String login, String email, String password) {
        usersMap.put(new User(usersMap.size() + 1, login, email), password);
    }

    public static boolean findRepeat(String login, String email){
        boolean result=false;
        for (Map.Entry<User, String> item: usersMap.entrySet()) {
            if(item.getKey().getLogin().equals(login) || item.getKey().getEmail().equals(email)){
                result=true;
            }
        }
        return result;
    }

}

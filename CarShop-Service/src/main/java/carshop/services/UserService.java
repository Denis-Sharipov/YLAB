package carshop.services;

import carshop.model.Role;
import carshop.model.User;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class UserService {
    private Map<String, User> users;
    private static final java.util.logging.LogManager LogManager = null;

    private static Logger logger;

    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\Admin\\Documents\\Quality Expert\\CarShop-Service\\src\\main\\resources\\log.txt")){
            LogManager.getLogManager().readConfiguration(ins);
            logger = Logger.getLogger(UserService.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }


    public UserService() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username){
        return users.get(username);
    }

    public Map<String, User> getUsers(){
        return users;
    }

    public void removeUser(User user){
        users.remove(user.getUsername());
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            logger.log(Level.INFO, "Пользователь зашёл в систему: " + user.getUsername());
            return user;
        }
        return null;
    }

    public User registration(String username, String password, Role role, String userInfo){
        if (!users.containsKey(username)){
            User user = new User(username, password, role, userInfo);
            addUser(user);
            logger.log(Level.INFO, "Зарегистрирован пользователь: " + user.getUsername());
            return user;
        }
        return null;
    }

    public User getUserByUsername(String userName) {
        return users.values()
                .stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst()
                .orElse(null);
    }

    public User getByUserInfo(String userInfo) {
        return users.values()
                .stream()
                .filter(user -> user.getUserInfo().equals(userInfo))
                .findFirst()
                .orElse(null);
    }

    public User getByUserInfo(int purchases) {
        return users.values()
                .stream()
                .filter(user -> user.getPurchases() == purchases)
                .findFirst()
                .orElse(null);
    }

    public void sortByUsername(){
        users = users.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(LinkedHashMap::new,
                        (m, c) -> m.put(c.getKey(), c.getValue()),
                        LinkedHashMap::putAll);
    }


    public void setUserName(User user, String username){
        user.setUsername(username);
    }

    public void setUserPassword(User user, String password){
        user.setPassword(password);
    }

    public void setUserRole(User user, Role role){
        user.setRole(role);
    }

    public void setUserInfo(User user, String userInfo){
        user.setUserInfo(userInfo);
    }

    public void setUserPurchases(User user, int purchases){
        user.setPurchases(purchases);
    }
}

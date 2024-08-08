package carshop.model;

public class User {
    private String username;
    private String password;
    private Role role;
    private String userInfo;
    private int purchases;

    public User(String username, String password, Role role, String userInfo) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.userInfo = userInfo;
        this.purchases = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(){
        this.purchases++;
    }
}

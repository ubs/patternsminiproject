package AppClasses;

/**
 *
 * @author iXeon
 */
public class User {
    //Data Fields
    private String userID;
    private String username;
    private String password;

    //Constructor
    public User() {
    }

    //Getters and Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

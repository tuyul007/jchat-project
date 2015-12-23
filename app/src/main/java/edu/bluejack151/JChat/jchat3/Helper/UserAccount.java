package edu.bluejack151.JChat.jchat3.Helper;

/**
 * Created by ASUS on 23/12/2015.
 */
public class UserAccount {
    private String userId;
    private String displayName;
    private String email;
    private String password;
    private String gender;
    private String profilePicture;
    private int notification;
    private int isPublic;

    public UserAccount(){}
    public UserAccount(String userId, String displayName, String email, String password, String gender, String profilePicture, int notification, int isPublic) {
        this.userId = userId;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.profilePicture = profilePicture;
        this.notification = notification;
        this.isPublic = isPublic;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public int getNotification() {
        return notification;
    }

    public void setNotification(int notification) {
        this.notification = notification;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }
}

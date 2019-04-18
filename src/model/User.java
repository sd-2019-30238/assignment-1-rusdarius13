package model;

public class User {

    private int userID;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userAddress;

    public User(String userName, String userPhone, String userAddress, String userPassword){
        this.userName = userName;
        this.userPhone= userPhone;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
    }

    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


}

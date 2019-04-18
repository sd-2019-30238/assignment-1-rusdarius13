package DAO;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAccess {

    public User logIn(String userName, String password){

        try{
            Connection conn = DbConnection.getConnection();
            String ps ="Select * from user where userName = ? and userPassword =?";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.setString(1,userName);
            stmt.setString(2,password);
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()){
                User user=new User(res.getString(1),res.getString(2),res.getString(3),res.getString(4));
                return user;
            }
            else{
                return null;
            }

        } catch (Exception e){
            System.out.println("Can't login!");
        }
        return null;
    }

    public void showAllUsers() {

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from user";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            while (res.next()) {
                System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4) + " ");

            }
        } catch (Exception e) {
            System.out.println("Can't connect!"+e);
        }
    }

    public void insertUser(User user1) {

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Insert into user (userName, userPhone, userAddress, userPassword) values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.setString(1, user1.getUserName());
            stmt.setString(2, user1.getUserPhone());
            stmt.setString(3, user1.getUserAddress());
            stmt.setString(4, user1.getUserPassword());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can't insert in database!"+e);
        }
    }

    public void deleteUser(User user1){

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Delete from user where userName ="+"'"+user1.getUserName()+"'";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can't connect!"+e);
        }
    }

    public int searchUser(User user1){

        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select count(userName) AS total from user where userName='"+user1.getUserName()+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            res.next();
            int count = res.getInt("total");
            return count;
        }catch (Exception e){
            System.out.println("Can't find the user!"+e);
        }
        return 0;
    }
}

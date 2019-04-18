package DAO;

import model.Deal;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CartAccess {

    public void addProduct(Deal d, User user){
        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Insert into cart (userName, productName, productPrice, quantity, productDiscount, status) values (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.setString(1,user.getUserName());
            stmt.setString(2, d.getDealName());
            stmt.setString(3, d.getDealPrice());
            stmt.setInt(4, d.getQuantity());
            stmt.setInt(5, d.getProductDiscount());
            stmt.setInt(6, 0);
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println("Can't add the product!");
        }
    }

    public ArrayList<String[]> getCart(User user){
        ArrayList<String[]> list = new ArrayList<String[]>();
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from cart where userName = '" + user.getUserName()+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()) {
                String[] temp = new String[200];
                for (int i = 0; i < 3; i++) {
                    temp[i] = res.getString(i + 2);
                    System.out.println(temp[i]);
                }
                list.add(temp);
            }
            else
                return null;
        }catch(Exception e){
            System.out.println("Can't connect!");
        }
        return list;
    }

    public void finishCart(User user){
        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Update cart set status = 1 where userName ='"+user.getUserName()+"'and status = 0";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            int res = stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Can't delete!");
        }
    }

    public void deliveredCart(User user){
        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Update cart set status = 2 where userName ='"+user.getUserName()+"'and status = 1";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            int res = stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Can't delete!");
        }
    }

    public void deleteProduct(Deal d){
        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Delete from cart where productName=?"+d.getDealName();
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            int res = stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Can't delete!");
        }
    }

    public void updatePrice(Deal d){
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Update cart set productPrice="+d.getDealPrice()+"where productName="+d.getDealName();
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            int res = stmt.executeUpdate();
        }catch (Exception e){
            System.out.println("Can't update!");
        }
    }

    public void updateQuantity(Deal d){
        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Update cart set quantity = 2 where productName='"+d.getDealName()+"'";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            int res = stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Can't update!");
        }
    }

    public void deleteCart(User user) {
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Delete from cart where userName='"+user.getUserName()+"' and status = 1";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            int res = stmt.executeUpdate();
        }catch (Exception e){
        System.out.println("Can't delete cart!");
        }
    }
}

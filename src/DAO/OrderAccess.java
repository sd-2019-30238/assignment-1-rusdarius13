package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class OrderAccess {
    public void addOrder(String userName, String price) {
        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Insert into orders (userName, price, status) values (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.setString(1, userName);
            stmt.setString(2, price);
            stmt.setInt(3, 0);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can't connect!");
        }
    }

    public void deliveredOrder(String username){
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Update order set status = 1 where username ='"+username+"'and status =0";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            int res = stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Can't connect!");
        }
    }

    public ArrayList<String[]> showOrders(String username) {
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from order where userName='"+username+"'and status =0";
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
        } catch (Exception e) {
            System.out.println("Can't connect!");
        }
        return list;
    }

    public ArrayList<String[]> showDeliveredOrders(String username) {

        ArrayList<String[]> list = new ArrayList<String[]>();

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from order where userName ='"+username+"' and status = 1";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()) {
                String[] temp = new String[200];
                for (int i = 0; i < 2; i++) {
                    temp[i] = res.getString(i + 2);
                    System.out.println(temp[i]);
                }
                list.add(temp);

            }
        } catch (Exception e) {
            System.out.println("Can't connect!");
        }
        return list;
    }

    public ArrayList<String[]> showNotDeliveredOrders(String username) {

        ArrayList<String[]> list = new ArrayList<String[]>();

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from order where userName ='"+username+"' and status = 0";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()) {
                String[] temp = new String[200];
                for (int i = 0; i < 2; i++) {
                    temp[i] = res.getString(i + 2);
                    System.out.println(temp[i]);
                }
                list.add(temp);

            }
        } catch (Exception e) {
            System.out.println("Can't connect!");
        }
        return list;
    }

    public void setStatus(String userName){

        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Update order set staus = 1 where username ='"+userName+"' and status = 0";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Cant't connect!");
        }
    }

}
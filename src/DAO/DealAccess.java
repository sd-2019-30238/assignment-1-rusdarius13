package DAO;

import model.Deal;

import java.sql.*;
import java.util.ArrayList;

public class DealAccess {

    public ArrayList<String[]> showDeals(){
        ArrayList<String[]> list = new ArrayList<String[]>();

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from deals";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()) {
                String[] temp = new String[200];
                for (int i = 0; i < 5; i++) {
                    temp[i] = res.getString(i + 1);
                    System.out.println(temp[i]);
                }
                list.add(temp);

            }
        } catch (Exception e) {
            System.out.println("Can't connect!");
        }
        return list;
    }

    public void addDeal(Deal d){
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Insert into deals (dealName, quantity, productDiscount, dealType, dealPrice) values (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.setString(1, d.getDealName());
            stmt.setInt(2, d.getQuantity());
            stmt.setInt(3, d.getProductDiscount());
            stmt.setString(4, d.getDealType());
            stmt.setString(5, d.getDealPrice());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Can't add deal!");
        }
    }

    public int searchDeal(Deal d){
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select count(dealName) AS total from deals where dealName='"+d.getDealName()+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            res.next();
            int count = res.getInt("Total");
            return count;
        }catch (Exception e){
            System.out.println("Can't find the deal!");
        }
        return 0;
    }

    public void deleteDeal(Deal d){
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Delete from deals where dealName ='"+d.getDealName()+"'";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
        }catch (Exception e){
            System.out.println("Can't delete deal!");
        }
    }

    public String getPrice(Deal d){
        String price="";
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select dealPrice from deals where dealName='"+d.getDealName()+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            res.next();
            price = res.getString("price");
        }catch (Exception e){
            System.out.println("Can't get price!");
        }
        return price;
    }

    public int getDiscount(Deal d){
        Integer discount=0;
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select prodDiscount from deals where dealName='"+d.getDealName()+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            res.next();
            discount = res.getInt("price");
        }catch (Exception e){
            System.out.println("Can't get price!");
        }
        return discount;
    }

    public int getQuantity(Deal d){
        Integer quantity=0;
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select quantity from deals where dealName='"+d.getDealName()+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            res.next();
            quantity = res.getInt("price");
        }catch (Exception e){
            System.out.println("Can't get price!");
        }
        return quantity;
    }


    public void updateQuantity(Deal d){
        int res = 0;
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Update deals set quantity='"+d.getQuantity()+"'where dealName='"+d.getDealName()+"'";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            res = stmt.executeUpdate();

        }catch (Exception e){
            System.out.println("Can't get price!");
        }
    }

    public void updatePrice(Deal d){
        int res = 0;
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Update deals set dealPrice='"+d.getDealPrice()+"'where dealName='"+d.getDealName()+"'";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            res = stmt.executeUpdate();

        }catch (Exception e){
            System.out.println("Can't get price!");
        }
    }

    public void applyDiscount(Deal d){
        int res= 0;
        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Update deals set productDiscount='"+d.getProductDiscount()+"'where dealName='"+d.getDealName()+"'";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
            res = stmt.executeUpdate();
        }catch (Exception e){
            System.out.println("Can't apply discount!");
        }
    }

    public ArrayList<String[]> showDealsByName(){
        ArrayList<String[]> list = new ArrayList<String[]>();

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from deals ORDER BY dealName";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()) {
                String[] temp = new String[200];
                for (int i = 0; i < 4; i++) {
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

    public ArrayList<String[]> showDealsByType(){
        ArrayList<String[]> list = new ArrayList<String[]>();

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from deals ORDER BY dealType";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()) {
                String[] temp = new String[200];
                for (int i = 0; i < 4; i++) {
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

    public ArrayList<String[]> showDealsByPrice(){
        ArrayList<String[]> list = new ArrayList<String[]>();

        try {
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from deals ORDER BY dealPrice";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()) {
                String[] temp = new String[200];
                for (int i = 0; i < 4; i++) {
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


}


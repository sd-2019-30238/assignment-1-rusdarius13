package DAO;

import model.Staff;
import java.sql.*;


public class StaffAccess {

    public Staff logIn(String staffName, String pasword){

        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from staff where staffName =? and staffPassword =?";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.setString(1, staffName);
            stmt.setString(2, pasword);
            ResultSet res = stmt.executeQuery(ps);
            if(res.next()){
                Staff staff = new Staff(res.getString(1), res.getString(2));
                return staff;
            }
            else {
                return null;
            }
        }catch(Exception e){
            System.out.println("Can't login!");
        }
        return null;
    }


    public void ShowAllStaff(){

        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select * from staff";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            while(res.next()){
                System.out.println(res.getString(1) + " " + res.getString(2) );
            }
        }catch(Exception e){
            System.out.println("Can't connect!");
        }
    }

    public void insertStaff(Staff staff1){

        try{
            Connection conn = DbConnection.getConnection();
            String ps = " Insert into staff (staffName, staffPassword) values (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.setString(1, staff1.getStaffName());
            stmt.setString(2, staff1.getStaffPassword());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Can't connect!");
        }
    }

    public void deleteStaff(Staff staff1){

        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Delete from staff where staffName ="+"'"+staff1.getStaffName()+"'";
            PreparedStatement stmt = conn.prepareStatement(ps);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Can't connect!");
        }
    }

    public int searchStaff(Staff staff1){

        try{
            Connection conn = DbConnection.getConnection();
            String ps = "Select count(staffName) AS total from staff where staffName='"+staff1.getStaffName()+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(ps);
            res.next();
            int count=res.getInt("total");
            return count;
        }catch(Exception e){
            System.out.println("Can't find the staff member!"+e);
        }
        return 0;
    }
}

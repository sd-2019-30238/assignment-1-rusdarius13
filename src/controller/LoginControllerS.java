package controller;

import DAO.StaffAccess;
import model.Staff;


public class LoginControllerS {

    private StaffAccess staffAccess;

    public LoginControllerS(StaffAccess staffAccess) {
    	this.staffAccess=staffAccess;
    }

    
    public Staff login(String username, String password) {
        return staffAccess.logIn(username, password); }


    public void addStaff(String username, String password) {
        Staff staff=new Staff(username,password);
        staffAccess.insertStaff(staff);
    }
}

package controller;

import DAO.OrderAccess;
import model.User;

import java.util.ArrayList;

public class OrderController {

    public void addOrder(String total, String username){
        OrderAccess orderAccess = new OrderAccess();
        User user = new User();
        user.setUserName(username);
        orderAccess.addOrder(user.getUserName(), total);
    }

    public void modifyOrderStatus(String username){
        OrderAccess orderAccess = new OrderAccess();
        User user = new User();
        user.setUserName(username);
        orderAccess.setStatus(user.getUserName());
    }


    public ArrayList<String[]> getAllDeliveredOrders(String username){
        ArrayList<String[]> list = new ArrayList<String[]>();
        OrderAccess orderAccess = new OrderAccess();
        list = orderAccess.showDeliveredOrders(username);
        return list;
    }

    public ArrayList<String[]> getAllNotDeliveredOrders(String username){
        ArrayList<String[]> list = new ArrayList<String[]>();
        OrderAccess orderAccess = new OrderAccess();
        list = orderAccess.showNotDeliveredOrders(username);
        return list;
    }

}

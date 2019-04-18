package controller;

import DAO.DealAccess;
import model.Deal;

import java.util.ArrayList;

public class DealController {
    public ArrayList<String[]> showDeals(String filter){
        ArrayList<String[]> list = new ArrayList<String[]>();
        DealAccess dealAccess = new DealAccess();
        switch(filter){
            case "name":
                list = dealAccess.showDealsByName();
                break;
            case "price":
                list = dealAccess.showDealsByPrice();
                break;
            case "type":
                list = dealAccess.showDealsByType();
                break;
        }
        return list;
    }

    public int addNewDeals(String name, int quantity, int discount, String type, String price){
        float verificarePret = Float.parseFloat(price);
        if(verificarePret <= 0)
            return 0;
        if(quantity<=0)
            return 0;
        Deal d = new Deal(name, quantity, discount, type, price);
        DealAccess dealAccess = new DealAccess();
        int verificareDeal = dealAccess.searchDeal(d);
        if(verificareDeal!=0)
            return 2;
        dealAccess.addDeal(d);
        return 1;
    }

    public ArrayList<String[]>showDealStaff(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        DealAccess dealAccess = new DealAccess();
        list = dealAccess.showDeals();
        return list;
    }

    public void deleteDeal(String name){
        Deal d = new Deal();
        DealAccess dealAccess = new DealAccess();
        d.setDealName(name);
        dealAccess.deleteDeal(d);
    }

    public boolean updateQuantity(String name, Integer quantity){
        Deal d = new Deal();
        DealAccess dealAccess = new DealAccess();
        if(quantity<=0)
            return false;
        d.setDealName(name);
        d.setQuantity(quantity);
        dealAccess.updateQuantity(d);
        return true;
    }

    public void updateDiscount(String name, Integer discount){
        Deal d = new Deal();
        DealAccess dealAccess = new DealAccess();
        d.setDealName(name);
        d.setProductDiscount(discount);
        dealAccess.applyDiscount(d);
    }

}

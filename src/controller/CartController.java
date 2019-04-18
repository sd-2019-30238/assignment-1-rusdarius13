package controller;

import DAO.CartAccess;
import DAO.DealAccess;
import model.Deal;
import model.User;

import java.util.ArrayList;

public class CartController {

    public boolean addCart(String dealName, String username){
        Deal d = new Deal();
        d.setDealName(dealName);
        DealAccess dealAccess = new DealAccess();
        int quantity = dealAccess.getQuantity(d);
        String price = dealAccess.getPrice(d);
        if(quantity>0){
            User user = new User();
            user.setUserName(username);
            CartAccess cartAccess = new CartAccess();
            d.setQuantity(1);
            d.setDealPrice(price);
            cartAccess.addProduct(d,user);
            quantity--;
            d.setQuantity(quantity);
            dealAccess.updateQuantity(d);
            return true;
        }
        return false;
    }

    public void deleteProduct(String dealName){
        Deal d = new Deal();
        d.setDealName(dealName);
        DealAccess dealAccess = new DealAccess();
        CartAccess cartAccess = new CartAccess();
        cartAccess.deleteProduct(d);
        int quantity = dealAccess.getQuantity(d);
        quantity++;
        d.setQuantity(quantity);
        dealAccess.updateQuantity(d);
    }

    public ArrayList<String[]> getCart(String username){
        ArrayList<String[]> list = new ArrayList<String[]>();
        User user = new User();
        user.setUserName(username);
        CartAccess cartAccess = new CartAccess();
        list = cartAccess.getCart(user);
        return list;
    }

    public float getTotal(String username){
        ArrayList<String[]> list = getCart(username);
        float total = (float) 0;
        if(list.isEmpty())
            return total;
        else {
            for (String[] aux : list) {
                float price = Float.parseFloat(aux[1]);
                total += price;
            }
        }
            return total;
        }

     public void setCartDone(String username){
        User user = new User();
        CartAccess cartAccess = new CartAccess();
        cartAccess.finishCart(user);
     }

    public void deleteCart(String username){
        User user = new User();
        CartAccess cartAccess = new CartAccess();
        cartAccess.deleteCart(user);
    }

    public void updateQuantity(String dealName){
        Deal d = new Deal();
        d.setDealName(dealName);
        DealAccess dealAccess = new DealAccess();
        dealAccess.updateQuantity(d);
    }
}


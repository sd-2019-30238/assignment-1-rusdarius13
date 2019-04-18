package controller;

import DAO.DealAccess;
import controller.Factory.Discount;
import model.Deal;

public abstract class DiscountY implements Discount {

    public void addDiscount(String dealName, Integer discount){
        Deal d = new Deal();
        d.setDealName(dealName);
        DealAccess dealAccess = new DealAccess();
        d.setProductDiscount(discount);
        dealAccess.applyDiscount(d);
        String priceS = dealAccess.getPrice(d);
        float priceF = Float.parseFloat(priceS);
        float newPrice = priceF-(priceF*(discount/100));
        priceS = newPrice+"";
        d.setDealPrice(priceS);
        dealAccess.updatePrice(d);
    }

    public void checkDiscount(String dealName){
        Deal d = new Deal();
        DealAccess dealAccess = new DealAccess();
        d.setDealName(dealName);
        int discount = dealAccess.getDiscount(d);
        int discount2 = 100 - discount;
        String priceS = dealAccess.getPrice(d);
        float priceF = Float.parseFloat(priceS);

        if(discount>0){
            float old = (priceF/100)/discount2;
            priceS = old+"";
            d.setDealPrice(priceS);
            dealAccess.updatePrice(d);
            d.setProductDiscount(0);
            dealAccess.applyDiscount(d);
        }
    }
}

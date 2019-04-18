package controller.Factory;

import DAO.CartAccess;
import DAO.DealAccess;
import model.Deal;

public class Discount10 implements Discount{

	public void applyDiscount(String dealName){
		Deal d = new Deal();
		DealAccess dealAccess = new DealAccess();
		CartAccess cartAccess = new CartAccess();
		d.setDealName(dealName);
		String priceS = dealAccess.getPrice(d);
		float priceF = Float.parseFloat(priceS);
		int discount = 10;
		float newPrice = priceF-((discount/100)*priceF);
		priceS = newPrice + "";
		d.setDealPrice(priceS);
		cartAccess.updatePrice(d);
		
	}
}

package controller.Factory;

public class DiscountMain {
    public static Discount getDiscount(String type){
        switch(type){
            case"10%":
                return new Discount10();
            case"15%":
                return new Discount15();
            case"20%":
                return new Discount20();
            default:
                return null;
        }
    }
}

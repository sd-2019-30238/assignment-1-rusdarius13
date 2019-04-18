package model;

public class Deal {
    private int dealId;
    private int productDiscount;
    private int quantity;
    private String dealName;
    private String dealType;
    private String dealPrice;

    public Deal(String dealName, int quantity, int productDiscount, String dealType, String dealPrice) {
        this.dealName = dealName;
        this.quantity = quantity;
        this.productDiscount = productDiscount;
        this.dealType = dealType;
        this.dealPrice = dealPrice;
    }

    public Deal() {

    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }
}

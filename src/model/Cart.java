package model;

public class Cart {
    private int productDiscount;
    private int idCart;
    private int quantity;
    private int status;
    private String userName;
    private String productName;
    private float productPrice;

    public Cart(String userName, String productName, float productPrice, int quantity, int productDiscount, int status) {
        this.userName = userName;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productDiscount = productDiscount;
        this.status = status;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) { this.productDiscount = productDiscount; }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

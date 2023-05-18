package dsProduct;

public class Product {
    private String name;
    private String price;
    private String quan;
    private  String mta;

    public Product(String name, String price, String quan, String mta) {
        this.name = name;
        this.price = price;
        this.quan = quan;
        this.mta = mta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quan;
    }

    public void setQuantity(String quantity) {
        this.quan = quantity;
    }

    public String getMta() {
        return mta;
    }

    public void setMta(String mta) {
        this.mta = mta;
    }
    public String toString(){
        return name +"-"+ price + "-" +quan + "-"+mta;
    }
}

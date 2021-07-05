package product;

public class Product {
    private static int id = 1;
    private String nameProduct;
    private long priceProduct;
    private int quantity;

    public Product(){

    }

    public Product(String nameProduct, long priceProduct, int quantity) {
        id++;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantity = quantity;
    }


    public int getId(){
        return  id;
    }

    public String getNameProduct(){
        return nameProduct;
    }

    public void setNameProduct(String nameProduct){
        this.nameProduct = nameProduct;
    }

    public long getPriceProduct(){
        return priceProduct;
    }

    public void setPriceProduct(long priceProduct){
        this.priceProduct = priceProduct;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id +
                "nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", quantity=" + quantity +
                '}';
    }
}

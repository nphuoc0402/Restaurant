package product;

public class OrderProduct {
    private Product product;

    public OrderProduct(){
        product = null;
    }

    public OrderProduct(Product product) {
        this.product = product;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

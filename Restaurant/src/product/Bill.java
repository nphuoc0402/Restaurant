package product;

import java.util.Date;
import java.util.List;

public class Bill {
    private int idBill;
    private Date date;
    private Customer customer;

    public Bill(){

    }

    public Bill(int idBill, Customer customer) {
        this.idBill = idBill;
        this.customer = customer;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Date getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int calTotalPrice(){
        int total = 0;
        List<OrderProduct> list = customer.getOrder().orderProductList();
        for (int i = 0; i < list.size(); i++){
            total += list.get(i).getProduct().getPriceProduct()*(list.get(i).getProduct().getQuantity());
        }
        return total;
        
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}

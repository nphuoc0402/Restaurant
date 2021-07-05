package product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private static int idOder = 0;

    private  List <OrderProduct> orderProductList = new ArrayList<>();

    public Order(){
        idOder++;
    }

    public Order(int id_Oder) {
        this.idOder = id_Oder;
    }

    public int getIdOder() {
        return idOder;
    }

    public void setIdOder(int idOder){
        this.idOder = idOder;
    }

    public List<OrderProduct> orderProductList() {

        return orderProductList;

    }

    public void setOrderProductList(List<OrderProduct> orderProductList){
        this.orderProductList = orderProductList;
    }

    public void addOrder(OrderProduct orderProduct){
        orderProductList.add(orderProduct);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOder=" + idOder + "Product= " + orderProductList +
                '}';
    }
}

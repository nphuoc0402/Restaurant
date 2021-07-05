package product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {
    private static int idCustomer = 1;
    private Order order;
    private String nameCustomer;

    public Customer(){
        idCustomer++;
        this.order = new Order(idCustomer);
    }

    public Customer(int idCustomer, String nameCustomer, Order oder) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.order = new Order(idCustomer);
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void input(){
        try{
            Scanner input = new Scanner(System.in);
            System.out.printf("Enter the name of Customer:\n");
            setNameCustomer(input.nextLine());
        }catch (InputMismatchException e){
            System.out.printf("Invalid Value!");
        }

    }

    public void makeOrderproduct(Product product){
        OrderProduct orderProduct = new OrderProduct(product);
        order.addOrder(orderProduct);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", oder=" + order +
                '}';
    }
}

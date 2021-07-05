package control;
import product.*;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private String nameRestaurant;
    private String address;
    private String tel;
    private static final int MAX_NUMBER_OF_TABLES = 20;

    List<Customer> customerList = new ArrayList<Customer>();
    List<Table> tables = new ArrayList<Table>(MAX_NUMBER_OF_TABLES);
    List<Bill> bills;
    List<Product> productList = new ArrayList<Product>();


    public Restaurant() {
        for (int i = 0; i < MAX_NUMBER_OF_TABLES; i++) {
            Table t = new Table();
            tables.add(t);

        }
    }

    public List<Table> getTables(){
        return tables;
    }

    public boolean isAnyTableOccupied(){
        for(int i = 0; i < MAX_NUMBER_OF_TABLES; i++){
            if (tables.get(i).isOccupied() == true){
                return true;
            }
        }
        return false;
    }

    private int findTheEmptyTable(){

        for(int i = 0; i < MAX_NUMBER_OF_TABLES; i++){
            if(tables.get(i).isOccupied() == false){
                return i;
            }
        }
        return -1;
    }

    public void displayOccupiedTable(){
        for (int i = 0; i <MAX_NUMBER_OF_TABLES; i++){
            if(tables.get(i).isOccupied() == true){
                System.out.println("Table No. " + i + " is occupied");
            }
        }
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Customer getCustomer(int id){
        return customerList.get(id);
    }

    public static void readCsvFile() {
        {
            String line = "";
            String splitBy = ",";
            try
            {
                //parsing a CSV file into BufferedReader class constructor
                BufferedReader br = new BufferedReader(new FileReader("src\\product\\ListProduct.csv"));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] product = line.split(splitBy);// use comma as separator

                    System.out.println(product[0] + "," + product[1] + "," + product[2]);
                }
            }
            catch (IOException e)
            {
                e.getMessage();
            }
        }

    }

    public void WriteFile(){
        productList.add(new Product("Tra Sua",35000,20));
        productList.add(new Product("Cafe",15000,15));
        productList.add(new Product("Tra Chanh",10000,30));
        productList.add(new Product("Sua chua da",22000,14));
        productList.add(new Product("Nuoc ep dau",32000,19));
        productList.add(new Product("Sinh to bo",28000,22));
        productList.add(new Product("Ca cao da",20000,8));
        productList.add(new Product("Sinh to lua mach",45000,50));
        for(int i = 0; i < productList.size(); i++){
            System.out.print(productList.get(i));
        }
        File infile = new File("F:\\JAVA\\Module2\\Week1\\Restaurant\\src\\product\\ListProduct.csv");
        try {
                FileWriter fw = new FileWriter(infile);
                fw.append("id");
                fw.append(",");
                fw.append("name_product");
                fw.append(",");
                fw.append("price");
                fw.append(",");
                fw.append("quantity");
                fw.append("\n");
                for (int i = 0; i <  productList.size(); i++){
                    fw.write(productList.get(i).getId() - productList.size() + i  +
                            "," + productList.get(i).getNameProduct() +
                            "," +productList.get(i).getPriceProduct() + " VND "+
                            "," + productList.get(i).getQuantity() + "\n");
                }
                System.out.println("Successful");
                fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bookTable(){
            Scanner input = new Scanner(System.in);
            int numTable = 1;
            Customer customer = new Customer();
            customer.input();
            customerList.add(customer);
            customer.setIdCustomer(numTable);
            customer.getOrder().setIdOder(numTable);
            customerList.add(numTable,customer);
            tables.get(numTable).bookATable();
            //            readCsvFile();
            customer.setIdCustomer(numTable);
            showProduct();
            String nameProduct;
            System.out.printf("What would you like to drink:\n");
            nameProduct = new Scanner(System.in).nextLine();
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getNameProduct().equals(nameProduct)) {
                    customer.makeOrderproduct(productList.get(i));
                    System.out.printf("Hello\n");
                    break;
                } else {
                    System.out.printf("Product is not available! Please choose another Product");
                    break;
                }
            }
//            readCsvFile();

        for(int i = 0; i < customerList.size(); i++){
            System.out.print(customerList.get(i).getNameCustomer() + customerList.get(i).getOrder() + "\n");
        }

    }


    public void showProduct(){
        readCsvFile();
    }

    public void edit(){
        System.out.printf("Enter the ID Customer:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        for (int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getIdCustomer() == id){
               customerList.get(i).setOrder(new Order(id));
            }
        }
    }

    public void Payment(){
        int id = 0;
        Customer customer = getCustomer(id);
    }

    public void ShowInvoice(int id){
        Customer customer = getCustomer(id);
        Bill bill = new Bill(id,customer);
        bills.add(bill);
        System.out.printf("Total: %d",bill.calTotalPrice());
    }



    public void printBill(){
        File bill = new File("src\\product\\Bill.csv");

    }

    public void History(){

    }

    public void Revenue(){

    }

    public void menu(){
        System.out.printf("==========MENU==========\n");
        System.out.printf("Table: Open - Occupied\n");
        System.out.printf("1. BookTable\n");
        System.out.printf("2. Show Product\n");
        System.out.printf("3. Edit\n");
        System.out.printf("4. Payment\n");
        System.out.printf("5. Show Invoice\n");
        System.out.printf("6. History\n");
        System.out.printf("7. Revenue\n");
        System.out.printf("8. Exit!\n");
        System.out.printf("=======================\n");
        System.out.printf("Enter the choose:\n");
    }

    public void run(int choice){
        try{
            switch(choice){
                case 1:
                    bookTable();
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                case 2:
                    showProduct();
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                case 3:
                    edit();
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                case 4:
                    Payment();
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                case 5:
                    int id = 0;
                    System.out.printf("Customer name:\n");
                    String nameCustomer = new Scanner(System.in).nextLine();
                    for (int i = 0 ; i < customerList.size(); i++){
                        if (customerList.get(i).getNameCustomer().equals(nameCustomer)){
                            id = customerList.get(i).getIdCustomer();
                        }else{
                            System.out.printf("Invalid Name:");
                            break;
                        }
                    }
                    ShowInvoice(id);
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                case 6:
                    History();
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                case 7:
                    Revenue();
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Invalid Value. Please try again!\n");
                    System.out.println("Enter the choose to continue:");
                    System.out.println("===============================");
                    break;
                }
            }catch (InputMismatchException e){
                System.out.printf("Invalid Value");
            }
        }

}

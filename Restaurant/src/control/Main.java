package control;

import control.Restaurant;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        restaurant.setNameRestaurant("Teacher 3");
        restaurant.setAddress("HCM");
        restaurant.setTel("0933594115");
//        for(int i = 0; i < restaurant.productList.size(); i++){
//            System.out.println(restaurant.productList.get(i));
//        }
//        Restaurant.readCsvFile();1
        int choice;
        System.out.printf("Welcome to %s Restaurant!\n",restaurant.getNameRestaurant());
        do{
            restaurant.menu();
            choice = input.nextInt();
            restaurant.run(choice);

        }while(choice != 8);
    }
}

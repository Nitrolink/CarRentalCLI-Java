package com.foundry;

import java.util.ArrayList;

public class Customer {
    public static ArrayList<Car> cart = new ArrayList<>();




    public static void carReturn(Car car){
        car.rent(1);
        cart.remove(car);
        Company.inventory.add(car);
    }


    public static void carRent(Car car,int days) {
        car.rent(days);
        cart.add(car);
        Company.inventory.remove(car);
        System.out.println("==========================================================================================================\nIt will cost $" + (days * car.price) + " to rent the " + car.company + " " + car.name + " for " + days + " days." );
    }

    public static void printCart() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ": " + cart.get(i));
        }
    }
}

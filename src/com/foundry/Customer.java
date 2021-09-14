package com.foundry;

import java.util.ArrayList;

public class Customer {

    public ArrayList<Car> cart;
    public String firstName;
    public String id;
    public int balance;

    public Customer(String firstName,String id,int balance,ArrayList<Car> cars){
        this.firstName = firstName;
        this.id = id;
        this.balance = balance;
        cart = cars;
    }

    @Override
    public String toString(){
        return id + ": " + firstName +  " $" + balance;
    }

    public static void carReturn(Car car){
        car.rent(1);
        Cli.customer.cart.remove(car);
        Company.inventory.add(car);
    }


    public static void carRent(Car car,int days) {
        car.rent(days);
        Cli.customer.cart.add(car);
        Company.inventory.remove(car);
        System.out.println("==========================================================================================================\nIt will cost $" + (days * car.price) + " to rent the " + car.company + " " + car.name + " for " + days + " days." );
    }

    public static void printCart() {
        for (int i = 0; i < Cli.customer.cart.size(); i++) {
            System.out.println((i + 1) + ": " + Cli.customer.cart.get(i));
        }
    }
}

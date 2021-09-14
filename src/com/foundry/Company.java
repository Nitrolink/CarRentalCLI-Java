package com.foundry;

import java.util.ArrayList;

public class Company {
    public static ArrayList<Car> inventory = new ArrayList<>();
    public static ArrayList<Customer> accounts = new ArrayList<>();



    public static void customerInit(String firstName, String id, int balance,ArrayList<String[]> cars) {
        ArrayList<Car> list = new ArrayList<>();
        for (String[] car : cars) {
            list.add(new Car(car[0],car[1],Integer.parseInt(car[2])));
        }

        accounts.add(new Customer(firstName, id, balance,list));
    }
    public static String customerDeInit(Customer customer) {

        StringBuilder cars = new StringBuilder();
        for (Car car: customer.cart) {
           cars.append(car.company).append("-").append(car.name).append("-").append(car.price).append(",");
        }
        return (customer.firstName + "," + customer.id + "," + customer.balance + "," + cars);
    }

    public static void printAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ": " + accounts.get(i));
        }
    }

    public static void carInit(String company, String name, int price) {
        inventory.add(new Car(company, name, price));
    }

    public static String carDeInit(Car car){
        return (car.company + "," + car.name + "," + car.price);
    }

    public static void printInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ": " + inventory.get(i));
        }
    }

}


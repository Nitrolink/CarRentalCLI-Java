package com.foundry;

import java.util.ArrayList;

public class Company {
    public static ArrayList<Car> inventory = new ArrayList<>();

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


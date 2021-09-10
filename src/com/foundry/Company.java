package com.foundry;

import java.util.ArrayList;

public class Company {
    public static ArrayList<Car> inventory = new ArrayList<Car>();

    public static void tempInit() {
        inventory.add(new Car("Camaro 2SS", "Chevy", 150));
        inventory.add(new Car("Mustang GT", "Ford", 190));
        inventory.add(new Car("Hellcat", "Dodge", 100));
        inventory.add(new Car("CRV", "Honda", 50));
        inventory.add(new Car("Wrangler", "Jeep", 130));
        inventory.add(new Car("Test", "Company", 1));
    }

    public static void printInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ": " + inventory.get(i));
        }
    }

}


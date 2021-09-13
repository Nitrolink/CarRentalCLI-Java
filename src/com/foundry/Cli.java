package com.foundry;

import java.util.Scanner;


public class Cli {

    public static int userInput(){
        Scanner myObj = new Scanner(System.in);
        return myObj.nextInt();
    }


    public static void mainMenu(){
        System.out.println("==========================================================================================================\nWelcome to Foundry Car Rental, input the number of the menu you would like to go to\n1: Rent a Car\n2: Return a Car\n3: Current Cart\n4: Check Out\n5: Exit Program");


        switch (userInput()) {
            case 1 -> buyMenu();
            case 2 -> returnMenu();
            case 3 -> {
                System.out.println("==========================================================================================================\nYour Current Cart:");
                Customer.printCart();
                mainMenu();
            }
            case 4 -> checkOutMenu();
            case 5 -> Main.exit();
        }

    }

    public static void buyMenu(){
        System.out.println("==========================================================================================================\nWhich Car would you like to rent?");
        Company.printInventory();
        int answer = userInput();
        if (answer <= Company.inventory.size() && answer > 0) {
            System.out.println("==========================================================================================================\nHow many days would you like to rent?");
            int days = userInput();
            Customer.carRent(Company.inventory.get(answer - 1), days);
        }
        mainMenu();



    }

    public static void returnMenu(){
        if(Customer.cart.size() == 0){
            mainMenu();
        }
        else{
            System.out.println("==========================================================================================================\nWhich Car would you like to return?");
            Customer.printCart();
            int answer = userInput();
            if (answer <= Customer.cart.size() && answer > 0) {
                Customer.carReturn(Customer.cart.get(answer - 1));
            }
            mainMenu();
        }

    }

    public static void checkOutMenu(){
        System.out.println("==========================================================================================================\nYour Current Cart:");
        Customer.printCart();
        int totalCost = 0;
        for (int i = 0; i < Customer.cart.size(); i++) {
            Car curCar = Customer.cart.get(i);
            totalCost += (curCar.price * curCar.days);
        }
        System.out.println("==========================================================================================================\nIt will cost you $" + totalCost + " To rent the car(s)");
        Main.exit();
    }
}

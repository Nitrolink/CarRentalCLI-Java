package com.foundry;

//Test

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Cli {
    public static Customer customer;
    public static int userInput(){
        Scanner myObj = new Scanner(System.in);
        return myObj.nextInt();
    }


    public static void login(){

        System.out.println("==========================================================================================================\nWelcome to Foundry Car Rental, please enter your id to log in");
        Scanner myObj = new Scanner(System.in);
        String answer = myObj.nextLine();

        if(Objects.equals(answer, "0000")){
            System.out.println("==========================================================================================================\nWelcome back Admin");
            mainMenu(true);
        }
        for (Customer account : Company.accounts) {
            if(Objects.equals(answer, account.id)){
                System.out.println("==========================================================================================================\nHello " + account.firstName + "!");
                customer = account;
                mainMenu(false);
            }
        }
    }


    public static void mainMenu(Boolean admin){
        if(!admin){
            System.out.println("==========================================================================================================\nInput the number of the menu you would like to go to\n1: Rent a Car\n2: Return a Car\n3: Current Cart\n4: Check Out\n5: Exit Program");
            switch (userInput()) {
                case 1 -> {
                    buyMenu();
                    mainMenu(false);
                }
                case 2 -> {
                    if(customer.cart.size() > 0) {
                        returnMenu();
                    }
                    mainMenu(false);
                }
                case 3 -> {
                    System.out.println("==========================================================================================================\nYour Current Cart:");
                    customer.printCart();
                    mainMenu(false);
                }
                case 4 -> {
                    if(customer.cart.size() > 0) {
                        checkOutMenu();
                    }
                    mainMenu(false);
                }
                case 5 -> Main.exit();
            }
        }
        else{
            System.out.println("==========================================================================================================\nInput the number of the menu you would like to go to\n1: Rent a Car\n2: Return a Car\n3: Current Cart\n4: Check Out\n5: Edit Listings\n6: Exit Program");
            switch (userInput()) {
                case 1 -> {
                    buyMenu();
                    mainMenu(true);
                }
                case 2 -> {
                    if(customer.cart.size() > 0) {
                        returnMenu();
                    }
                    mainMenu(true);
                }
                case 3 -> {
                    System.out.println("==========================================================================================================\nYour Current Cart:");
                    customer.printCart();
                    mainMenu(true);
                }
                case 4 -> {
                    if(customer.cart.size() > 0) {
                        checkOutMenu();
                    }
                    mainMenu(true);
                }
                case 5 -> {
                    adminMenu();
                    mainMenu(true);
                }
                case 6 -> Main.exit();

            }
        }

    }

    public static void adminMenu(){
        System.out.println("==========================================================================================================\nWhich Database would you like to alter?\n1: Car Inventory\n2: Customer Accounts\n3: Main Menu");
        switch(userInput())
            {
                case 1 -> {
                    System.out.println("==========================================================================================================\nWhat would you like to do?\n1: Add a Car\n2: Remove a Car\n3: Edit a Car\n4: Main Menu");
                    switch(userInput()){
                        case 1 -> {
                            Scanner myObj = new Scanner(System.in);
                            System.out.println("==========================================================================================================\nEnter the Manufacturing Company");
                            String company = myObj.nextLine();
                            System.out.println("==========================================================================================================\nEnter the Name");
                            String name = myObj.nextLine();
                            System.out.println("==========================================================================================================\nEnter the Price");
                            int price = myObj.nextInt();
                            Company.inventory.add(new Car(company,name,price,0));
                            mainMenu(true);
                        }
                        case 2 -> {
                            System.out.println("==========================================================================================================\nEnter the number of the Car you wish to remove");
                            Company.printInventory();
                            Company.inventory.remove(userInput() - 1);
                            mainMenu(true);
                        }
                        case 3 -> {
                            System.out.println("==========================================================================================================\nEnter the number of the Car you wish to edit");
                            Company.printInventory();
                            Car selected = Company.inventory.get(userInput() - 1);
                            System.out.println("==========================================================================================================\nWhich Value Would you like to Edit\n1: Company\n2: Name\n3: Price");
                            int answer = userInput();
                            System.out.println("==========================================================================================================\nCurrent Value: ");
                            switch (answer) {
                                case 1 -> {
                                    System.out.println(selected.company);
                                    System.out.println("==========================================================================================================\nNew Value: ");
                                    Scanner myObj = new Scanner(System.in);
                                    selected.company = myObj.nextLine();
                                    mainMenu(true);
                                }
                                case 2 -> {
                                    System.out.println(selected.name);
                                    System.out.println("==========================================================================================================\nNew Value: ");
                                    Scanner myObj = new Scanner(System.in);
                                    selected.name = myObj.nextLine();
                                    mainMenu(true);
                                }
                                case 3 -> {
                                    System.out.println(selected.price);
                                    System.out.println("==========================================================================================================\nNew Value: ");
                                    selected.price = userInput();
                                    mainMenu(true);
                                }

                            }
                            mainMenu(true);
                        }
                    }
                    mainMenu(true);

                }
                case 2 -> {
                    System.out.println("==========================================================================================================\nWhat would you like to do?\n1: Add an Account\n2: Remove an Account\n3: Edit an Account\n4: Main Menu");
                    switch(userInput()){
                        case 1 -> {
                            Scanner myObj = new Scanner(System.in);
                            System.out.println("==========================================================================================================\nEnter the First Name");
                            String firstName = myObj.nextLine();
                            System.out.println("==========================================================================================================\nEnter the ID");
                            String id = myObj.nextLine();
                            System.out.println("==========================================================================================================\nEnter the Account Balance");
                            int balance = myObj.nextInt();
                            Company.accounts.add(new Customer(firstName,id,balance, new ArrayList<>()));
                            mainMenu(true);
                        }
                        case 2 -> {
                            System.out.println("==========================================================================================================\nEnter the number of the Account you wish to remove");
                            Company.printAccounts();
                            Company.accounts.remove(userInput() - 1);
                            mainMenu(true);
                        }
                        case 3 -> {
                            System.out.println("==========================================================================================================\nEnter the number of the Account you wish to edit");
                            Company.printInventory();
                            Customer selected = Company.accounts.get(userInput() - 1);
                            System.out.println("==========================================================================================================\nWhich Value Would you like to Edit\n1: Name\n2: Id\n3: Balance");
                            int answer = userInput();
                            System.out.println("==========================================================================================================\nCurrent Value: ");
                            switch (answer) {
                                case 1 -> {
                                    System.out.println(selected.firstName);
                                    System.out.println("==========================================================================================================\nNew Value: ");
                                    Scanner myObj = new Scanner(System.in);
                                    selected.firstName = myObj.nextLine();
                                    mainMenu(true);
                                }
                                case 2 -> {
                                    System.out.println(selected.id);
                                    System.out.println("==========================================================================================================\nNew Value: ");
                                    Scanner myObj = new Scanner(System.in);
                                    selected.id = myObj.nextLine();
                                    mainMenu(true);
                                }
                                case 3 -> {
                                    System.out.println(selected.balance);
                                    System.out.println("==========================================================================================================\nNew Value: ");
                                    selected.balance = userInput();
                                    mainMenu(true);
                                }

                            }
                            mainMenu(true);
                        }
                    }

                }
            }
            mainMenu(true);
    }



    public static void buyMenu(){
        System.out.println("==========================================================================================================\nWhich Car would you like to rent?");
        Company.printInventory();
        int answer = userInput();
        if (answer <= Company.inventory.size() && answer > 0) {
            System.out.println("==========================================================================================================\nHow many days would you like to rent?");
            int days = userInput();
            customer.carRent(Company.inventory.get(answer - 1), days);
        }
    }

    public static void returnMenu(){
            System.out.println("==========================================================================================================\nWhich Car would you like to return?");
            customer.printCart();
            int answer = userInput();
            if (answer <= customer.cart.size() && answer > 0) {
                customer.carReturn(customer.cart.get(answer - 1));
            }
    }

    public static void checkOutMenu(){
        System.out.println("==========================================================================================================\nYour Current Cart:");
        customer.printCart();
        int totalCost = 0;
        for (int i = 0; i < customer.cart.size(); i++) {
            Car curCar = customer.cart.get(i);
            totalCost += (curCar.price * curCar.days);
        }
        System.out.println("==========================================================================================================\nYour Current Balance: ");
        System.out.println("$" +customer.balance);
        System.out.println("==========================================================================================================\nIt will cost you $" + totalCost + " To rent the car(s), Would you like to Continue with the purchase? (Y/N)");
        Scanner myObj = new Scanner(System.in);
        String answer = myObj.nextLine();
        if(Objects.equals(answer, "y") || Objects.equals(answer, "Y")){
            if(customer.balance >= totalCost){
                customer.balance -= totalCost;
                System.out.println("==========================================================================================================\nYour new Balance: ");
                System.out.println("$" + customer.balance);
                Main.exit();
            }
            else{
                System.out.println("==========================================================================================================\nInsufficient Funds");
                for (Car car:customer.cart) {
                    customer.carReturn(car);
                }
            }
        }

    }
}

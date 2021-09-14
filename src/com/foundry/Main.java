package com.foundry;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static String customerData = "src/Data/CustomerDatabase.txt";
    public static String carData = "src/Data/CarDatabase.txt";

    public static void exit(){
        ArrayList<String> carWrite = new ArrayList<>();
        ArrayList<String> customerWrite = new ArrayList<>();
        for (Car cars:Company.inventory) {
            carWrite.add(Company.carDeInit(cars));
        }
        writeFile(carData,carWrite);
        for(Customer customers: Company.accounts){
            customerWrite.add(Company.customerDeInit(customers));
        }
        writeFile(customerData,customerWrite);

        System.exit(0);
    }



    public static void writeFile(String fileName,ArrayList<String> list){

        try {
            File file = new File(fileName);
            FileWriter fileReader = new FileWriter(file); // A stream that connects to the text file
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // Connect the FileWriter to the BufferedWriter

            for (String s : list) {
                bufferedWriter.write(s + "\n");
            }

            bufferedWriter.close (); // Close the stream
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName,ArrayList<String[]> storage){
        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] newLine = line.split(",");

                storage.add(newLine);
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<String[]> carRead = new ArrayList<>();
        ArrayList<String[]> customerRead = new ArrayList<>();
        readFile(carData,carRead);
        readFile(customerData, customerRead);
        for(String[] cars: carRead) {
            Company.carInit(cars[0],cars[1],Integer.parseInt(cars[2]));
        }

        for (String[] customer: customerRead){
            ArrayList<String[]> carList = new ArrayList<>();
            if(customer.length > 3){
                for (int i = 3; i < customer.length; i++) {
                    carList.add( customer[i].split("-"));
                }
            }

            Company.customerInit(customer[0],customer[1],Integer.parseInt(customer[2]),carList);
        }

        Company.printAccounts();
        Cli.login();
    }
}

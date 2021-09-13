package com.foundry;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String[]> carRead = new ArrayList<>();
    public static String carData = "src/Data/CarDatabase.txt";

    public static void exit(){
        ArrayList<String> carWrite = new ArrayList<>();
        for (Car cars:Company.inventory) {
            carWrite.add(Company.carDeInit(cars));
        }
        writeFile(carData,carWrite);
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

    public static void readFile(String fileName){
        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i = 0;
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] newLine = line.split(",");

                carRead.add(newLine);
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile(carData);
        for (String[] cars: carRead) {
            Company.carInit(cars[0],cars[1],Integer.parseInt(cars[2]));
        }
        Cli.mainMenu();
    }
}

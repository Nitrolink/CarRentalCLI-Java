package com.foundry;

public class Car {
    public String name;
    public String company;
    public int price;
    public int days;

    public Car(String name,String company,int price){
        this.name = name;
        this.company = company;
        this.price = price;
        this.days = 1;
    }


    @Override
    public String toString(){
        return company + " " + name + ", Cost: " + price*days;
    }

    public void rent(int days){
        this.days = days;
    }


}

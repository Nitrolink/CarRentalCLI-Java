package com.foundry;

public class Car {
    public String name;
    public String company;
    public int price;
    public int days;

    public Car(String company,String name,int price,int days){
        this.name = name;
        this.company = company;
        this.price = price;
        this.days = days;
    }


    @Override
    public String toString(){
        return company + " " + name + ", Cost: " + price;
    }

    public void rent(int days){
        this.days = days;
    }


}

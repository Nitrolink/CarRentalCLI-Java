package com.foundry;

public class Car {
    public String name;
    public String company;
    public int price;
    public int days;

    @Override
    public String toString(){
        return company + " " + name + " Costs: " + price;
    }

    public void rent(int days){
        this.days = days;
    }


}

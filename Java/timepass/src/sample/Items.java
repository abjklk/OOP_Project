package sample;

import java.util.Random;
import java.util.Scanner;


class Items{
    public String name;
    public String type;
    public String description;
    public float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    Items(){
        name = "";
        type = "";
        description = "";
        price =0;
    }

    Items(String name, String type, String description, float price){
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public void displayItems(){
    }

    public void readItems(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        this.name = sc.nextLine();
        System.out.println("Item Types: \n1 -> Actuators.\n2 -> Microcontrollers.\n3 -> Sensors.\nEnter your Item Type: ");
        this.type = sc.nextLine();
        System.out.println("Enter The description of the Item: ");
        this.description = sc.next();
        System.out.println("Enter the price: ");
        this.price = sc.nextFloat();
        sc.close();
    }
}
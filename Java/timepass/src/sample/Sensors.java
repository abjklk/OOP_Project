package sample;

import java.util.Scanner;

class Sensors extends Items{
    Sensors(){
        super();
        this.type = "Sensor";
    }
    Sensors(String name, String type, String description, float price){
        super(name,type,description,price);
    }

    public void displayItems(){
        System.out.println("Item Name: "+ name);
        System.out.println("Item Category: Sensor");
        System.out.println("Item Price: "+ price);
        System.out.println("Item Description: "+ description);
    }
//    public void editSensors(){
//        int ch;
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            System.out.println("Edit Name? 1 - Yes 2 - No");
//            ch = sc.nextInt();
//            if(ch == 1 || ch ==2){
//                if(ch == 1){
//                    System.out.println("Enter New Name");
//                    this.name = sc.nextLine();
//                }
//                else
//                    break;
//            }
//            else
//                System.out.println("Invalid Input");
//        }
//        while(true){
//            System.out.println("Edit ID? 1 - Yes 2 - No");
//            ch = sc.nextInt();
//            if(ch == 1 || ch ==2){
//                if(ch == 1){
//                    System.out.println("Enter New ID");
//                    this.id = sc.nextLine();
//                }
//                else
//                    break;
//            }
//            else
//                System.out.println("Invalid Input");
//        }
//        while(true){
//            System.out.println("Edit Type? 1 - Yes 2 - No");
//            ch = sc.nextInt();
//            if(ch == 1 || ch ==2){
//                if(ch == 1){
//                    System.out.println("Enter New Type");
//                    this.type = sc.nextInt();
//                }
//                else
//                    break;
//            }
//            else
//                System.out.println("Invalid Input");
//        }
//        while(true){
//            System.out.println("Edit Price? 1 - Yes 2 - No");
//            ch = sc.nextInt();
//            if(ch == 1 || ch ==2){
//                if(ch == 1){
//                    System.out.println("Enter New Price");
//                    this.price = sc.nextFloat();
//                }
//                else
//                    break;
//            }
//            else
//                System.out.println("Invalid Input");
//        }
//        while(true){
//            System.out.println("Edit Description? 1 - Yes 2 - No");
//            ch = sc.nextInt();
//            if(ch == 1 || ch ==2){
//                if(ch == 1){
//                    System.out.println("Enter New Description");
//                    this.description = sc.nextLine();
//                }
//                else
//                    break;
//            }
//            else
//                System.out.println("Invalid Input");
//        }
//        System.out.println("Item Details Edited Successfully.");
//    }



}

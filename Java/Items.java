import java.util.*;

class Items{
	public String name;
	public String ID;
	public int type;
	public String description;	
	public float price;

	Items(){
		name = "";
		ID = "";
		type = 0;
		description = "";
		price =0;
	}
	Items(String name, String ID, int type, String description, float price){
		this.name = name;
		this.ID = ID;
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
		System.out.println("Enter ID: ");
		this.ID = sc.nextLine();
		System.out.println("Item Types: \n1 -> Actuators.\n2 -> Microcontrollers.\n3 -> Sensors.\nEnter your Item Type: ");
		this.type = sc.nextInt();
		System.out.println("Enter The description of the Item: ");
		this.description = sc.next();
		System.out.println("Enter the price: ");
		this.price = sc.nextFloat();
		sc.close();
	}
}

class Actuators extends Items{

	public Actuators(){
		super();
	}
	
	public Actuators(String name, String ID, int type, String description, float price){
		super(name,ID,type,description,price);
	}

	public void displayItems(){
		System.out.println("-------------");
		System.out.println("Item Name: "+ name);
        System.out.println("Item ID: "+ ID);
        System.out.println("Category: Actuators");
        System.out.println("Price: "+ price);
        System.out.println("Description Of The Product: " + description);
		System.out.println("-------------");
	}

}
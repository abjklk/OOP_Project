package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private String name;
    private String usn;
    private int sem;
    private String branch;
    private String address;
    private long pno;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    private List<Items> items;

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPno() {
        return pno;
    }

    public void setPno(long pno) {
        this.pno = pno;
    }

    public User(){
        name = "";
        usn = "";
        sem = 0;
        branch = "";
        address = "";
        pno = 0;
        items = new ArrayList<Items>();
        password="";
    }

    public User(String name, String usn, int sem, String branch, String address, long pno,String password) {
        this.name = name;
        this.usn = usn;
        this.sem = sem;
        this.branch = branch;
        this.address = address;
        this.pno = pno;
        this.password=password;
        items = new ArrayList<Items>();
    }

    public void readUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME");
        System.out.println("Enter Name: ");
        setName(sc.nextLine());
        System.out.println("Enter USN: ");
        setUsn(sc.nextLine());
        while(true){
            System.out.println("Enter Semester: ");
            int x = sc.nextInt();
            if(x >=1 && x <= 8){
                setSem(x);
                break;
            }
            System.out.println("Invalid Output");
        }

        System.out.println("Enter Branch1 -> Computer Science. " +
                    "2 -> Electronics And Communication. 3 -> Mechanical Engineering. 4 -> Automation And Robotics. 5 -> Biotechnology.\nEnter Your choice: ");
        String x = sc.nextLine();
        setBranch(x);

        System.out.println("Enter Phone no.");
        setPno(sc.nextInt());
        System.out.println("Enter Address");
        setAddress(sc.next());
    }

    public void displayUser(){
        boolean flag = false;
        System.out.println("Name: "+getName());
        System.out.println("USN: "+getUsn());
        System.out.println("Branch: "+getBranch());
        System.out.println("Semester: "+getSem());
        System.out.println("Address: "+getAddress());
        System.out.println("Phone number: "+getPno());

        for(int i=0; i<6; i++){
            if(items.get(i) != null){
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("User doesn't have any items.");
        }
    }


}
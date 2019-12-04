package sample;

class Admin
{
    // static variable single_instance of type Singleton
    private static Admin single_instance = null;

    // variable of type String
    public String name;
    public String pass;

    // private constructor restricted to this class itself
    private Admin()
    {
        name = "admin";
        pass = "admin123";
    }

    // static method to create instance of Singleton class
    public static Admin getInstance()
    {
        if (single_instance == null)
            single_instance = new Admin();

        return single_instance;
    }
}
//public class Admin {
//    public String name;
//    public String pno;
//    public int sem;
//    public String projects;
//    public String address;
//    public String dob;
//    public String clg;
//    public String interests;
//
//    public Admin() {
//        name = "";
//        pno = "";
//        sem = 0;
//        projects = "";
//        address = "";
//        dob = "";
//        clg = "";
//        interests = "";
//    }
//
//    public Admin(String name, String pno, int sem, String projects, String address, String dob, String clg, String interests) {
//        this.name = name;
//        this.pno = pno;
//        this.sem = sem;
//        this.projects = projects;
//        this.address = address;
//        this.dob = dob;
//        this.clg = clg;
//        this.interests = interests;
//    }
//    public void displayAdmin(){
//        System.out.println("KLE TECH e-Mart");
//        System.out.println("---------------");
//        System.out.println("Name: "+name);
//        System.out.println("College Name: "+clg);
//        System.out.println("Date of Birth: "+dob);
//        System.out.println("Semester"+sem);
//        System.out.println("Interests: "+interests);
//        System.out.println("Worked on: "+projects);
//        System.out.println("---------------");
//    }
//}

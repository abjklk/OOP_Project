package sample;

public class MyException extends Exception {
    public int errnum;
    public String errmsg;

    public MyException(){
        errnum = 0;
        errmsg = "";
    }

    public MyException(int errnum,String errmsg) {
        this.errnum = errnum;
        this.errmsg = errmsg;
    }
    public void displayException(){
        System.out.println("Error Code: "+ errnum);
        System.out.println("Error Message: "+errmsg);
    }

}

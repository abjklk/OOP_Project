package sample;

public class Card {
    public String name;
    public long cardno;
    public long pno;
    public int cvv;
    public float balance;
    public int type;

    Card(){
        name = "";
        cardno = 0;
        pno = 0;
        cvv = 0;
        balance = 0;
    }

    public Card(String name, long cardno, long pno, int cvv, float balance) {
        this.name = name;
        this.cardno = cardno;
        this.pno = pno;
        this.cvv = cvv;
        this.balance = balance;
    }

    void displayCard(){}
}

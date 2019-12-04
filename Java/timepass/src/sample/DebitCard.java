package sample;

public class DebitCard implements ICard {
    String name;
    long cardNo;
    long pno;
    int cvv;
    float balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public long getPno() {
        return pno;
    }

    public void setPno(long pno) {
        this.pno = pno;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public DebitCard(String name, long cardNo, long pno, int cvv, float balance) {
        this.name=name;
        this.cardNo=cardNo;
        this.pno=pno;
        this.cvv=cvv;
        this.balance=balance;
    }

    @Override
    public void buy(float price) {
        System.out.println(this.getBalance()-price);
    }
}

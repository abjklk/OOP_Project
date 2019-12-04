package sample;

import com.mongodb.*;

import java.net.UnknownHostException;

public class CreditCard implements ICard {
//    public CreditCard() {
//        super();
//        type = 1;
//    }
    String name;
    long cardNo;
    long pno;
    int cvv;
    float balance;

    public CreditCard(String name, long cardNo, long pno, int cvv, float balance) {
        this.name=name;
        this.cardNo=cardNo;
        this.pno=pno;
        this.cvv=cvv;
        this.balance=balance;
    }

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


    @Override
    public void buy(float price){
        System.out.println(this.getBalance()-price);
    }

    public static void main(String[] args) throws UnknownHostException {
        ICard card = new CreditCard("PQR",7868,847174746,990,84210);
        ICard dCard = new DebitCard("MNO",6392,836636711,420,1803719);

        DBObject c1 = createDBObject(card);
        DBObject c2 = createDBObject(dCard);

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("cards");
        col.insert(c1);
        col.insert(c2);

//        card.buy(120);
//        dCard.buy(221);
    }
    private static DBObject createDBObject(ICard card) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("name", card.getName());
        docBuilder.append("cardno", card.getCardNo());
        docBuilder.append("pno", card.getPno());
        docBuilder.append("cvv", card.getCvv());
        docBuilder.append("balance", card.getBalance());
        return docBuilder.get();
    }


}

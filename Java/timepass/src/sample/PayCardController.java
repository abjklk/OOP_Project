package sample;

import com.mongodb.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PayCardController {

    public TextField name;
    public TextField cno;
    public TextField cvv;
    public Button submit;
    public Label status;
    ICard card;
    private User user;
    private float billAmt;

    public void submit(ActionEvent event) throws IOException, ParseException {

        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "10.1.2.175" , 27017 );
        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("cards");
        DBObject query = BasicDBObjectBuilder.start().add("name", name.getText()).get();
        DBCursor cursor = col.find(query);

        if(cursor.hasNext()) {
            Object obj = new JSONParser().parse(cursor.next().toString());
            JSONObject j = (JSONObject) obj;
            if (j.get("cardno").toString().equals(cno.getText())) {
                if (j.get("cvv").toString().equals(cvv.getText())) {
                    Double bal = (Double)j.get("balance");
                    if (bal.floatValue() - billAmt > 500) {
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Checkout.fxml"));
                        Parent itemView = loader.load();
                        Scene itemScene = new Scene(itemView);
                        CheckoutController controller = loader.getController();
                        controller.initData(user);
                        window.setScene(itemScene);
                        window.show();
                    } else {
                        status.setText("Insufficient Balance");
                    }
                } else {
                    status.setText("Invalid CVV");
                }
            } else {
                status.setText("Invalid Card Number");
            }
        }else{
            status.setText("No card found");
        }
    }
    void initData(User user){
        this.user = user;
        Double amt = 0.0;
        for(Items i : user.getItems())
            amt+=i.getPrice();
        this.billAmt=amt.floatValue();
    }

    public void close(MouseEvent mouseEvent) {
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.close();
    }
}

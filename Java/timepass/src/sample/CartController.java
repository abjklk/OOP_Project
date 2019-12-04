package sample;

import com.mongodb.*;
import com.mongodb.util.JSON;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class CartController {
    public ListView cartList;
    public User user;
    public Label bill;
    public Button checkOutBtn;
    public RadioButton debitbtn;
    public RadioButton creditbtn;

    public void initData(User user) throws UnknownHostException, ParseException {
        this.user = user;

        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("users");
        DBObject query = BasicDBObjectBuilder.start().add("usn",user.getUsn()).get();
        DBCursor cursor = col.find(query);

        Object x = new JSONParser().parse(cursor.next().toString());
        JSONObject j = (JSONObject) x;
        JSONArray arr = (JSONArray) j.get("items");
        if(arr!=null) {
            for (Object o : arr) {
                JSONObject item = (JSONObject) o;

                Items i = new Items(
                        (String) item.get("name"),
                        (String) item.get("type"),
                        (String) item.get("description"),
                        ((Double) item.get("price")).floatValue()
                );
                add(i, (String) item.get("seller"));
            }
        }
        else{
            checkOutBtn.setDisable(true);
        }

    }

    public void add(Items x,String s) {

        ImageView imageView = new ImageView();
        imageView.setFitHeight(91.0);
        imageView.setFitWidth(102.0);
        imageView.setLayoutX(7.0);
        imageView.setLayoutY(11.0);
        imageView.setPreserveRatio(true);
        imageView.setPreserveRatio(true);

        Label title = new Label();
        title.setText(x.getName());
        title.setLayoutX(110.0);
        title.setLayoutY(14.0);
        title.setPrefHeight(26.0);
        title.setPrefWidth(431.0);

        Label desc = new Label();
        desc.setText(x.getDescription());
        desc.setLayoutX(109.0);
        desc.setLayoutY(35.0);
        desc.setPrefHeight(58.0);
        desc.setPrefWidth(313.0);

        Label price = new Label();
        price.setText(x.getPrice() + "");
        price.setLayoutX(440.0);
        price.setLayoutY(44.0);
        price.setPrefHeight(40.0);
        price.setPrefWidth(102.0);

        Button remove = new Button();
        remove.setText("Remove Item");
        remove.setOnAction(a->
        {
            try {
                clear(x,s);
            } catch (UnknownHostException | ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        remove.setLayoutX(367.0);
        remove.setLayoutY(93.0);
        remove.setMnemonicParsing(false);


        Pane itemPane = new Pane(imageView, title, desc, price, remove);
        itemPane.setPrefHeight(123.0);
        itemPane.setPrefWidth(555.0);
        cartList.getItems().add(itemPane);

    }

    private void clear(Items x,String s) throws IOException, ParseException {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB("me");
        DBCollection itemsCol = db.getCollection("items");
        DBCollection usersCol = db.getCollection("users");
        DBObject query = BasicDBObjectBuilder.start().add("usn",user.getUsn()).get();
        DBCursor cursor = usersCol.find(query);

        Object obj = new JSONParser().parse(cursor.next().toString());
        JSONObject j = (JSONObject) obj;
        JSONArray arr = (JSONArray) j.get("items");

        DBObject doc = createDBObject(x,s);
        DBObject d = BasicDBObjectBuilder.start().add("items",doc).get();
        BasicDBObject temp = new BasicDBObject();
        temp.put("$pull",d);
        usersCol.update(query,temp);
        itemsCol.insert(doc);

        Iterator gg = user.getItems().iterator();
        while(gg.hasNext()){
            Items h = (Items)gg.next();
            if(h.getName().equals(x.getName())){
                gg.remove();
            }
        }

        Stage window = (Stage)(cartList.getScene().getWindow());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Cart.fxml"));
        Parent cartView = loader.load();
        Scene cartScene = new Scene(cartView);
        CartController controller = loader.getController();
        controller.initData(user);
        window.setTitle("Add Items");
        window.setScene(cartScene);
        window.show();
    }


    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    private static DBObject createDBObject(Items item,String s) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("name", item.getName());
        docBuilder.append("type", item.getType());
        docBuilder.append("description", item.getDescription());
        docBuilder.append("price", item.getPrice());
        docBuilder.append("seller",s);
        return docBuilder.get();
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Items.fxml"));
        Parent itemView = loader.load();
        Scene itemScene = new Scene(itemView);
        ItemsController controller = loader.getController();
        controller.initData(user);
        window.setScene(itemScene);
        window.show();
    }

    public void checkOut(ActionEvent event) throws IOException, ParseException {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB("me");
        DBCollection usersCol = db.getCollection("users");
        DBObject query = BasicDBObjectBuilder.start().add("usn",user.getUsn()).get();
        DBCursor cursor = usersCol.find(query);

        Object obj = new JSONParser().parse(cursor.next().toString());
        JSONObject j = (JSONObject) obj;
        JSONArray arr = (JSONArray) j.get("items");

        BasicDBObject temp = new BasicDBObject();
        temp.put("$unset",new BasicDBObject("items",j.get("items")));
        usersCol.update(query,temp);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PayCard.fxml"));
        Parent itemView = loader.load();
        Scene itemScene = new Scene(itemView);
        PayCardController controller = loader.getController();
        controller.initData(user);
        window.setScene(itemScene);
        window.show();

    }

    public void payDebit(ActionEvent event) {
        creditbtn.setSelected(false);
        debitbtn.setSelected(true);

    }


    public void payCredit(ActionEvent event) {
        debitbtn.setSelected(false);
        creditbtn.setSelected(true);

    }
}


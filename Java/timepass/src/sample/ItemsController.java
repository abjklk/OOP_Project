package sample;

import com.mongodb.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.kordamp.ikonli.javafx.FontIcon;

public class ItemsController implements Initializable{

    public ListView listView;
    public User user;
    public String type;
    public MenuButton menu;
    public SplitMenuButton profile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("items");
        DBObject query = BasicDBObjectBuilder.start().get();
        DBCursor cursor = col.find(query);

        while(cursor.hasNext()){
            Object x = null;
            try {
                x = new JSONParser().parse(cursor.next().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject j = (JSONObject) x;

            String d = (String) j.get("seller");
            Items item = new Items(
                    (String) j.get("name"),
                    (String) j.get("type"),
                    (String) j.get("description"),
                    ((Double) j.get("price")).floatValue()
            );
            add(item,d);

        }

    }

    public void add(Items x,String se) {

        FontIcon cartIcon = new FontIcon("fa-cart-plus");
        FontIcon phoneIcon = new FontIcon("fa-phone");
        FontIcon inrIcon = new FontIcon("fa-rupee");

        FileInputStream input = null;
        try {
            if(x.getType().equals("Micro-controller"))
                input = new FileInputStream("resources/images/x.jpg");
            else if(x.getType().equals("Actuator"))
                input = new FileInputStream("resources/images/actuator.jpg");
            else
                input = new FileInputStream("resources/images/sensor.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(91.0);
        imageView.setFitWidth(102.0);
        imageView.setLayoutX(7.0);
        imageView.setLayoutY(11.0);
        imageView.setPreserveRatio(true);
        imageView.setPreserveRatio(true);

        Label title = new Label();
        title.setFont(Font.font("Arial",FontWeight.BOLD,16.0));

        title.setText(x.getName());
        title.setLayoutX(110.0);
        title.setLayoutY(14.0);
        title.setPrefHeight(26.0);
        title.setPrefWidth(431.0);

        Label desc = new Label();
        desc.setText("Description: "+x.getDescription());
        desc.setLayoutX(109.0);
        desc.setLayoutY(35.0);
        desc.setPrefHeight(58.0);
        desc.setPrefWidth(313.0);

        Label i = new Label("",inrIcon);
        i.setLayoutX(450.0);
        i.setLayoutY(56.0);

        Label price = new Label();
        price.setFont(Font.font(16.0));
        price.setText(x.getPrice()+"");
        price.setLayoutX(460.0);
        price.setLayoutY(44.0);
        price.setPrefHeight(40.0);
        price.setPrefWidth(102.0);


        Button buy = new Button();
        buy.setGraphic(cartIcon);
        buy.setText("Buy");
        buy.setOnAction(a-> {
            try {
                buy(x,buy,se);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        });
        buy.setLayoutX(337.0);
        buy.setLayoutY(93.0);
        buy.setMnemonicParsing(false);

        Label contact = new Label("Contact: "+se,phoneIcon);
        contact.setLayoutX(460.0);
        contact.setLayoutY(97.0);

        Pane itemPane = new Pane(imageView,title,desc,i,price,buy,contact);
        itemPane.setPrefHeight(123.0);
        itemPane.setPrefWidth(555.0);
        listView.getItems().add(itemPane);

    }

    private void buy(Items x,Button b,String z) throws IOException, ParseException {
        if((this.user.getPno()+"").equals(z)){
            b.setText("You are the Owner");
        }
        else {
            List<Items> itemArray = user.getItems();
            itemArray.add(x);
            this.user.setItems(itemArray);
            b.setText("Added to Cart.");
            MongoClient mongo = new MongoClient( "localhost" , 27017 );
            DB db = mongo.getDB("me");
            DBCollection col = db.getCollection("items");
            DBObject query = BasicDBObjectBuilder.start().append("name",x.getName()).append("description",x.getDescription()).get();
            WriteResult result = col.remove(query);

            DBObject doc = createDBObject(x,z);
            DBCollection userCol = db.getCollection("users");
            query = BasicDBObjectBuilder.start().add("usn",user.getUsn()).get();

            BasicDBObject temp = new BasicDBObject();
            temp.put("$push",new BasicDBObject("items",doc));
            userCol.update(query,temp);
        }
        b.setDisable(true);
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


    public void goBack(MouseEvent actionEvent) throws IOException {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent itemView = loader.load();
        Scene itemScene = new Scene(itemView);
        MenuController controller = loader.getController();
        controller.initData(user);
        window.setTitle("Add Items");
        window.setScene(itemScene);
        window.show();
    }



    public void listMicrocontrollers(ActionEvent event) throws UnknownHostException, ParseException {
        listView.getItems().clear();
        menu.setText("Microcontrollers");
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("items");
        DBObject query = BasicDBObjectBuilder.start().add("type", "Micro-controller").get();
        DBCursor cursor = col.find(query);
        while (cursor.hasNext()) {
            Object x = new JSONParser().parse(cursor.next().toString());
            JSONObject j = (JSONObject) x;

            String d = (String) j.get("seller");
            Items l = new Items(
                    (String) j.get("name"),
                    (String)j.get("type"),
                    (String)j.get("description"),
                    ((Double)j.get("price")).floatValue()
            );
            add(l,d);
        }
    }

    public void listActuators(ActionEvent event) throws UnknownHostException, ParseException {
        listView.getItems().clear();
        menu.setText("Actuators");
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("items");
        DBObject query = BasicDBObjectBuilder.start().add("type", "Actuator").get();
        DBCursor cursor = col.find(query);
        while (cursor.hasNext()) {
            Object x = new JSONParser().parse(cursor.next().toString());
            JSONObject j = (JSONObject) x;

            String d = (String) j.get("seller");
            Items l = new Items(
                    (String) j.get("name"),
                    (String)j.get("type"),
                    (String)j.get("description"),
                    ((Double)j.get("price")).floatValue()
            );
            add(l,d);
        }
    }

    public void listSensors(ActionEvent event) throws UnknownHostException, ParseException {
        listView.getItems().clear();
        menu.setText("Sensors");
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("items");
        DBObject query = BasicDBObjectBuilder.start().add("type", "Sensor").get();
        DBCursor cursor = col.find(query);
        while (cursor.hasNext()) {
            Object x = new JSONParser().parse(cursor.next().toString());
            JSONObject j = (JSONObject) x;

            String d = (String) j.get("seller");
            Items l = new Items(
                    (String) j.get("name"),
                    (String)j.get("type"),
                    (String)j.get("description"),
                    ((Double)j.get("price")).floatValue()
            );
            add(l, d);
        }
    }


    void initData(User user){
        this.user = user;
        profile.setText(user.getUsn().toUpperCase());
    }

    public void viewCart(ActionEvent event) throws IOException, ParseException {
        Stage window = (Stage)(listView.getScene().getWindow());
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

    public void signOut(ActionEvent event) throws IOException {
        Parent loginView = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage window = (Stage)(listView.getScene().getWindow());
        window.setScene(new Scene(loginView, 600, 400));
        window.show();
    }
    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    public void goProfile(ActionEvent event) throws IOException {
        Stage window = (Stage)(listView.getScene().getWindow());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Profile.fxml"));
        Parent cartView = loader.load();
        Scene cartScene = new Scene(cartView);
        ProfileController controller = loader.getController();
        controller.initData(user);
        window.setScene(cartScene);
        window.show();
    }
}
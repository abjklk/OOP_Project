package sample;

import com.mongodb.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class AddItemController implements Initializable {
    public User user;
    @FXML
    public TextField name;
    public TextField description;
    public TextField price;
    public ChoiceBox type;
    public Label status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.getItems().add("Actuator");
        type.getItems().add("Micro-controller");
        type.getItems().add("Sensor");
    }

    public void addItem() throws UnknownHostException {

        //inheritance used here
        Items x;
        if(type.getValue().toString().equals("Sensor"))
           x = new Sensors();
        else if(type.getValue().toString().equals("Actuator"))
            x = new Actuators();
        else
            x = new Microcontrollers();
        x.setName(name.getText());
        x.setDescription(description.getText());

        try {
            x.setPrice(Float.parseFloat(price.getText()));
            DBObject doc = createDBObject(x,user.getPno()+"");
            // Creating a Mongo client
            MongoClient mongo = new MongoClient( "localhost" , 27017 );
            DB db = mongo.getDB("me");
            DBCollection col = db.getCollection("items");

            col.insert(doc);
            status.setText("Item Placed Successfully!");
        }
        catch (Exception e){
            status.setText("Incorrect Price Format!");
        }


    }

    private static DBObject createDBObject(Items item,String u) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("name", item.getName());
        docBuilder.append("type", item.getType());
        docBuilder.append("description", item.getDescription());
        docBuilder.append("price", item.getPrice());
        docBuilder.append("seller",u);
        return docBuilder.get();
    }

    public void initData(User user){
        this.user = user;
    }

    public void goBack(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent itemView = loader.load();
        Scene itemScene = new Scene(itemView);
        MenuController controller = loader.getController();
        controller.initData(user);
        window.setTitle("Buy Items");
        window.setScene(itemScene);
        window.show();
    }
    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
}

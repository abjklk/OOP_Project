package sample;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
    public ListView users;
    public ListView items;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB db = mongo.getDB("me");

        DBCollection col = db.getCollection("users");
        DBCollection itemsCol = db.getCollection("items");
        DBCursor cur = col.find();
        DBCursor cur1 = itemsCol.find();
        while(cur.hasNext()){
            Object x = null;
            try {
                x = new JSONParser().parse(cur.next().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject j = (JSONObject) x;
            String name = (String) j.get("name");
            String usn = (String) j.get("usn");

            users.getItems().add(name+"\t"+usn);
        }
        while(cur1.hasNext()){
            Object x = null;
            try {
                x = new JSONParser().parse(cur1.next().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject j = (JSONObject) x;
            String item = (String) j.get("name");
            String type = (String) j.get("type");

            items.getItems().add(item+"\t"+type);
        }



    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        Parent signUpView = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(signUpView, 600, 400));
        window.show();
    }

    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
}

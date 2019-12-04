package sample;

import com.mongodb.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.UnknownHostException;

public class LoginController {

    @FXML
    public TextField usn;
    public Label profile;
    public Label loginStatus;
    @FXML
    private PasswordField password;
    User user;

    public void login(ActionEvent actionEvent) throws IOException, ParseException {
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB("me");
        DBCollection col = db.getCollection("users");
        if(!usn.getText().equals("")) {
            DBObject query = BasicDBObjectBuilder.start().add("usn", usn.getText()).get();
            DBCursor cursor = col.find(query);
            if (cursor.hasNext()) {
                Object x = new JSONParser().parse(cursor.next().toString());
                JSONObject j = (JSONObject) x;
                String pass = (String) j.get("password");
                if(!password.getText().equals("")) {
                    if (password.getText().equals(pass)) {
                        User user = createObj(j);
//                      Parent loginview = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Menu.fxml"));
                        Parent menuView = loader.load();
                        Scene menuScene = new Scene(menuView);
                        MenuController controller = loader.getController();
                        controller.initData(user);
                        window.setTitle("Items");
//                        set scene to stage
                        window.setScene(menuScene);
                        window.show();
                    }else {
                        loginStatus.setText("Invalid Password");
                        password.clear();
                    }
                }else{
                    loginStatus.setText("Enter Password!");
                }
            } else {
                loginStatus.setText("No User Found!");
                usn.clear();
                password.clear();
            }
        }
        else{
            loginStatus.setText("Enter USN");
            password.clear();
        }

    }

    public void signUp(MouseEvent mouseEvent) throws IOException {
        //create fxml parent
        Parent signUpView = FXMLLoader.load(getClass().getResource("NewUser.fxml"));
        //get stage
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");
        //set scene to stage
        window.setScene(new Scene(signUpView, 600, 400));
        window.show();
    }
    private static User createObj(JSONObject j){
        User user = new User(
                j.get("name").toString(),
                j.get("usn").toString(),
                Integer.parseInt(j.get("sem").toString()),
                j.get("branch").toString(),
                j.get("address").toString(),
                Long.parseLong(j.get("pno").toString()),
                j.get("password").toString()
        );
        return user;
    }
    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
}

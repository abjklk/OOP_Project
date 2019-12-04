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

public class NewUserController implements Initializable {
    @FXML
    public TextField name;
    public TextField address;
    public TextField usn;
    public TextField sem;
    public ChoiceBox branch;
    public TextField pno;
    public Label status;
    @FXML
    private TextField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        branch.getItems().add("School of Computer Science & Engineering");
        branch.getItems().add("School of Mechanical Engineering");
        branch.getItems().add("School of Electronics & Communication Engineering");
        branch.getItems().add("School of Civil Engineering");
        branch.getItems().add("School of Automation & Robotics Engineering");
        branch.getItems().add("School of Biotechnology");
    }

    public void onClick() throws UnknownHostException {

//        System.out.println(name.getText());
//        System.out.println(usn.getText());
//        System.out.println(Integer.parseInt(sem.getText()));
//        System.out.println(branch.getText());
//        System.out.println(address.getText());
//        System.out.println(Integer.parseInt(pno.getText()));
        User user  = new User();
        user.setName(name.getText());
        user.setAddress(address.getText());
        user.setUsn(usn.getText());
        user.setSem(Integer.parseInt(sem.getText()));
        user.setBranch(branch.getValue().toString());
        user.setPno(Integer.parseInt(pno.getText()));
        user.setPassword(password.getText());

        DBObject doc = createDBObject(user);
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB("me");
        DBCollection userCol = db.getCollection("users");
        WriteResult result = userCol.insert(doc);
        status.setText("User added Successfully.");
        clearFields();
    }

    private static DBObject createDBObject(User x) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("name", x.getName());
        docBuilder.append("usn", x.getUsn());
        docBuilder.append("sem", x.getSem());
        docBuilder.append("branch", x.getBranch());
        docBuilder.append("address", x.getAddress());
        docBuilder.append("pno", x.getPno());
        docBuilder.append("password",x.getPassword());
        return docBuilder.get();
    }
    private void clearFields(){
        name.clear();
        address.clear();
        usn.clear();
        sem.clear();
        pno.clear();
        password.clear();
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        Parent loginView = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setTitle("Welcome");
        window.setScene(new Scene(loginView, 600, 400));
        window.show();
    }
    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
}

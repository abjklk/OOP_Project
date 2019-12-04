package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    public TextField usn;
    public Button hellobtn;
    public PasswordField pass;
    public Label loginStatus;

    @FXML
    public void Login(ActionEvent event) throws IOException {
        if(usn.getText().equals("Akshay") && pass.getText().equals("aksh@123")) {
            loginStatus.setText("Login Success");
            //create fxml parent
            Parent loginview = FXMLLoader.load(getClass().getResource("adminview.fxml"));
            //get stage

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("login success");
            //set scene to stage
            window.setScene(new Scene(loginview, 600, 400));
            window.show();
        }
        else
            loginStatus.setText("Wrong Password.Try Again.");
    }

    public void goBack(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("login");
        window.setScene(new Scene(home, 600, 400));
        window.show();


    }
}

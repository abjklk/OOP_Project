package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {


    public void login(ActionEvent actionEvent) throws IOException {
        //create fxml parent
        Parent loginView = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //get stage
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("login page");
        //set scene to stage
        window.setScene(new Scene(loginView, 600, 400));
        window.show();
    }
    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    public void signUp(ActionEvent actionEvent) throws IOException {
        //create fxml parent
        Parent signUpView = FXMLLoader.load(getClass().getResource("NewUser.fxml"));
        //get stage
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle("login page");
        //set scene to stage
        window.setScene(new Scene(signUpView, 600, 400));
        window.show();
    }
}

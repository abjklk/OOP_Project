package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    public ImageView logo;
    public ImageView logo1;

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

    public void about(MouseEvent mouseEvent) throws IOException {
        Parent aboutView = FXMLLoader.load(getClass().getResource("About.fxml"));
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(aboutView, 600, 400));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("resources/images/logo.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        logo.setImage(i);

        try {
            input = new FileInputStream("resources/images/emart.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        i = new Image(input);
        logo1.setImage(i);

    }
}

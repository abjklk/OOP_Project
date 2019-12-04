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

public class AboutController implements Initializable {
    public ImageView img;

    public void goBack(MouseEvent event) throws IOException {
        Parent homeView = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(homeView, 600, 400));
        window.show();
    }

    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("resources/images/sign.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image i = new Image(input);
        img.setImage(i);
    }
}

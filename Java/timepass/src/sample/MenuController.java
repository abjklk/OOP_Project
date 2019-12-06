package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private User user;
    public Label profile;

    public void onClick(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Items.fxml"));
        Parent itemView = loader.load();
        Scene itemScene = new Scene(itemView);
        ItemsController controller = loader.getController();
        controller.initData(user);
        window.setTitle("Buy Items");
        window.setScene(itemScene);
        window.show();
    }



    public void addItem(ActionEvent actionEvent) throws IOException {

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddItem.fxml"));
        Parent itemView = loader.load();
        Scene itemScene = new Scene(itemView);
        AddItemController controller = loader.getController();
        controller.initData(user);
        window.setTitle("Add Items");
        window.setScene(itemScene);
        window.show();
    }

    void initData(User user){
        this.user = user;
//        profile.setText(user.getUsn());
    }

    public void signOut(ActionEvent event) throws IOException {
        Parent loginView = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Welcome page");
        window.setScene(new Scene(loginView, 600, 400));
        window.show();
    }
    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
}

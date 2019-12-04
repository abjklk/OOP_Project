package sample;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.UnknownHostException;

public class ProfileController {

    public User user;
    public Label name;
    public Label usn;
    public Label sem;
    public Label address;
    public Label pno;
    public ImageView img;

    void initData(User user) throws IOException {
        this.user = user;

        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB("imgDb");
        DBCollection imgCol = db.getCollection("images");
        GridFS gfsPhoto = new GridFS(db, "photo");
        GridFSDBFile imageOp = gfsPhoto.findOne(user.getUsn());
        try {
            Image i = new Image(imageOp.getInputStream());
            img.setImage(i);
        }catch (Exception e){}
        name.setText(user.getName());
        usn.setText(user.getUsn().toUpperCase());
        sem.setText(user.getSem()+"");
        address.setText(user.getAddress());
        pno.setText(user.getPno()+"");
    }

    public void close(MouseEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    public void goBack(MouseEvent actionEvent) throws IOException {
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Items.fxml"));
        Parent itemView = loader.load();
        Scene itemScene = new Scene(itemView);
        ItemsController controller = loader.getController();
        controller.initData(user);
        window.setScene(itemScene);
        window.show();
    }
}



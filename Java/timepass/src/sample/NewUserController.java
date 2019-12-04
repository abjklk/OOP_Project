package sample;

import com.mongodb.*;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
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
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
    private File imageFile = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        branch.getItems().add("School of Computer Science & Engineering");
        branch.getItems().add("School of Mechanical Engineering");
        branch.getItems().add("School of Electronics & Communication Engineering");
        branch.getItems().add("School of Civil Engineering");
        branch.getItems().add("School of Automation & Robotics Engineering");
        branch.getItems().add("School of Biotechnology");
    }

    public void upload() throws IOException {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            imageFile = jfc.getSelectedFile();
        }
    }

    public void onClick() throws IOException {

        User user  = new User();
        try {
            user.setName(name.getText());
            user.setAddress(address.getText());
            user.setUsn(usn.getText());
            user.setSem(Integer.parseInt(sem.getText()));
            user.setBranch(branch.getValue().toString());
            user.setPno(Integer.parseInt(pno.getText()));
            user.setPassword(password.getText());

            DBObject doc = createDBObject(user);
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("me");
            DBCollection userCol = db.getCollection("users");
            WriteResult result = userCol.insert(doc);

            //Add images to db using GridFS
            DB imgDb = mongo.getDB("imgDb");
            DBCollection imgCol = db.getCollection("images");
            String newFileName = usn.getText();
            GridFS gfsPhoto = new GridFS(imgDb, "photo");
            GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
            gfsFile.setFilename(newFileName);
            gfsFile.save();
            status.setText("User added Successfully.");
            clearFields();
        }catch (Exception e){
            status.setText("Error");
        }
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

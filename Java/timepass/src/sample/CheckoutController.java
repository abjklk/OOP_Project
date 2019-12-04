package sample;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CheckoutController {
    public Label billAddress;
    public Label price;
    public User user;
    public Label title;
    public Label subtitle;

    void initData(User user){
        this.user = user;
        Double amt = 0.0;
            for(Items i : user.getItems())
                amt+=i.getPrice();
            billAddress.setText(user.getName()+"\n"+user.getAddress());
            price.setText("Payable Amount: "+amt);
        }

    public void close(MouseEvent mouseEvent) {
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.close();
    }
}

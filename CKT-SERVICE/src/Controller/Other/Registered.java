package Controller.Other;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Registered {

    public void Close(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent2 = load(getClass().getResource("/View/Other/Registered.fxml"));
        Scene tableViewScene2 = new Scene(tableViewParent2);
        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window2.setScene(tableViewScene2);
        window2.close();
    }
}

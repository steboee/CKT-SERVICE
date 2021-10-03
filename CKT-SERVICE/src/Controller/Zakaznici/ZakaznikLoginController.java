package Controller.Zakaznici;

import Model.Customer.LoggedUser;
import Model.Customer.Zakaznik;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ZakaznikLoginController implements Initializable {

    public LoggedUser logged;

    public static String username;
    public static String password;

    @FXML
    private Label Vitaj;

    private static String meno;
    private static String priezvisko;


    public void setlabel(LoggedUser l) throws FileNotFoundException {
        logged = l;
        meno = l.getname();
        priezvisko = l.getsurname();
        username = l.getUsername();

        //meno = CustomerGetName(Zakaznik.getUsername());
        //priezvisko = CustomerGetSurname(Zakaznik.getUsername());
    }


    public void VytvorObjednavku(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Zakaznik/ObjednavkaView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS_Objednavka");
        window.setScene(tableViewScene);
        window.show();
    }


    public void BackToMenu(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Other/MainView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.setScene(tableViewScene);
        Zakaznik za = new Zakaznik(username,password);
        za.showlogout(username);
        window.show();
    }

    public void VyhladajObjednavku(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Zakaznik/VyhladajObjednavkuView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS_Vyhladavanie");
        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Vitaj.setText("Vitaj "+meno+" "+priezvisko);
    }


}

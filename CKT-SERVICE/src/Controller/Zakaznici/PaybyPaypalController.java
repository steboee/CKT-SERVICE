package Controller.Zakaznici;

import Model.Objednavka_atd.Faktura;
import Strategies.SRATEGY.PayByPayPal;
import Strategies.SRATEGY.PayPalaccount;
import Strategies.SRATEGY.PayStrategy;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class PaybyPaypalController {
    public PayStrategy strategy;
    public static Faktura f;



    public static void nastav(Faktura faktura) {
        f = faktura;
    }


    @FXML
    TextField email;

    @FXML
    TextField heslo;

    @FXML
    TextField kontr_cislo;





    public void Back(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.close();
    }


    public void Back(javafx.event.ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.close();
    }

    public void Pay(javafx.event.ActionEvent actionEvent) throws IOException {
        PayPalaccount account = new PayPalaccount(email.getText(),heslo.getText(),kontr_cislo.getText());
        strategy = new PayByPayPal();
        strategy.collectPaymentDetails(account);
        strategy.pay(f.getCena(),f);
        Back(actionEvent);
    }
}

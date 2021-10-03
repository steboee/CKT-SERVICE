package Controller.Zakaznici;

import Model.Objednavka_atd.Faktura;
import Strategies.SRATEGY.CreditCard;
import Strategies.SRATEGY.PayByCard;
import Strategies.SRATEGY.PayStrategy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaybyCardController implements Initializable {
    public PayStrategy strategy;
    public static Faktura f;






    public static void Nacitaj_fakturu(Faktura faktura){
        f = faktura;
    }


    @FXML
    public TextField cvv;
    @FXML
    private TextField cardnumber;
    @FXML
    private TextField expiration;

    String verific;
    String NUMBER;
    String EXP;



    void refresh_ver(String a) {
        verific = a;
    }
    void refresh_num(String a){
        NUMBER = a;
    }
    void refresh_exp(String a){
        EXP = a;
    }
    @FXML








    public void initialize(URL url, ResourceBundle resourceBundle) {
        cvv.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(oldValue + "   " + newValue);
            refresh_ver(newValue);

        });
        cardnumber.textProperty().addListener((observable, oldValue, newValue)->{
            refresh_num(newValue);
        });
        expiration.textProperty().addListener((observable,oldValue,newValue)->{
            refresh_exp(newValue);
        });
        if (EXP != null & verific != null & NUMBER != null){
            //collect();
        }
    }



    public void Back(javafx.event.ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.close();
    }

    public void collect(javafx.event.ActionEvent actionEvent) throws IOException {
        strategy = new PayByCard();
        CreditCard karta = new CreditCard();
        karta.setCvv(verific);
        karta.setDate(EXP);
        karta.setNumber(NUMBER);

        strategy.collectPaymentDetails(karta);
        strategy.pay(f.getCena(),this.f);
        Back(actionEvent);

    }
}

package Controller.Zakaznici;

import Model.Customer.LoggedUser;
import Model.Builder.Director;
import Model.Objednavka_atd.Objednavka;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Model.Objednavka_atd.Auto.*;
import static Model.Objednavka_atd.Objednavka.generate_index;
import static Model.Objednavka_atd.Objednavka.save_data;
import static System.AlertObjednavka.Alert;

public class ObjednavkaViewController implements Initializable {


    @FXML
    private ChoiceBox<String> znacka;
    @FXML
    private ChoiceBox<String> palivo;
    @FXML
    private ChoiceBox<String> motor;
    @FXML
    private TextField stropcena;
    @FXML
    private TextField text_meno;
    @FXML
    private TextField text_priezvisko;
    @FXML
    private Label upozornenie;
    @FXML
    private Label ID;
    @FXML
    private CheckBox startstop;
    @FXML
    private CheckBox mapy;


    String Meno;
    String Priezvisko;
    boolean ststop;
    boolean maps;
    String Mapyyes;
    int velkost = count_cars();


    public  void loadDataZnacka() {   //vloží do choiceboxov údaje z databázy
        startstop.selectedProperty().addListener((obs, ov, Startstopyes) -> {
            ststop = Startstopyes;
        });
        mapy.selectedProperty().addListener((obs, ov ,mapyyes) -> {
            maps = mapyyes;
        });

        DatabaseOfCars();
        ObservableList list_znacka = FXCollections.observableArrayList();
        ObservableList list_motor = FXCollections.observableArrayList();
        for(int i =0 ;i<velkost;i++){
            if (list_znacka.contains(znackaGet(i))){
                continue;
            }
            list_znacka.add(znackaGet(i));
        }

        znacka.getItems().addAll(list_znacka);
        znacka.getValue();
        znacka.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    list_motor.add(1);
                });

        palivo.getItems().addAll("Diesel","Benzin");
    }


    public void PalivoChanged(){    // zmena paliva -- > musia sa zmeniť typy motorov v CHOICEBOXE
        ObservableList list_motor = FXCollections.observableArrayList();
        ObservableList list_palivo = FXCollections.observableArrayList();
        String pal = palivo.getValue();         // palivo ktoré je v selectnuté v choiceboxe
        String znac = znacka.getValue();        // znacka auta ktorá je selectnuta
        motor.getItems().clear();


        for(int i =0 ;i<velkost;i++) {          // prechádza zoznamom aut
            String palivog = palivoGet(i);      // palivá aut v zozname
            String znackag = znackaGet(i);      // znacky aut v zozname
            if (palivog.equals(pal) && znackag.equals(znac)) {      // Ak také to auto je v zozname aut
                if (list_motor.contains(motorGet(i))) {             // uz je v liste
                    continue;
                } else {
                    list_motor.add(motorGet(i));                    //pridaj motor do listu
                    list_palivo.add(palivoGet(i));                  // pridaj palivo do listu
                }
            }
        }

        motor.getItems().addAll(list_motor);
    }


    public void Buttonclicked(ActionEvent event) throws IOException // Navrat do menu
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Zakaznik/ZakaznikLoginView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.setScene(tableViewScene);
        window.show();
    }

    public int VytvoritObjednavku() throws IOException {
        String Name = text_meno.getText();          // získa udaje z GUI
        String Surname = text_priezvisko.getText();
        String Znacka = znacka.getValue();
        String Palivo = palivo.getValue();
        String Motor = motor.getValue();
        String Strop_cena = stropcena.getText();
        if(Alert(Name,Surname,Znacka,Motor,Strop_cena,upozornenie)==1){        // ak su vsetky udaje v poriadku -->
            int x = generate_index();   // generácia nahodného ID
            Objednavka.ObjednavkaBuilder objednavka = new Objednavka.ObjednavkaBuilder(x);
            Director dir = new Director();
            Objednavka o = dir.constructObjednavka(objednavka,Name,Surname,Znacka,Palivo,Motor,Strop_cena,maps,ststop);

            save_data(o);       // uloz data do databazy
            ID.setOpacity(1);
            ID.setText("Vaše ID je :\n"+ x);
            return 1;


        }
        return 0;
    }

    public void OfferAccepted(ActionEvent event) throws IOException {

        if (VytvoritObjednavku()==1){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Zakaznik/ZakaznikLoginView.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("CKT-SERVIS");
            window.setScene(tableViewScene);
            window.show();
        }
        

    }

    void loaduserInfo() throws FileNotFoundException {      // nacitaj dáta prihláseného uživateľa
        Meno = LoggedUser.getname();
        Priezvisko = LoggedUser.getsurname();
        text_meno.setText(Meno);
        text_priezvisko.setText(Priezvisko);
        text_meno.setEditable(false);
        text_priezvisko.setEditable(false);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataZnacka();
        try {
            loaduserInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


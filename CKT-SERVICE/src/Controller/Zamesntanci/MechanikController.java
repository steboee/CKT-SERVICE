package Controller.Zamesntanci;


import Model.Customer.Zakaznik;
import Model.Objednavka_atd.Objednavka;
import Model.Zamestnanci.Employes;
import Model.Zamestnanci.Mechanik;
import System.FindOfferDisplayText;
import System.LookForDataOffers;
import System.RegisterAlert;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Model.Objednavka_atd.Objednavka.Nacitaj;
import static Model.Zamestnanci.Mechanik.*;

public class MechanikController implements Initializable {

    @FXML
    private TextField Konc_Kw;
    @FXML
    private TextField Konc_HP;
    @FXML
    private TextField Konc_Nm;
    @FXML
    private TextField Poc_HP;
    @FXML
    private TextField Poc_Kw;
    @FXML
    private TextField Poc_Nm;
    @FXML
    private TextField Model;
    @FXML
    private TextField Stav;
    @FXML
    private Button VytvorZaznam;
    @FXML
    private Button UpdateZaznam;

    @FXML
    private TabPane mechanikTab;

    @FXML
    private Label alert;


    @FXML
    private TextField IdObjednavky;

    ObservableList list = FXCollections.observableArrayList();


    public void create() throws IOException {   // vytvorenie choiceboxov, labelov a vyhladavanie dát z databazy
        mechanikTab.getTabs().clear();
        ArrayList<Objednavka> o = Nacitaj();
        int dlzka = o.size();
        int i =0;
        while(i < dlzka){
            if (o.get(i).getZaznam() == null){
                String Ind = LookForDataOffers.GetIndex(i+1);
                String Priezvisko = LookForDataOffers.GetSurname(Ind);
                String Meno = LookForDataOffers.GetName(Ind);
                String Znacka = LookForDataOffers.GetBrand(Ind);
                String Palivo = LookForDataOffers.GetFuel(Ind);
                String Motor = LookForDataOffers.GetEngine(Ind);
                String Cip = LookForDataOffers.GetCip(Ind);
                Zakaznik customer = new Zakaznik(Meno,Priezvisko,true);
                Objednavka offer = new Objednavka(Znacka,Palivo,Motor,Ind,customer,Cip);
                TextArea novy = new TextArea();
                Tab g1 = new Tab(LookForDataOffers.GetIndex(i+1),novy);

                list.add(g1);
                FindOfferDisplayText.SetText(novy,offer);
                mechanikTab.getTabs().add(g1);
            }
            i++;

        }
        int pocet=1;

        /*String Ind = LookForDataOffers.GetIndex(i);

        while(Ind != null){
            String Priezvisko = LookForDataOffers.GetSurname(Ind);
            String Meno = LookForDataOffers.GetName(Ind);
            String Znacka = LookForDataOffers.GetBrand(Ind);
            String Palivo = LookForDataOffers.GetFuel(Ind);
            String Motor = LookForDataOffers.GetEngine(Ind);
            String Cip = LookForDataOffers.GetCip(Ind);
            Zakaznik customer = new Zakaznik(Meno,Priezvisko,true);
            Objednavka offer = new Objednavka(Znacka,Palivo,Motor,Ind,customer,Cip);
            TextArea novy = new TextArea();
            Tab g1 = new Tab(LookForDataOffers.GetIndex(i),novy);

            list.add(g1);
            FindOfferDisplayText.SetText(novy,offer);
            mechanikTab.getTabs().add(g1);


            i++;
            Ind = LookForDataOffers.GetIndex(i);
            pocet++;
        }*/

    }



    public void Buttonclicked(ActionEvent event) throws IOException // BACK TO MENU
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Other/MainView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.setScene(tableViewScene);
        Employes emp = new Employes("mechanik","m1234");
        emp.whatclass();
        emp.showlogout();
        window.show();
    }

    public void VytvorZaznam(ActionEvent event) throws IOException {   // MECHANIK VYTVORÍ ZAZNAM PO STLACENI TLACIDLA VYTVOR ZAZNAM
        if (Mechanik.VytvorZaznamVozidla(IdObjednavky,Model,Poc_Kw,Poc_HP,Poc_Nm)==0){  // ak neboli zadané všetky údaje
            RegisterAlert.Alert(alert);
        }
        else{
            alert.setVisible(true);                     // Ak boli zadané všetky údaje
            alert.setText("Údaje boli vložené do databázy");
            Update();
        }

    }

    public void Update() throws FileNotFoundException {  // Update textfieldov, labelov na zaklade danej objednávky

        if (LookForZaznam(IdObjednavky.getText())==0){
            String kontrola1;
            String kontrola2;
            kontrola1 = GetInfo(IdObjednavky.getText(),5);
            kontrola2 = GetInfo(IdObjednavky.getText(),6);

            Model.setText(GetInfo(IdObjednavky.getText(),1));
            Model.setEditable(false);
            Poc_Nm.setText(GetInfo(IdObjednavky.getText(),4));
            Poc_Kw.setText(GetInfo(IdObjednavky.getText(),2));
            Poc_HP.setText(GetInfo(IdObjednavky.getText(),3));
            Poc_Nm.setEditable(false);
            Poc_Kw.setEditable(false);
            Poc_HP.setEditable(false);
            VytvorZaznam.setDisable(true);


            if (kontrola1.length()==0){    // bol u elektromechanika ? ak 0 tak nie
                Konc_HP.setEditable(false);
                Konc_Kw.setEditable(false);
                Konc_Nm.setEditable(false);
                UpdateZaznam.setDisable(true);
                Stav.setText("V Procese u ELEKTROMECHANIKA");
                Stav.setStyle("-fx-background-color: yellow;");
            }
            else{
                if (kontrola2.equals("")){
                    Konc_HP.setEditable(true);
                    Konc_Kw.setEditable(true);
                    Konc_Nm.setEditable(true);
                    UpdateZaznam.setDisable(false);
                    Konc_Kw.setText("");
                    Konc_HP.setText("");
                    Konc_Nm.setText("");
                    Stav.setText("Pripravené na druhý test");
                    Stav.setStyle("-fx-background-color: orange;");
                }
                else{
                    Konc_HP.setEditable(false);
                    Konc_Kw.setEditable(false);
                    Konc_Nm.setEditable(false);
                    UpdateZaznam.setDisable(true);
                    Konc_Kw.setText(GetInfo(IdObjednavky.getText(),6));
                    Konc_HP.setText(GetInfo(IdObjednavky.getText(),7));
                    Konc_Nm.setText(GetInfo(IdObjednavky.getText(),8));
                    Stav.setText("Dokončené");
                    Stav.setStyle("-fx-background-color: green;");
                }

            }

        }
        else{
            Model.setEditable(true);
            Poc_Nm.setEditable(true);
            Poc_Kw.setEditable(true);
            Poc_HP.setEditable(true);
            Model.setText("");
            Poc_Nm.setText("");
            Poc_HP.setText("");
            Poc_Kw.setText("");
            Konc_HP.setEditable(false);
            Konc_Kw.setEditable(false);
            Konc_Nm.setEditable(false);
            Konc_Kw.setText("");
            Konc_HP.setText("");
            Konc_Nm.setText("");
            UpdateZaznam.setDisable(true);
            VytvorZaznam.setDisable(false);
            Stav.setText("Neotvorená");
            Stav.setStyle("-fx-background-color: red;");

        }
        /*if (LookForDataOffers.Getchip(IdObjednavky.getText())){
            UpdateZaznam.setDisable(false);
            Konc_Nm.setEditable(true);
            Konc_Kw.setEditable(true);
            Konc_HP.setEditable(true);
        }
        else{
            UpdateZaznam.setDisable(true);
            Konc_Nm.setEditable(false);
            Konc_Kw.setEditable(false);
            Konc_HP.setEditable(false);
        }*/
    }


    public void UpdatniZaznam(ActionEvent actionEvent) throws IOException { // ak mechanik ukladá koncové parametre auta do databázy
        ArrayList<Objednavka> o = Nacitaj();
        int i = 0;
        while (o.get(i).getIndex() != Integer.parseInt((IdObjednavky.getText()))){
            i++;
        }
        if (UpdateDatabase(IdObjednavky.getText(),Model.getText(),Poc_HP.getText(),Poc_Nm.getText(),o.get(i).getZaznam().getCip(),Poc_Kw.getText(),Konc_Kw.getText(),Konc_HP.getText(),Konc_Nm.getText())==0){
            alert.setText("Vypln všetky údaje");
            return;
        }
        if (UpdateDatabase(IdObjednavky.getText(),Model.getText(),Poc_HP.getText(),Poc_Nm.getText(),o.get(i).getZaznam().getCip(),Poc_Kw.getText(),Konc_Kw.getText(),Konc_HP.getText(),Konc_Nm.getText())==-1){
            UpdateZaznam.setDisable(true);
            return;
        }
        else{
            Update();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mechanikTab.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
            if (nv != null){
                IdObjednavky.setText(nv.getText());
                try {
                    Update();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

    }
}

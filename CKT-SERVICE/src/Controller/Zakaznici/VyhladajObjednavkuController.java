package Controller.Zakaznici;

import Model.Customer.LoggedUser;
import Model.Customer.Zakaznik;
import Model.Objednavka_atd.Objednavka;
import System.FindOfferDisplayText;
import System.LookForDataOffers;
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

public class VyhladajObjednavkuController implements Initializable {

    @FXML
    private TextField findoffer;

    @FXML
    private TextField Stav;

    @FXML
    private Button Faktura;

    @FXML
    private Button ZaznamVozidla;

    @FXML
    private TextArea Display;

    @FXML
    private ChoiceBox objednavky;

    @FXML
    private Label Cena;

    @FXML
    private TextArea textarea;

    public static String MENO;
    public static String PRIEZVISKO;
    public static String userobjednavky;
    public static ObservableList ID;
    public static String idecko;


    public void Refresh(){          // refresh, pre získanie ID objednávky z GUI
        String a = (String)objednavky.getValue();
        if (a == null){
        }
        else{
            idecko = a;
        }


    }

    public void FindOffer() throws IOException {        // po stlačení tlačidla najst obejdnavku
        Refresh();

        Display.setEditable(false);
        int a = 0;
        String InDex;
        InDex = idecko;
        String Meno = LookForDataOffers.GetName(InDex);
        if (Meno == null) {
            FindOfferDisplayText.SetTextIncorrect(Display);
            return;
        }

        String Priezvisko = LookForDataOffers.GetSurname(InDex);        // vyhladajú sa údaje podla ID čisla
        String Znacka = LookForDataOffers.GetBrand(InDex);
        String Palivo = LookForDataOffers.GetFuel(InDex);
        String Motor = LookForDataOffers.GetEngine(InDex);
        String Cip = LookForDataOffers.GetCip(InDex);

        Zakaznik customer = new Zakaznik(Meno,Priezvisko,true);
        Objednavka offer = new Objednavka(Znacka,Palivo,Motor,InDex,customer,Cip);
        ArrayList<Objednavka> o = Nacitaj();
        int i = 0;
        while(o.get(i).getIndex()!=Integer.parseInt(InDex)){
            i++;
        }
        if (o.get(i).getFaktura() != null){
            if (o.get(i).getFaktura().isZaplatena()) {
                Stav.setText("ZAPLATENA");
                Faktura.setDisable(false);
                ZaznamVozidla.setDisable(false);
            }
            else {
                Stav.setText("NEZAPLATENA");
                Faktura.setDisable(false);
                ZaznamVozidla.setDisable(false);
            }
        }
        else{
            ZaznamVozidla.setDisable(false);
            Stav.setText("V PROCESE RIESENIA");
        }


        FindOfferDisplayText.SetText(Display,offer);
        ArrayList<Objednavka> olist = Nacitaj();
        int i2 = 0;
        while (olist.get(i2).getIndex() != Integer.parseInt(idecko)){
            i2++;
        }
        if (olist.get(i2).getFaktura() != null){
            Faktura.setDisable(false);
        }
        else{
            Faktura.setDisable(true);
        }



        return;

    }

    public void GetUserInfo() throws FileNotFoundException {       // získanie dát prihláseného užívateľa
        MENO = LoggedUser.getname();
        PRIEZVISKO = LoggedUser.getsurname();
    }

    public void LoadChoiceBox() throws FileNotFoundException {      // načítanie dát do choiceboxov
        String ide="";
        ObservableList list = FXCollections.observableArrayList();
        for (int i = 0 ;ide != "end" ;i++){
            ide = LookForDataOffers.GetID(MENO,PRIEZVISKO,i);
            if (ide == "false"){
                continue;
            }
            else{
                if (ide != "end"){
                    list.add(ide);
                }
            }
        }
        objednavky.getItems().addAll(list);

    }
    public void Ukaz_fakturu(ActionEvent event) throws IOException {            //IN PROGRESS
        FakturaController.LoadIde(idecko);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Zakaznik/FakturaView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));

        stage.show();
    }

    public void Ukaz_zaznam(ActionEvent event) throws IOException {    // IN PROGRESS
        ZaznamController.LoadIde(idecko);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Zakaznik/ZaznamView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }





    public void BackToMenu(ActionEvent event) throws IOException {  // VRATENIE DO MENU
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Zakaznik/ZakaznikLoginView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.setScene(tableViewScene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            GetUserInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            LoadChoiceBox();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}

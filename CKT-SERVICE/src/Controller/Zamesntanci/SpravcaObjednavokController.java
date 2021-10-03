package Controller.Zamesntanci;

import Model.Objednavka_atd.Objednavka;
import Model.Zamestnanci.Employes;
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
import static Model.Zamestnanci.Mechanik.GetInfo;
import static Model.Zamestnanci.Mechanik.LookForZaznam;
import static Model.Zamestnanci.SpravcaObjednavok.VymazatZaznam_vozidla;
import static Model.Zamestnanci.SpravcaObjednavok.VytvorFakturu;


public class SpravcaObjednavokController implements Initializable{

    @FXML
    private TextField Model;
    @FXML
    private TextField Stav;
    @FXML
    private TextField uprava;
    @FXML
    private TextField cena;

    @FXML
    private TabPane spravcaTab;

    @FXML
    private Button VytvorFakturu;

    @FXML
    private Button VymazFakturu;

    @FXML
    private TextField IdObjednavky;

    @FXML
    private Label alert;

    ObservableList list = FXCollections.observableArrayList();


    public void create() throws IOException {
        spravcaTab.getTabs().clear();
        int i =0;
        String Ind = LookForDataOffers.GetIndex(i);
        ArrayList<Objednavka> o = Nacitaj();
        int velkost = o.size();
        while(velkost !=0){
            if (o.get(i).getZaznam() != null){
                TextArea novy = new TextArea();
                Tab g1 = new Tab(String.valueOf(o.get(i).getIndex()),novy);
                list.add(g1);
                FindOfferDisplayText.SetText(novy,o.get(i));
                if (o.get(i).getFaktura() != null){
                    VytvorFakturu.setDisable(true);
                    VymazFakturu.setDisable(false);
                    spravcaTab.getTabs().add(g1);

                }
                else{
                    spravcaTab.getTabs().add(g1);
                }


            }
            i++;
            velkost--;
            Ind = LookForDataOffers.GetIndex(i);
        }

        ObservableList<Tab> a;
        a = spravcaTab.getTabs();
        if (a.isEmpty()){
            alert.setText("NIESU ZIADNE DOSTUPNÉ OBJEDNAVKY");
            IdObjednavky.setText("");
            IdObjednavky.setEditable(false);
            Model.setText("");
            Model.setEditable(false);
            Stav.setText("");
            Stav.setEditable(false);
            cena.setText("");
            cena.setEditable(false);
            uprava.setText("");
            uprava.setEditable(false);
            VytvorFakturu.setDisable(true);
        }
        else{
            IdObjednavky.setEditable(false);
            Model.setEditable(false);
            Stav.setEditable(false);
            cena.setText("");
            cena.setEditable(true);
            uprava.setText("");
            uprava.setEditable(true);
            VytvorFakturu.setDisable(false);
        }
        Update();

    }



    public void Buttonclicked(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Other/MainView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.setScene(tableViewScene);
        Employes emp = new Employes("spravca","s1234");
        emp.whatclass();
        emp.showlogout();
        window.show();
    }

    public void VytvoritFakturu() throws IOException {

        if (IdObjednavky.getText().length()==0){
            alert.setText("VYPLN VŠETKY UDAJE");
            return;
        }
        else if(uprava.getText().length()==0){
            alert.setText("VYPLN VŠETKY UDAJE");
            return;
        }
        else if(cena.getText().length()==0){
            alert.setText("VYPLN VŠETKY UDAJE");
            return;
        }
        VytvorFakturu(IdObjednavky.getText());
        Update();
        create();

    }

    public void Update() throws FileNotFoundException {
        if (LookForZaznam(IdObjednavky.getText())==0){
            String kontrola1;
            String kontrola2;
            kontrola1 = GetInfo(IdObjednavky.getText(),5);
            kontrola2 = GetInfo(IdObjednavky.getText(),6);
            Model.setText(GetInfo(IdObjednavky.getText(),1));
            Model.setEditable(false);
            ArrayList<Objednavka> o = Nacitaj();

            int i =0;
            while (o.get(i).getIndex() != Integer.parseInt(IdObjednavky.getText())){
                i++;
            }

            uprava.setText(o.get(i).getZaznam().getCip());
            if (o.get(i).getFaktura()!=null){
                cena.setText(String.valueOf(o.get(i).getFaktura().getCena()));
            }
            else{
                cena.setText("-------");
            }


            if (o.get(i).getFaktura() != null){
                VytvorFakturu.setDisable(true);
                VymazFakturu.setDisable(false);
                if (o.get(i).getFaktura().isZaplatena()){
                    Stav.setText("ZAPLATENA");
                }
                else{
                    Stav.setText("CAKA SA NA PLATBU");
                    VymazFakturu.setDisable(true);
                }

            }
            else{
                VymazFakturu.setDisable(false);
                VytvorFakturu.setDisable(false);
                Stav.setText("PRIPRAVENÉ");
            }



            /*if (kontrola1.length()==0){    // bol u elektromechanika ? ak 0 tak nie
                Stav.setText("V Procese u ELEKTROMECHANIKA");
                Stav.setStyle("-fx-background-color: yellow;");
            }
            else{
                if (kontrola2.equals("")){
                    Stav.setText("Pripravené na druhý test");
                    Stav.setStyle("-fx-background-color: orange;");
                }
                else{
                    Stav.setText("Dokončené");
                    Stav.setStyle("-fx-background-color: green;");
                }

            }*/

        }
    }


    public void VymazZaznam() throws IOException {
        VymazatZaznam_vozidla(IdObjednavky.getText());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spravcaTab.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
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

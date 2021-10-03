package Controller.Zamesntanci;

import Model.Objednavka_atd.Objednavka;
import Model.Suciastky.Software.EHMC.EHMC;
import Model.Suciastky.Software.STAGE.STAGE;
import Model.Suciastky.Suciastka;
import Model.Zamestnanci.Elektromechanik;
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


public class ElektromechanikController implements Initializable {

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
    private Button potvrd;
    @FXML
    public CheckBox aktualizacia;
    @FXML
    public CheckBox startstop;
    @FXML
    private TabPane mechanikTab;
    @FXML
    private ChoiceBox choicebox_cipy;
    @FXML
    private Label niesu;



    @FXML
    private TextField IdObjednavky;


    public void Buttonclicked(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Other/MainView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS");
        window.setScene(tableViewScene);
        Employes emp = new Employes("elektromechanik","e1234");
        emp.whatclass();
        emp.showlogout();
        window.show();
    }

    public void Update() throws FileNotFoundException {
        if (LookForZaznam(IdObjednavky.getText())==0){
            String kontrola;
            kontrola = GetInfo(IdObjednavky.getText(),5);

            Model.setText(GetInfo(IdObjednavky.getText(),1));
            Model.setEditable(false);
            Poc_Nm.setText(GetInfo(IdObjednavky.getText(),4));
            Poc_Kw.setText(GetInfo(IdObjednavky.getText(),2));
            Poc_HP.setText(GetInfo(IdObjednavky.getText(),3));
            Poc_Nm.setEditable(false);
            Poc_Kw.setEditable(false);
            Poc_HP.setEditable(false);

            if (kontrola.length()!=0){
                Stav.setText("Dokončená");
                Stav.setStyle("-fx-background-color: green;");
            }
            else{
                Stav.setText("V Procese");
                Stav.setStyle("-fx-background-color: orange;");
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
            Stav.setText("Neotvorená");
            Stav.setStyle("-fx-background-color: red;");

        }
        choicebox_cipy.getItems().clear();
        ObservableList stages = FXCollections.observableArrayList();
        String znacka = LookForDataOffers.GetBrand(IdObjednavky.getText());
        if (znacka.equals("Skoda") || znacka.equals("VW")){
            for (int i = 0;i<3;i++){
                String nazov = ("STAGE"+(i+1));
                int cena = 300*(i+1);
                Suciastka a = new STAGE(nazov,cena);

                stages.add(a.getMeno() +" "+ a.getCena());
            }
            choicebox_cipy.getItems().addAll(stages);

        }
        else{
            for (int i = 0;i<3;i++){
                String nazov = ("EHMC"+(i+1));
                int cena = 300*(i+1);
                Suciastka a = new EHMC(nazov,cena);
                stages.add(a.getMeno() +" "+ a.getCena());
            }
            choicebox_cipy.getItems().addAll(stages);
        }

    }

    public void create() throws IOException {
        choicebox_cipy.getItems().clear();
        ObservableList list = FXCollections.observableArrayList();
        ObservableList stages = FXCollections.observableArrayList();
        String znacka = LookForDataOffers.GetBrand(IdObjednavky.getText());

        choicebox_cipy.getItems().addAll(stages);


        int pocet=1;
        mechanikTab.getTabs().clear();
        int i =0;
        String Ind = LookForDataOffers.GetIndex(i);
        ArrayList<Objednavka> o = Nacitaj();
        int velkost = o.size();
        while(i != velkost){
            if (o.get(i).getZaznam()==null){
                i++;
                continue;

            }

            if (o.get(i).getZaznam().getsuciastka()==null) {
                TextArea novy = new TextArea();
                Tab g1 = new Tab(o.get(i).getZaznam().getId(), novy);
                FindOfferDisplayText.SetText(novy, o.get(i));
                list.add(g1);
                mechanikTab.getTabs().add(g1);
            }
            i++;
            Ind = LookForDataOffers.GetIndex(i);
            /*
            String Priezvisko = LookForDataOffers.GetSurname(Ind);
            String Meno = LookForDataOffers.GetName(Ind);
            String Znacka = LookForDataOffers.GetBrand(Ind);
            String Palivo = LookForDataOffers.GetFuel(Ind);
            String Motor = LookForDataOffers.GetEngine(Ind);
            String Cip = LookForDataOffers.GetCip(Ind);
            Zakaznik customer = new Zakaznik(Meno,Priezvisko,true);
            Objednavka offer = null;
            TextArea novy = new TextArea();
            String elektroindex = LookForDataOffers.GetElektroIndex(Ind);
            if (elektroindex == null){
                i++;
                Ind = LookForDataOffers.GetIndex(i);
                offer = new Objednavka(Znacka,Palivo,Motor,Ind,customer,Cip);
                pocet++;
                continue;
            }
            Tab g1 = new Tab(elektroindex,novy);

            list.add(g1);
            FindOfferDisplayText.SetText(novy,offer);
            mechanikTab.getTabs().add(g1);
            i++;
            Ind = LookForDataOffers.GetIndex(i);
            pocet++;


            if (LookForZaznam(IdObjednavky.getText())==0){
                Model.setText(GetInfo(IdObjednavky.getText(),1));
                Model.setEditable(false);
                Poc_Nm.setText(GetInfo(IdObjednavky.getText(),4));
                Poc_Kw.setText(GetInfo(IdObjednavky.getText(),2));
                Poc_HP.setText(GetInfo(IdObjednavky.getText(),3));
                Poc_Nm.setEditable(false);
                Poc_Kw.setEditable(false);
                Poc_HP.setEditable(false);
                potvrd.setDisable(true);
                Stav.setText("V Procese");
                Stav.setStyle("-fx-background-color: orange;");

            }*/
        }


        if (mechanikTab.getTabs().isEmpty()){
            niesu.setText("NIESU OBJEDNAVKY");
        }

    }

    public void PotvrdE() throws IOException {
        String a = choicebox_cipy.getSelectionModel().getSelectedItem().toString();
        String[]p = a.split(" ",2);
        Elektromechanik.WriteInfo(IdObjednavky.getText(),p[0]);
        System.out.println(p[0]);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Elektromechanik.info();
        mechanikTab.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
            if (nv != null) {
                IdObjednavky.setText(nv.getText());
                try {
                    Update();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });
        potvrd.setDisable(true);
        choicebox_cipy.getSelectionModel().selectedItemProperty().addListener((obs, nvs, s) -> {
            if (s != null) {
                String nazov = choicebox_cipy.getSelectionModel().getSelectedItem().toString();
                String b[] = nazov.split(" ",3);
                Suciastka a;
                if (b[0].contains("STAGE") == true){
                    a = new STAGE(b[0],Integer.parseInt(b[1]));
                }
                else{
                    a = new EHMC(b[0],Integer.parseInt(b[1]));
                }

                //a.vypisinfo();
                potvrd.setDisable(false);
            } else {

                potvrd.setDisable(true);
            }

        });



    }

    //@Override
    public void update() {

    }
}

package Controller.Zakaznici;

import Model.Objednavka_atd.Objednavka;
import Model.Suciastky.Software.EHMC.EHMC;
import Model.Suciastky.Software.STAGE.STAGE;
import Model.Suciastky.Suciastka;
import Strategies.SRATEGY.PayStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Controller.Zakaznici.PaybyCardController.Nacitaj_fakturu;
import static Controller.Zakaznici.PaybyPaypalController.nastav;
import static Model.Objednavka_atd.Faktura.variabilna;
import static Model.Objednavka_atd.Objednavka.Nacitaj;

public class FakturaController implements Initializable {
    private  PayStrategy strategy;

    @FXML
    Label SofwareName;
    @FXML
    Label DoplnokName;
    @FXML
    Label DoplnokName1;
    @FXML
    Label SoftwareCena;
    @FXML
    Label DoplnokCena;
    @FXML
    Label DoplnokCena1;
    @FXML
    Label SUMA;
    @FXML
    Label VariabilnaCena;

    @FXML
    private Button PaybyCard;

    @FXML
    private Button PaybyPaypal;

    @FXML
    public Label IDE;

    public static String ID;        // statická premenná (uchováva ID objednávky/faktúry - sú rovnaké



    public static void LoadIde(String a){   // načíta ID objednávky (volanie z predošleho controllera)
        ID = a;
    }



    public void init() throws FileNotFoundException {   // Inicializácia okna
        Objednavka[] o;
        o = Nacitaj().toArray(new Objednavka[0]);       // Nacitanie objednavok
        for (int i = 0; i < o.length;i++){
            if (o[i].getIndex() == Integer.parseInt(ID)){       // hladam objednavku podla ID
                if (o[i].isAktualizacia()){             // Ak je v objednavke zadaná +Aktualizacia máp
                    o[i].getFaktura().ZvysCenu();       // tym padom sa zvyśi cena
                    DoplnokName.setText("Aktualizácia Máp");
                    DoplnokCena.setText("50 eur");
                }
                if (o[i].isStartStop()){                // Ak je v objednavke zadané +Vypnut start stop
                    o[i].getFaktura().ZvysCenu();       // zvysi sa cena
                    DoplnokName1.setText("Vypnutie Štart-Stop");
                    DoplnokCena1.setText("50 eur");
                }
                int PRICE = o[i].getFaktura().getCena();
                int cena;
                IDE.setText(String.valueOf(o[i].getIndex()));
                o[i].getZaznam().loadcip();
                SofwareName.setText(o[i].getZaznam().getCip());
                ArrayList<Suciastka> list;
                if (o[i].getZaznam().getCip().contains("STAGE")){     // Ak v aute je cip Typu STAGE
                    STAGE a = new STAGE(o[i].getZaznam().getCip()); // vytovrí sa Cip STAGE
                    list = Suciastka.create();      //list vsetkych cipov STAGE
                    int dlzka = list.size();
                    for (int j = 0; j<dlzka;j++){
                        if (list.get(j).getMeno().equals(a.Getmeno())){     // prejde sa zaznam vsetkych Cipov STAGE a najde sa ten ktorý je na aute
                            cena = (list.get(i).getCena());
                            SoftwareCena.setText(cena+" eur");
                        }
                    }
                }
                else{       // ak by tam bol cip typu EHMC
                    EHMC a = new EHMC(o[i].getZaznam().getCip());       // vytvorí sa cip EHMC
                    list = Suciastka.create();      // list vsetkych cipov
                    int dlzka = list.size();
                    for (int j = 0; j<dlzka;j++){
                        if (list.get(j).getMeno().equals(a.Getmeno())){     // prejde sa zaznam vsetkych cipov a najde sa ten ktorý je an aute
                            cena = (list.get(j).getCena());

                            SoftwareCena.setText(cena+" eur");
                        }
                    }
                }
                if (o[i].getFaktura().isZaplatena()){
                    PaybyCard.setDisable(true);
                    PaybyPaypal.setDisable(true);
                }

                double variabilna = variabilna(o[i]);

                VariabilnaCena.setText(String.valueOf((int)variabilna)+" "+"eur");

                SUMA.setText(String.valueOf(PRICE)+" "+"eur");



            }
        }
        System.out.println(o[0].getZakaznik().Name);



    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void PaybyPaypal(ActionEvent event) throws IOException {
        PaybyPaypalController a = new PaybyPaypalController();
        ArrayList<Objednavka> olist = Nacitaj();
        Objednavka o = Objednavka.FindObjednavka(olist,Integer.parseInt(ID));
        nastav(o.getFaktura());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Zakaznik/PaybyPayPal.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void PaybyCard(ActionEvent event) throws IOException {
        PaybyCardController a = new PaybyCardController();
        ArrayList<Objednavka> olist = Nacitaj();
        Objednavka o = Objednavka.FindObjednavka(olist,Integer.parseInt(ID));
        Nacitaj_fakturu(o.getFaktura());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Zakaznik/PaybyCard.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}

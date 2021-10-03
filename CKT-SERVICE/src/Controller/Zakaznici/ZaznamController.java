package Controller.Zakaznici;

import Model.Objednavka_atd.Objednavka;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Model.Objednavka_atd.Objednavka.Nacitaj;

public class ZaznamController implements Initializable {

    @FXML
    private Label KW_poc;
    @FXML
    private Label HP_poc;
    @FXML
    private Label Nm_poc;
    @FXML
    private Label KW_end;
    @FXML
    private Label HP_end;
    @FXML
    private Label Nm_end;
    @FXML
    private Label KW_rozdiel;
    @FXML
    private Label HP_rozdiel;
    @FXML
    private Label Nm_rozdiel;
    @FXML
    private Label IDE;
    @FXML
    private TextArea textarea;

    public static String INDEX;


    public static void LoadIde(String index){
        INDEX = index;
    }

    public void init() throws FileNotFoundException {
        ArrayList<Objednavka> o = Nacitaj();
        int i = 0;
        while(o.get(i).getIndex()!= Integer.parseInt(INDEX)){
            i++;
        }
        IDE.setText(INDEX);
        if (o.get(i).getZaznam() != null){
            KW_poc.setText(o.get(i).getZaznam().getStartKw());
            HP_poc.setText(o.get(i).getZaznam().getStartHP());
            Nm_poc.setText(o.get(i).getZaznam().getStartNm());
            String kontrola = o.get(i).getZaznam().getEndKw();
            if (kontrola == null){
                textarea.setText("Vaše auto prešlo prvotným testom.\n" +
                        "Výsledky si môžte pozrieť vyššie");
                textarea.setEditable(false);
            }
            else{
                KW_end.setText(o.get(i).getZaznam().getEndKw());
                HP_end.setText(o.get(i).getZaznam().getEndHP());
                Nm_end.setText(o.get(i).getZaznam().getEndNm());
                KW_rozdiel.setText(o.get(i).getZaznam().getRozdielKW());
                HP_rozdiel.setText(o.get(i).getZaznam().getRozdielHP());
                Nm_rozdiel.setText(o.get(i).getZaznam().getRozdielNM());
                textarea.setText(o.get(i).getZaznam().getsuciastka().vypisinfo());
                textarea.setEditable(false);
            }

        }
        else{
            textarea.setText("Záznam o vašom vozidle ešte nebol vytvorený.\n" +
                    " Buďte trpezlivý");
            textarea.setEditable(false);
        }




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package System;

import Model.Objednavka_atd.Objednavka;
import javafx.scene.control.TextArea;

import java.io.FileNotFoundException;

import static System.LookForDataOffers.Mapy;
import static System.LookForDataOffers.Startstop;

public class FindOfferDisplayText {

    public static void SetText(TextArea Display, Objednavka o) throws FileNotFoundException {
        String start = Startstop(String.valueOf(o.getIndex()));
        String map = Mapy(String.valueOf(o.getIndex()));
        Display.setText("ID : "+ o.getIndex() +
                "\nMeno : "+ o.getZakaznik().Name +
                "\nPriezvisko : "+o.getZakaznik().Surname +
                "\nZnačka auta : "+o.getAuto().brand+
                "\nTyp paliva : "+o.getAuto().fuel+
                "\nTyp motora : "+o.getAuto().engine+
                "\nCena Strop: "+o.getCena_strop() +
                "\nVypnutie Štart-Stop -  " + start +
                "\nAktualizácia máp - "+ map +"\n");

        Display.setEditable(false);

    }
    public static void SetTextIncorrect(TextArea Display){
        Display.setText("ZADALI STE NEPLATNE ID OBJEDNAVKY");
    }

}

package System;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class AlertObjednavka{


    public static int Alert(String Name,String Surname, String Znacka, String Motor,String cena,Label upozornenie) {
        if (Name.length() == 0) {
            upozornenie.setText("Zadaj Meno !!");
            return 0;
        }
        else if (Surname.length() == 0) {
            upozornenie.setText("Zadaj Priezvisko !!");
            return 0;
        }
        else if (Znacka == null) {
            upozornenie.setText("Zadaj znacku auta !!! ");
            return 0;
        }
        else if (Motor == null) {
            upozornenie.setText("Zadaj motor auta !!! ");
            return 0;
        }
        else if (cena.equals("")){
            upozornenie.setText("Zadajte strponú cenu !!!");
            return 0;
        }
        else{
            if (Integer.parseInt(cena)<400){
                upozornenie.setText("Stropná cena min. 400 ");
                return 0;
            }
            else {
                upozornenie.setText("");
                return 1;
            }
        }
    }

    public static void alertinfo(String a){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (a=="LOGIN"){
            alert.setContentText("Zadali ste nesprávne meno alebo heslo");
            alert.showAndWait();
        }

    }

    public static void alertinfo_register(int a){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Vyplnte vsetky udaje");
        alert.showAndWait();
    }
}

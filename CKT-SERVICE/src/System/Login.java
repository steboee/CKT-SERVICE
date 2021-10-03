package System;

import javafx.scene.control.Label;

/**
 * The type Login.
 */
public class Login {


    public static void LogiInAlert(Label label){
        label.setOpacity(1);
        label.setText("Zadali ste nesprávne meno\nalebo heslo");
    }
}

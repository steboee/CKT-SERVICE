package System;

import javafx.scene.control.Label;

public class RegisterAlert {

    public static int Alert(String Name, String Surname, String username, String Password, Label l){
        if (Name.length() == 0 || Surname.length() == 0 || username.length() == 0 || Password.length() == 0){
            l.setText("Vypln vsetky udaje");
            return 0;
        }
        else{
            return 1;
        }

    }

    public static int Alertend(String a,String b, String c){
        if (a.length() == 0 || b.length() == 0||c.length()==0){
            return 1;
        }
        return 0;
    }

    public static void Alert(Label l){
        l.setVisible(true);
        l.setText("Vypln vsetky udaje");
    }


}

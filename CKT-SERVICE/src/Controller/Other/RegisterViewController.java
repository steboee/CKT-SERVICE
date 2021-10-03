package Controller.Other;

import Model.Customer.Zakaznik;
import System.Exceptions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static System.AlertObjednavka.alertinfo_register;

public class RegisterViewController {
    public static String meno;
    public static String priezvisko;
    public static String username;
    public static String password;

    TextField Meno;

    public int nacitajudaje(String Meno,String Priezvisko, String Username, String Password){ // nacitavanie udajov z gui
        int a = 0;
        Exceptions exc = new Exceptions();
        if (Meno.length()==0){      // hadze alerty ak meno nieje zadane
            exc.NullMenoRegister();
            a++;
        }
        else{
            meno = Meno;
        }

        if (Priezvisko.length()==0){    // hadze alerty ak priezvisko nieje zadane
            exc.NullPriezviskoRegister();
            a++;
        }
        else{
            priezvisko = Priezvisko;
        }

        if (Username.length()==0){     // hadze alerty ak prihl.meno nieje zadane
            exc.NullUsernameRegister();
            a++;
        }
        else{
            username = Username;

        }

        if (Password.length()==0){    // hadze alerty ak prihl. heslo nieje zadane
            exc.NullPasswordRegister();
            a++;
        }
        else{
            password = Password;
        }


        if (a!=0){
            alertinfo_register(a);
            return 0;
        }
        return 1;

    }

    public void RegisterUser() throws Exception {

        Zakaznik now = new Zakaznik(meno,priezvisko,username,password); // vytborí sa zakaznik
        if (now.zakaznik_save_data(now)==1){    // ak sa podari uloziu zakaznika
            FXMLLoader fxmlLoader = new FXMLLoader(RegisterViewController.class.getResource("/View/Other/MainView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            pressButton();
        }
        else{   // ak sa nepodari uložiť zakaznika do databázy tak prohram hodí Exception
            Exception NotStoredData = new Exception("StoredDataERROR");
            NotStoredData.printStackTrace();
        }
    }
    public void pressButton() throws Exception {        // otvoŕi popup okno "BOLI STE ZAREGISTROVANÝ"
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Other/Registered.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }







    public static void backtomenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegisterViewController.class.getResource("/View/Other/MainView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}

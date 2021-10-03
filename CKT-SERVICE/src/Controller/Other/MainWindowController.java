package Controller.Other;

import Controller.Zakaznici.ZakaznikLoginController;
import Model.Customer.LoggedUser;
import Model.Customer.Zakaznik;
import Model.Zamestnanci.Employes;
import View.Other.RegisterView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static Model.Zamestnanci.Employes.GetDatabaseEmployes;
import static System.AlertObjednavka.alertinfo;


public class MainWindowController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginlabel;


    public void Login(ActionEvent event) throws IOException{   // Po stlačení tlačidla LOGIN
        Employes logged = new Employes(username.getText(),password.getText());  // vytvorí sa zamestnanec z vloźených údajov
        Zakaznik novy_z = new Zakaznik(username.getText(),password.getText());  // vytvorí sa zákaznik z vloŽených údajov
        ArrayList<Employes> database = GetDatabaseEmployes();  // databáza prihlasovacích údajov zamestnancov
        ArrayList<String> file = new ArrayList<>();

        if (logged.whatclass() != null){        // Ak sa chce prihlásiť zamestnanec tak funkcia whatclass() vrati Objekt daného zamestnanca
            for (int i = 0; i<3;i++){               // Vo firme sú 3 zamestnanci
                Employes employee = database.get(i);         // využíva sa polymorfia
                Object l = logged.whatclass();
                if (employee.getClass() == l.getClass()){       // RTTI ... prechazdam vsetkymi zamesntancami a ak sa to rovná zamestnancovi ktorí sa prihlasuje tak sa prepne window
                    file = employee.prepni_obrazovku();     // údaje vo file-> [0]- cesta k danému view
                    break;                                  //                 [1]- názov okna
                }
            }
            Parent tableViewParent1 = FXMLLoader.load(getClass().getResource(file.get(0)));
            Scene tableViewScene1 = new Scene(tableViewParent1);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle(file.get(1));
            window.setScene(tableViewScene1);
            logged.showlogin();
            window.show();

        }
        else if (Zakaznik.LoginCustomer(novy_z)){       // Ak to nebol zamestnanec tak sa skontroluju zakanzik ak to je zakaznik tak skoči do if-u
            FXMLLoader Loader = new FXMLLoader();
            LoggedUser l = new LoggedUser(username.getText(),password.getText());     // vytvorí sa prihlásený uživateľ
            l.vypisinfo();
            Loader.setLocation(getClass().getResource("/View/Zakaznik/ZakaznikLoginView.fxml"));
            Loader.load();
            ZakaznikLoginController display = Loader.getController();
            display.setlabel(l);                        // nastaví sa label na dalšom okne
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Zakaznik/ZakaznikLoginView.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setUserData(l);
            window.setTitle("CKT-SERVIS_Zakaznik");
            window.setScene(tableViewScene);
            l.showlogin(username.getText());
            window.show();
        }
        else{       // ak sa údaje nezhoduju zo žiadnymi údajmi tak vyskočí Alert okno
            alertinfo("LOGIN");
        }

    }



    public void Register(ActionEvent event) throws Exception {         // Prepne na okno registrácie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        RegisterView login = new RegisterView();
        login.start(window);

/*
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/Other/RegisterView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("CKT-SERVIS_Register");
        window.setScene(tableViewScene);
        window.show();
*/
    }




}


    

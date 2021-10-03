package View.Other;

import Controller.Other.RegisterViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterView {

    public void start(Stage primaryStage) throws Exception {

        RegisterViewController controller = new RegisterViewController();

        Stage window = primaryStage;
        StackPane root = new StackPane();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Text welcome = new Text("Registration");
        welcome.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        grid.add(welcome, 0, 0);

        Label lbluser = new Label("Username");
        grid.add(lbluser, 0, 3);

        TextField txtUser = new TextField();
        txtUser.setPromptText("username");
        grid.add(txtUser, 1, 3);

        Label lblPassword = new Label("Password");
        grid.add(lblPassword, 0, 4);

        TextField txtpass = new TextField();
        txtpass.setPromptText("password");
        grid.add(txtpass, 1, 4);

        Label lblname = new Label("Meno");
        grid.add(lblname, 0, 1);

        TextField txtName = new TextField();
        txtName.setPromptText("Meno");
        grid.add(txtName, 1, 1);

        Label lblSurname = new Label("Priezvisko");
        grid.add(lblSurname, 0, 2);

        TextField txtsur = new TextField();
        txtsur.setPromptText("priezvisko");
        grid.add(txtsur, 1, 2);


        Button register = new Button("REGISTER");

        register.setOnAction((e) -> {
            if (controller.nacitajudaje(txtName.getText(), txtsur.getText(), txtUser.getText(), txtpass.getText()) == 1) {
                try {
                    controller.RegisterUser();
                    primaryStage.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        });

        Button back = new Button("Back to Login");
        back.setOnAction((e) -> {
            try {
                controller.backtomenu();
                primaryStage.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        grid.add(back, 2, 8);
        grid.add(register, 1, 8);


        Scene scene = new Scene(grid, 500, 500);
        window.setScene(scene);
        window.show();
    }




}

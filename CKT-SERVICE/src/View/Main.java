package View;

import View.Other.RegisterView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public  class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Other/MainView.fxml"));
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        stage.setTitle("CKT-SERVIS");
        stage.show();
        RegisterView login = new RegisterView();
        //login.start(stage);
    }

    public static void main(String[] args) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        FileWriter writer = new FileWriter("src/Database/Log.txt");
        writer.write(dtf.format(now)+"\n");
        writer.close();
        launch(args);
    }

}

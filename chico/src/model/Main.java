package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ChicoGame;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void init() throws Exception {
        super.init();

        try {
            ChicoGame.getInstance().carrega();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void stop() throws Exception {
        super.stop();


        try {
            ChicoGame.getInstance().salva();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Jogo.fxml"));


        Scene scene = new Scene(loader.load());
        stage.setScene(scene);

        stage.show();



    }
}
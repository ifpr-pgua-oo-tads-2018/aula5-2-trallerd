package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.ChicoGame;
import model.Jogador;

import java.sql.SQLException;

public class Jogo {

    @FXML
    private ListView<Jogador> ltvJogadores;

    public void initialize(){

        ltvJogadores.setItems(ChicoGame.getInstance().listaJogadores());


    }


}

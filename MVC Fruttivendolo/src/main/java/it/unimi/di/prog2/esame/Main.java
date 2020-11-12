package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.TicketModel;
import it.unimi.di.prog2.esame.view.CustomerRole;
import it.unimi.di.prog2.esame.view.ClerkRole;
import it.unimi.di.prog2.esame.view.DisplayView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Fruttivendolo");


    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));


    //CREAZIONE DEL MODEL
    TicketModel model = new TicketModel();

    //CREAZIONE DELLE VIEW
    DisplayView dispenser1 = new DisplayView(CustomerRole.INSTANCE, "GET TICKET");

    //CREAZIONE DEI CONTROLLER
    new Controller(model, dispenser1);

    //TODO: aggiungere
    // una seconda vista cliente (dispenser biglietti e display)
    // una vista commesso (bottone "servi" e display)


    // IL MODELLO NOTIFICA A TUTTE LE VISTE REGISTRATE IL VALORE INIZIALE
    model.notifyObservers();

    gridPane.add(dispenser1, 0, 0);

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

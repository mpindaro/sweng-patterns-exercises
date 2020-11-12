package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.Ticket;
import it.unimi.di.prog2.esame.observer.Subject;
import javafx.scene.Parent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class DisplayView extends Region implements TicketView {

  final Label numero;
  final Button bottone ;
  private final RoleStrategy role;

  public DisplayView(RoleStrategy role, String testoBottone) {

    this.role = role;
    bottone = new Button(testoBottone);
    numero = new Label("0");


    numero.setFont(Font.font("Courier", 30));
    setId(testoBottone); //Utile per il testing
    setBackground(new Background(
            new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
            new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

    GridPane grid = new GridPane();
    grid.add(numero, 0, 0);
    grid.add(bottone, 0, 1);
    this.getChildren().add(grid);
  }

  //TODO: implementare i metodi per soddisfare la interfaccia
}

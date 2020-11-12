package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.controller.Controller;
import it.unimi.di.prog2.esame.model.TicketModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static junit.framework.TestCase.assertEquals;

public class IntegrationTest extends ApplicationTest {

  private DisplayView dispenser1;
  private DisplayView dispenser2;
  private DisplayView commesso1;

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Fruttivendolo");

    TicketModel model = new TicketModel();

    dispenser1 = new DisplayView(CustomerRole.INSTANCE, "disp1");
    dispenser2 = new DisplayView(CustomerRole.INSTANCE, "disp2");

    commesso1 = new DisplayView(ClerkRole.INSTANCE, "comm1");

    new Controller(model, dispenser1);
    new Controller(model, dispenser2);
    new Controller(model, commesso1);

    GridPane gridPane = new GridPane();
    gridPane.add(dispenser1, 0, 0);
    gridPane.add(dispenser2, 0, 1);
    gridPane.add(commesso1, 0, 3);

    Scene scene = new Scene(gridPane);
    stage.setScene(scene);
    stage.show();

    // IL MODELLO NOTIFICA A TUTTE LE VISTE REGISTRATE LA SITUAZIONE INIZIALE
    model.notifyObservers();
  }

  @Test
  public void integrationTest() {
    clickOn(getBottone("disp1"));
    clickOn(getBottone("disp2"));
    clickOn(getBottone("disp1"));

    assertEquals("3", getLabel("disp2").getText());

    clickOn(getBottone("comm1"));
    clickOn(getBottone("comm1"));

    assertEquals("2", getLabel("comm1").getText());

    clickOn(getBottone("comm1"));
    clickOn(getBottone("comm1"));

    assertEquals("3", getLabel("comm1").getText());
  }

  private Labeled getLabel(String id) {
    return lookup("#"+id+" .label").queryLabeled();
  }

  private Button getBottone(String id) {
    return lookup("#"+ id +" .button").queryButton();
  }
}
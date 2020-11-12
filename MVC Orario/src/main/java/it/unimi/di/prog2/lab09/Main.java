package it.unimi.di.prog2.lab09;

import it.unimi.di.prog2.lab09.controller.TimeController;
import it.unimi.di.prog2.lab09.model.Time;
import it.unimi.di.prog2.lab09.model.Time24;
import it.unimi.di.prog2.lab09.view.ConsoleView;
import it.unimi.di.prog2.lab09.view.TextFieldView;
import it.unimi.di.prog2.lab09.view.TimeZone;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("World Clock App");

    Time model = new Time(13, 57);

    TextFieldView gmt = new TextFieldView(new TimeZone("GMT", 0));
    TextFieldView moscow = new TextFieldView(new TimeZone("Mosca", 3 * 60));
    TextFieldView newyork = new TextFieldView(new TimeZone("New York", -5 * 60));
    ConsoleView milano = new ConsoleView(new TimeZone("Milano" , 60));

    model.registerObserver(gmt);
    model.registerObserver(moscow);
    model.registerObserver(newyork);
    model.registerObserver(milano);

    model.notifyObservers();


    new TimeController(model, gmt);
    new TimeController(model, moscow);
    new TimeController(model, newyork);

    GridPane gridPane = new GridPane();
    gridPane.add(gmt, 0, 0);
    gridPane.add(moscow, 0, 1);
    gridPane.add(newyork, 0, 2);

    //TODO: aggiungere una terza "riga" alla interfaccia in cui venga presentato (similmente agli altri due)
    //      l'ora secondo la timezone di NewYork


    //TODO: predisporre una vista di solo output (ConsoleView) che stampi sullo stardard output l'ora
    //      secondo la timezone di "Milano"
    //      HINT: essendo di sola lettura non c'è bisogno che implementi TimeView, ma è sufficiente che
    //            implementi Observer<Time24> e venga opportunamente collegato al modello

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();

    // IL MODELLO NOTIFICA A TUTTE LE VISTE REGISTRATE L'ORA INIZIALE
  }
}

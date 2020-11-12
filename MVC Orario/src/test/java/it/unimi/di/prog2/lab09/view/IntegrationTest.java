package it.unimi.di.prog2.lab09.view;

import it.unimi.di.prog2.lab09.controller.TimeController;
import it.unimi.di.prog2.lab09.model.Time;
import it.unimi.di.prog2.lab09.model.Time24;
import it.unimi.di.prog2.lab09.view.ConsoleView;
import it.unimi.di.prog2.lab09.view.TextFieldView;
import it.unimi.di.prog2.lab09.view.TimeZone;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;
import org.testfx.framework.junit.ApplicationTest;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class IntegrationTest extends ApplicationTest {

    TextFieldView gmt ;
    TextFieldView moscow ;
    TextFieldView newyork ;
    ConsoleView milano ;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("World Clock App");

        Time model = new Time(13, 57);

         gmt = new TextFieldView(new TimeZone("GMT", 0));
         moscow = new TextFieldView(new TimeZone("Mosca", 3 * 60));
         newyork = new TextFieldView(new TimeZone("New York", -5 * 60));
         milano = new ConsoleView(new TimeZone("Milano" , 60));

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

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();


    @Test
    public void testWithThreeTextField(){
        doubleClickOn(gmt.hour);
        write("0");
        press(KeyCode.ENTER);
        release(KeyCode.ENTER);
        doubleClickOn(gmt.minute);
        write("59");
        press(KeyCode.ENTER);
        release(KeyCode.ENTER);

        assertEquals("03",moscow.hour.getText());
        assertEquals("59",moscow.minute.getText());

        assertEquals("19",newyork.hour.getText());
        assertEquals("59",newyork.minute.getText());

        assertEquals("00",gmt.hour.getText());
        assertEquals("59",gmt.minute.getText());

        assertEquals("Milano 14:57\nMilano 01:57\nMilano 01:59\n",output.getLog());




    }
}

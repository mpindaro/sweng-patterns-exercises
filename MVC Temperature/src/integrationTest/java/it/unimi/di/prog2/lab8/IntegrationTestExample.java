package it.unimi.di.prog2.lab8;

import static junit.framework.TestCase.assertEquals;

import it.unimi.di.prog2.lab8.controller.Controller;

import it.unimi.di.prog2.lab8.model.TemperatureModel;
import it.unimi.di.prog2.lab8.view.CelsiusScale;
import it.unimi.di.prog2.lab8.view.FahrenheitScale;
import it.unimi.di.prog2.lab8.view.View;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class IntegrationTestExample extends ApplicationTest {

  View celsiusField;
  View fahrenheitField;

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Lab08");

    celsiusField = new View(CelsiusScale.getIstance());
    fahrenheitField= new View(FahrenheitScale.getIstance());

    GridPane gridPane = new GridPane();

    TemperatureModel temperatureModel =  new TemperatureModel();

    Controller controllerCelsius = new Controller(celsiusField,temperatureModel);
    Controller  controllerFahrenheit = new Controller(fahrenheitField,temperatureModel);

    gridPane.add(celsiusField,1,1);
    gridPane.add(fahrenheitField,1,2);

    temperatureModel.addObserver(celsiusField);
    temperatureModel.addObserver(fahrenheitField);

    Scene scene = new Scene(gridPane);
    stage.setScene(scene);
    stage.show();
  }

  @Test
  public void twoTextFieldWithDifferentStrategies() {
    doubleClickOn(celsiusField);
    write("100");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);
    assertEquals("212.00", fahrenheitField.getText());

    doubleClickOn(celsiusField);
    write("5.0");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);
    assertEquals("41.00", fahrenheitField.getText());

    doubleClickOn(fahrenheitField);
    write("212");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);
    assertEquals("100.00", celsiusField.getText());
  }
}

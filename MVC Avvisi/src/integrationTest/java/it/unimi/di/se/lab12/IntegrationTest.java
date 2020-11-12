package it.unimi.di.se.lab12;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Model;
import model.NewsModel;
import org.junit.Ignore;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import view.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class IntegrationTest extends ApplicationTest {

  private FireView fireButton;
  private InputMessageView textField;
  private DisplayView bigDisplayView;
  private DisplayView smallDisplayView;

  @Override
  public void start(Stage primaryStage){
    primaryStage.setTitle("Lab08");
    GridPane gridPane = new GridPane();
    gridPane.setHgap(30);
    gridPane.setVgap(30);
    gridPane.setMinWidth(400);
    gridPane.setMinHeight(500);
    gridPane.setStyle("-fx-background-color:#fff;");
    fireButton=new FireView();
    fireButton.setMinHeight(30);
    fireButton.setMinWidth(400);
    fireButton.setStyle("-fx-background-color:#e65100; -fx-text-fill: white;");

    textField=new InputMessageView();
    textField.setMinHeight(30);
    textField.setMinWidth(400);

    bigDisplayView = new DisplayView(BigDisplayStrategy.INSTANCE);
    bigDisplayView.minHeight(300);
    bigDisplayView.minWidth(300);
    bigDisplayView.setStyle("-fx-font-size:16;");

    smallDisplayView = new DisplayView(SmallDisplayStrategy.INSTANCE);
    smallDisplayView.setMinHeight(30);
    smallDisplayView.setMinWidth(400);

    NewsModel model = new NewsModel();

    gridPane.add(fireButton,0,0);
    gridPane.add(textField,0,1);
    gridPane.add(bigDisplayView,0,2);
    gridPane.add(smallDisplayView,0,3);


    model.addObserver(bigDisplayView);
    model.addObserver(smallDisplayView);

    Controller fireController=new Controller(fireButton,model);
    Controller textFieldController=new Controller(textField,model);

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();

  }


  @Test
  public void twoTextFieldWithDifferentStrategies() {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime now = LocalDateTime.now();

    doubleClickOn(textField);
    write("falala");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);

    assertEquals(now.format(dtf) +" falala\n", bigDisplayView.getText());
    assertEquals(now.format(dtf) +" falala", smallDisplayView.getText());

    clickOn(fireButton);
    assertEquals(now.format(dtf) +" ALLARME INCENDIO: scappare a gambe levate", smallDisplayView.getText());

    doubleClickOn(textField);
    write("Speriamo funzioni lel");
    press(KeyCode.ENTER);
    release(KeyCode.ENTER);
    assertEquals(now.format(dtf) +" Speriamo funzioni lel\n"+now.format(dtf) +" ALLARME INCENDIO: scappare a gambe levate\n"+now.format(dtf) +" falala\n", bigDisplayView.getText());
    assertEquals(now.format(dtf) +" Speriamo funzioni lel", smallDisplayView.getText());


  }



}

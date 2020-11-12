package it.unimi.di.prog2.lab09.view;

import it.unimi.di.prog2.lab09.controller.TimeController;
import it.unimi.di.prog2.lab09.model.Time24;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TextFieldView extends Parent implements TimeView {

   final TextField hour = new TextField();

   final TextField minute = new TextField();
  private final Label timezone = new Label();
  private final TimeZone tz;



  public TextFieldView(TimeZone tz) {
    this.tz = tz;
    timezone.setText(tz.getLabel());
    timezone.setPrefWidth(70);
    hour.setPrefColumnCount(2);
    hour.setText("0");
    hour.setAlignment(Pos.BASELINE_RIGHT);
    minute.setText("00");
    minute.setPrefColumnCount(2);
    GridPane grid = new GridPane();
    grid.add(timezone, 0, 0);
    grid.add(hour, 1, 0);
    grid.add(new Label(" : "), 2, 0);
    grid.add(minute, 3, 0);
    this.getChildren().add(grid);
  }

  @Override
  public Time24 getGMTTime() {
    return tz.convertToGMT(new Time24(Integer.parseInt(hour.getText()), Integer.parseInt(minute.getText())));
  }

  @Override
  public void addHandler(TimeController handler) {
    hour.setOnAction(handler);
    minute.setOnAction(handler);

  }


  @Override
  public void update(Time24 state) {
    Time24 time24 = tz.convertFromGMT(state);
    String sh=String.format("%02d", time24.getHour());
    String sm=String.format("%02d", time24.getMin());
    hour.setText(sh);
    minute.setText(sm);
  }
}

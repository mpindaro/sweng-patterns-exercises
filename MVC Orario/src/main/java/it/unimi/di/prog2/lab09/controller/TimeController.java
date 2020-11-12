package it.unimi.di.prog2.lab09.controller;

import it.unimi.di.prog2.lab09.model.TimeModel;
import it.unimi.di.prog2.lab09.view.TimeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TimeController implements EventHandler<ActionEvent> {

  private final TimeModel model;
  private final TimeView view;

  public TimeController(TimeModel m, TimeView v) {
    assert m!=null:"Deve esserci un modello";
    assert v!=null:"Deve controllare una view";

    model = m;
    view = v;
    model.registerObserver(view);
    view.addHandler(this);
  }

  @Override
  public void handle(ActionEvent event) {
    this.updateModel();
  }

  private void updateModel() {
    model.setTime(view.getGMTTime());
  }

}

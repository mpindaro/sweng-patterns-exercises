package it.unimi.di.prog2.lab8.controller;

import it.unimi.di.prog2.lab8.model.Model;
import it.unimi.di.prog2.lab8.view.TemperatureView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class AbstractController implements EventHandler<ActionEvent> {

  protected Model model;
  protected TemperatureView view;


  public abstract void updateModel();
}

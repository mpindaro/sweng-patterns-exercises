package controller;

import model.Model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.InputView;


public abstract class AbstractController implements EventHandler<ActionEvent> {

    protected Model model;
    protected InputView inputView;

    public abstract void updateModel();
}

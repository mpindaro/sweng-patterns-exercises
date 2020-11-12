package it.unimi.di.prog2.lab8.controller;

import it.unimi.di.prog2.lab8.model.Model;
import it.unimi.di.prog2.lab8.view.TemperatureView;
import it.unimi.di.prog2.lab8.view.View;
import javafx.event.ActionEvent;

public class Controller extends AbstractController {


    public Controller(TemperatureView view, Model model){
        assert view!=null;
        assert model!=null;

        this.view=view;
        this.model=model;
        this.view.addListener(this);
    }

    @Override
    public void updateModel() {
        model.setTemp(view.getTempValue());
    }

    @Override
    public void handle(ActionEvent event) {
        updateModel();
    }
}

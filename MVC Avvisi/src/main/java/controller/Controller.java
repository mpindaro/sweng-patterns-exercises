package controller;

import model.Model;
import javafx.event.ActionEvent;
import view.InputView;

public class Controller extends AbstractController {

    public Controller(InputView inputView, Model model) {
        this.inputView=inputView;
        this.model=model;
        this.inputView.addListener(this);
    }

    @Override
    public void updateModel() {
        model.addNews(inputView.getNews());
    }

    @Override
    public void handle(ActionEvent event) {
        updateModel();
    }
}

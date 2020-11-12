package it.unimi.di.prog2.lab8.view;

import it.unimi.di.prog2.lab8.controller.AbstractController;
import it.unimi.di.prog2.lab8.observer.Observer;
import it.unimi.di.prog2.lab8.observer.Subject;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Locale;

public class View extends TextField implements TemperatureView, Observer<Double> {

    private final ScaleStrategy scaleStrategy;

    public View(ScaleStrategy scaleStrategy){
        this.scaleStrategy=scaleStrategy;
    }

    @Override
    public void update(Subject<Double> subject, Double state) {
        this.setText(String.format(Locale.US,"%.2f", scaleStrategy.valueFromCelsius(subject.getState())));
    }

    @Override
    public void addListener(AbstractController controller) {
        this.setOnAction(controller);
    }

    @Override
    public double getTempValue() {
        DecimalFormat df = new DecimalFormat("#.00");
        return scaleStrategy.valueToCelsius(Double.parseDouble(String.format(Locale.US,"%.2f",Double.parseDouble(this.getText()))));
    }
}

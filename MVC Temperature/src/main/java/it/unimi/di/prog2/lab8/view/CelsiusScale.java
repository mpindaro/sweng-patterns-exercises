package it.unimi.di.prog2.lab8.view;

public class CelsiusScale implements ScaleStrategy {

    final static CelsiusScale INSTANCE = new CelsiusScale();

    public  static CelsiusScale getIstance(){
        return INSTANCE;
    }

    @Override
    public double valueFromCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double valueToCelsius(double temperature) {
        return temperature;
    }
}

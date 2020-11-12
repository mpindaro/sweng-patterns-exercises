package it.unimi.di.prog2.lab8.view;

public class  FahrenheitScale implements ScaleStrategy{

    final static FahrenheitScale INSTANCE = new FahrenheitScale();

    public  static FahrenheitScale getIstance(){
        return INSTANCE;
    }

    @Override
    public double valueFromCelsius(double temperature) {
        return (temperature*1.8) + 32;
    }

    @Override
    public double valueToCelsius(double temperature) {
        return (temperature - 32)/1.8;
    }
}

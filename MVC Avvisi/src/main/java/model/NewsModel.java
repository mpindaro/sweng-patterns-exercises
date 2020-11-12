package model;

import observer.Observer;
import observer.Subject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NewsModel implements Subject<String>,Model {

    private final List<Observer<String>> observers = new ArrayList<>();
    private final List<String>  newses =  new ArrayList<>();

    @Override
    public String lastTenNews() {
        StringBuilder s = new StringBuilder();

        for (int i = newses.size() - 1; i>=0 && i >= newses.size()-10; i--)
            s.append(newses.get(i)+"\n");

        return s.toString();
    }

    @Override
    public void addNews(String news) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        StringBuilder s = new StringBuilder();

        s.append(now.format(dtf)+ " ");
        s.append(news);
        newses.add(s.toString());
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer<String> observer : observers) {
            observer.update(this, this.getState());
        }
    }

    @Override
    public void addObserver(Observer<String> obs) {
        observers.add(obs);
    }

    @Override
    public String getState() {
        return this.lastTenNews();
    }


}

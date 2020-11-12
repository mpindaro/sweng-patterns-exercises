package observer;

public interface Subject<T> {
    void notifyObservers();

    void addObserver(Observer<T> obs);

    T getState();
}

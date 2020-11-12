package observer;

public interface Observer<T> {
    void update(Subject<T> subject, T state);
}

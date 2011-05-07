package appclasses;

/**
 * @PATTERNS OBSERVER
 * @author iXeon
 */
public interface IObservable {
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyObservers();
}

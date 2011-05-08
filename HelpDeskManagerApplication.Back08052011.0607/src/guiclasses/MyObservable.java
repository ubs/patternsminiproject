package guiclasses;

/**
 *
 * @author popoola
 */
public interface MyObservable {
    public void attach(MyObserver obs);
    public void detach(MyObserver obs);
    public void updateListener();
}

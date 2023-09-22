package observer;

import java.util.Observer;

public interface MyObserver {
    void update(Observable observable);
    void subscribe(Observable observable);
    void  unsubscribe();
    int countUpdates();


}

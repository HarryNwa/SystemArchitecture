package observer;

public interface Observable {
    void add(MyObserver observer);
    void notifyObservers(MyObserver observer);
    void createContent(Update update);
    void remove(MyObserver observer);


}

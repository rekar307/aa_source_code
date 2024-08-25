package observer_pattern.practice;

public interface Subject {
    public void registerObserver(Observer ob);

    public void removeObserver(Observer ob);

    public void notifyObservers();
}



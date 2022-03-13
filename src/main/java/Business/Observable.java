package Business;

import Data.Serializator;
import Presentation.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Observable implements Serializable {

    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(String text){
        for (Observer observer : observers) {
            observer.update(text);
        }
    }

}

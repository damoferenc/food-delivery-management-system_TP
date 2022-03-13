package Business;

import java.io.Serializable;
import java.util.List;

public abstract class MenuItem implements Serializable {

    public abstract int computePrice();

    public abstract int getNumOfOrders();

    public abstract String getName();

    public abstract int getNumberOnDate(String date);

    public abstract void addDate(String date);

    public abstract  String toString();
}

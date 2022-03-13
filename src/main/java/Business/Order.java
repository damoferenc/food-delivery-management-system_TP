package Business;

import java.io.Serializable;

public class Order implements Comparable, Serializable {

    private int orderID;
    private int clientID;
    private String orderDate;
    private static int id = 1;

    public Order( int clientID, String orderDate) {
        this.orderID = id++;
        this.clientID = clientID;
        this.orderDate = orderDate;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int hashCode(){
        return this.orderID;
    }

    public boolean equals(Order otherOrder){
        if(this.orderID == otherOrder.orderID){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        return this.orderID - ((Order)o).getOrderID();
    }
}

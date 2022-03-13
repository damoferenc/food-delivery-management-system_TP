package Data;

import Business.MenuItem;

import java.io.Serializable;
import java.util.*;

public class Client extends User implements Serializable {

    private int clientID;
    private static int id = 1;
    private Set<MenuItem> list;
    private List<Integer> orderValues;

    public Client(String username, String password){
        super(username, password, "CLIENT");
        this.clientID = id ++;
        list = new HashSet<MenuItem>();
        orderValues = new ArrayList<Integer>();
    }

    public int getClientID() {
        return clientID;
    }

    public void addToList(MenuItem menuItem){
        this.list.add(menuItem);
    }

    public Set<MenuItem> getList(){
        return this.list;
    }

    public void deleteList(){
        this.list = new TreeSet<MenuItem>();
    }

    public void addToOrderValues(int price){
        orderValues.add(price);
    }

    public int getNumOfOrdersGreaterThan(int x){
        int ret = 0;
        for(int i : orderValues){
            if(i > x)
                ret ++;
        }
        return ret;
    }
}

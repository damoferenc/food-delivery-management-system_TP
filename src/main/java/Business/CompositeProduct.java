package Business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem implements Serializable {
    private List<MenuItem> itemList;
    private String name;
    private int numOfOrders;
    private List<String> dates;

    public CompositeProduct(List<MenuItem> itemList, String name) {
        this.name = name;
        this.itemList = itemList;
        this.numOfOrders = 0;
        dates = new ArrayList<String>();
    }

    public int computePrice(){
        int price = 0;
        for(MenuItem menuItem : itemList){
            price += menuItem.computePrice();
        }
        return price;
    }

    public String getName(){
        return this.name;
    }

    public void setNumOfOrders(int numOfOrders) {
        this.numOfOrders = numOfOrders;
    }

    public int getNumOfOrders() {return this.numOfOrders;}

    public int getNumberOnDate(String date){
        int ret = 0;
        for(String s : dates){
            if(s.substring(0,9).equals(date)){
                ret ++;
            }
        }
        return ret;
    }

    public void addDate(String date){
        dates.add(date);
    }

    public String toString(){
        String text = "";
        for(MenuItem menuItem : itemList){
            text += menuItem.getName();
            text += ", ";
        }
        text += "\n";
        return text;
    }
}

package Business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseProduct extends MenuItem implements Comparable, Serializable {

    private String title;
    private double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int numOfOrders;
    private List<String> dates;



    public BaseProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        this.numOfOrders = 0;
        dates = new ArrayList<String>();
    }


    public int computePrice(){
        return this.price;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getPrice() {
        return price;
    }

    public int getNumOfOrders(){return numOfOrders;}

    public int compareTo(Object o) {
        return this.title.compareTo(((BaseProduct)o).getTitle());
    }

    public void setNumOfOrders(int numOfOrders) {
        this.numOfOrders = numOfOrders;
    }

    public String getName(){
        return this.title;
    }

    public int getNumberOnDate(String date){

        int ret = 0;
        for(String s : dates){
            if(s.substring(0,10).equals(date)){
                ret ++;
            }
        }

        return ret;
    }

    public void addDate(String date){
        dates.add(date);
    }

    public String toString(){
        return this.getTitle() + " " + this.getRating()
                + " " + this.getCalories()
                + " " + this.getProtein()
                + " " + this.getFat()
                + " " + this.getSodium()
                + " " + this.getPrice() + "\n";
    }
}

package Business;

import java.util.List;
import java.util.Set;

public interface IDeliveryServiceProcessing {

    /**
     *
     * @param clientId
     * @param orderDate
     * @param items
     * @return
     * @pre clientId > 0 && orderDate.length() > 15 && items != null
     * @post The items in the hash table will be at the order key
     */
    int addOrder(int clientId, String orderDate, Set<MenuItem> items);

    /**
     *
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @pre !title.equals("") && rating >= 0 && calories >= 0 && protein >= 0 && fat >= 0 && sodium >= 0 && price >= 0
     * @post the product will be in the product list
     */
    void addProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price);

    /**
     *
     * @param list
     * @param name
     * @pre list.size() != 0 && !name.equals("")
     * @post the product will be in the product list
     */
    void addProduct(List<MenuItem> list, String name);

    /**
     *
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @pre !title.equals("") && rating >= 0 && calories >= 0 && protein >= 0 && fat >= 0 && sodium >= 0 && price >= 0
     * @post the product will edited with the new values
     */
    void editProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price);

    /**
     * @param title
     * @pre !title.equals("")
     * @post the product will be removed
     */
    void removeProduct(String title);

    /**
     *
     * @param word
     * @return
     * @pre !word.equals("")
     * @post the returned value is "" or the found products
     */
    String searchTitle(String word);

    /**
     *
     * @param rating
     * @return
     * @pre rating >= 0
     * @post the returned value is "" or the found products
     */
    String searchRating(double rating);

    /**
     *
     * @param calories
     * @return
     * @pre calories >= 0
     * @post the returned value is "" or the found products
     */
    String searchCalories(int calories);

    /**
     *
     * @param protein
     * @return
     * @pre protein >= 0
     * @post the returned value is "" or the found products
     */
    String searchProtein(int protein);

    /**
     *
     * @param fat
     * @return
     * @pre fat >= 0
     * @post the returned value is "" or the found products
     */
    String searchFat(int fat);

    /**
     *
     * @param sodium
     * @return
     * @pre sodium >= 0
     * @post the returned value is "" or the found products
     */
    String searchSodium(int sodium);

    /**
     *
     * @param price
     * @return
     * @pre price >= 0
     * @post the returned value is "" or the found products
     */
    String searchPrice(int price);

    /**
     * @post the products will be imported
     */
    void initialImport();

    /**
     *
     * @param startHour
     * @param endHour
     * @pre startHour >= 0 && endHour >= startHour
     * @post a report will be generated
     */
    void generateTimeIntervalReport(int startHour, int endHour);

    /**
     *
     * @param number
     * @pre number >= 0
     * @post a report will be generated
     */
    void generateOrderedMoreReport(int number);

    /**
     *
     * @param number
     * @param value
     * @pre number >=0 && value >= 0
     * @post a report will be generated
     */
    void generateReport3(int number, int value);

    /**
     *
     * @param date
     * @pre date.length() >= 15
     * @post a report will be generated
     */
    void generateReport4(String date);

    boolean isWellFormed();

}

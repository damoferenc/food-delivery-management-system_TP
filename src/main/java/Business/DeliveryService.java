package Business;

import Data.Administrator;
import Data.Client;
import Data.User;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {

    private Map<Order, Set<MenuItem>> map;
    private Set<MenuItem> itemList;
    private Set<Order> orders;
    private List<User> users;

   public boolean isWellFormed(){
        return itemList.size() != 0;
    }

    public DeliveryService(){
        map = new HashMap<Order, Set<MenuItem>>();
        itemList = new HashSet<MenuItem>();
        orders = new HashSet<Order>();
        users = new ArrayList<User>();
        addAdministrator("admin", "admin");
        addEmployee("emp", "emp");
    }

    public int addOrder(int clientId, String orderDate, Set<MenuItem> items){
        assert clientId > 0 && orderDate.length() > 15 && items != null;
        Order order = new Order(clientId, orderDate);
        orders.add(order);
        map.put(order, items);
        int totalPrice = 0;
        try {
            FileWriter myWriter = new FileWriter("order" + order.getOrderID() + ".txt");
                for (Iterator<MenuItem> iterator = items.iterator(); iterator.hasNext();) {
                    MenuItem s =  iterator.next();
                    if(s instanceof BaseProduct){
                        ((BaseProduct) s).setNumOfOrders( s.getNumOfOrders() + 1);
                        myWriter.write(((BaseProduct)s).getTitle());
                        myWriter.write(" ");
                        myWriter.write(String.valueOf(((BaseProduct)s).getPrice()));
                        totalPrice += ((BaseProduct)s).getPrice();
                        myWriter.write("\n");
                    }
                    else{
                        ((CompositeProduct) s).setNumOfOrders( s.getNumOfOrders() + 1);
                        myWriter.write(((CompositeProduct)s).getName());
                        myWriter.write(" ");
                        myWriter.write(String.valueOf(((CompositeProduct)s).computePrice()));
                        totalPrice += ((CompositeProduct)s).computePrice();
                        myWriter.write("\n");
                    }

                    System.out.println("Date added");
                }
                myWriter.write("Total:");
                myWriter.write(totalPrice + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        assert map.get(order).equals(items);
        assert isWellFormed();
        return totalPrice;
    }

    public void addProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price){
        assert !title.equals("") && rating >= 0 && calories >= 0 && protein >= 0 &&
                fat >= 0 && sodium >= 0 && price >= 0;
        BaseProduct baseProduct = new BaseProduct(title,rating,calories, protein,fat,sodium,price);
        itemList.add(baseProduct);
        assert itemList.contains(baseProduct);
        assert isWellFormed();
    }

    public void addProduct(List<MenuItem> list, String name){
        assert list.size() != 0 && !name.equals("");
        CompositeProduct compositeProduct = new CompositeProduct(list, name);
        itemList.add(compositeProduct);
        assert itemList.contains(compositeProduct);
        assert isWellFormed();
    }

    public void editProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price){
        assert !title.equals("") && rating >= 0 && calories >= 0 && protein >= 0 &&
                fat >= 0 && sodium >= 0 && price >= 0;
        for (Iterator<MenuItem> iterator = itemList.iterator(); iterator.hasNext();) {
            MenuItem s =  iterator.next();
            if (s instanceof BaseProduct) {
                if(((BaseProduct) s).getTitle().equals(title)){
                    iterator.remove();
                }
            }
        }
        BaseProduct baseProduct = new BaseProduct(title,rating,calories, protein,fat,sodium,price);
        itemList.add(baseProduct);
        assert itemList.contains(baseProduct);
        assert isWellFormed();
    }

    public void removeProduct(String title){
        assert !title.equals("");
        for (Iterator<MenuItem> iterator = itemList.iterator(); iterator.hasNext();) {
            MenuItem s =  iterator.next();
            if (s instanceof BaseProduct) {
                if(((BaseProduct) s).getTitle().equals(title)){
                    iterator.remove();
                }
                assert !itemList.contains(s);
            }
        }
        assert isWellFormed();
    }

    public MenuItem getProduct(String title){
        title += " ";
        for (Iterator<MenuItem> iterator = itemList.iterator(); iterator.hasNext();) {
            MenuItem s =  iterator.next();
            if (s instanceof BaseProduct) {
                if(((BaseProduct)s).getTitle().equals(title)){
                    System.out.println("FOUND");
                    return s;
                }
            }
        }
        return null;
    }

    public String getAllProducts(){
        String text = "";
        for (Iterator<MenuItem> iterator = itemList.iterator(); iterator.hasNext();) {
            MenuItem s =  iterator.next();
            if(s instanceof BaseProduct){
                text = text + ((BaseProduct) s).getTitle() + " " + ((BaseProduct) s).getRating()
                        + " " + ((BaseProduct) s).getCalories()
                        + " " + ((BaseProduct) s).getProtein()
                        + " " + ((BaseProduct) s).getFat()
                        + " " + ((BaseProduct) s).getSodium()
                        + " " + ((BaseProduct) s).getPrice() + "\n";
            }
        }
        return text;
    }

    public String searchTitle(String word){
        assert !word.equals("");
        String text = "";
        text = itemList.stream()
                        .filter(t -> t.getName().contains(word))
                        .map(MenuItem::toString)
                        .collect(Collectors.joining());
        assert text != null;
        assert isWellFormed();
        return text;
    }

    public String searchRating(double rating){
        assert rating >= 0;
        String text = "";
        text = itemList.stream()
                        .filter(t -> t instanceof BaseProduct && ((BaseProduct)t).getRating() == rating)
                        .map(MenuItem::toString)
                        .collect(Collectors.joining());
        assert text != null;
        assert isWellFormed();
        return text;
    }

    public String searchCalories(int calories){
        assert calories >= 0;
        String text = "";
        text = itemList.stream()
                        .filter(t -> t instanceof BaseProduct && ((BaseProduct)t).getCalories() == calories)
                        .map(MenuItem::toString)
                        .collect(Collectors.joining());
        assert text != null;
        assert isWellFormed();
        return text;
    }

    public String searchProtein(int protein){
        assert protein >= 0;
        String text = "";
        text = itemList.stream()
                        .filter(t -> t instanceof BaseProduct && ((BaseProduct)t).getProtein() == protein)
                        .map(MenuItem::toString)
                        .collect(Collectors.joining());
        assert text != null;
        assert isWellFormed();
        return text;
    }

    public String searchFat(int fat){
        assert fat >= 0;
        String text = "";
        text = itemList.stream()
                        .filter(t -> t instanceof BaseProduct && ((BaseProduct)t).getFat() == fat)
                        .map(MenuItem::toString)
                        .collect(Collectors.joining());
        assert text != null;
        assert isWellFormed();
        return text;
    }

    public String searchSodium(int sodium){
        assert sodium >= 0;
        String text = "";
        text = itemList.stream()
                        .filter(t -> t instanceof BaseProduct && ((BaseProduct)t).getSodium() == sodium)
                        .map(MenuItem::toString)
                        .collect(Collectors.joining());
        assert text != null;
        assert isWellFormed();
        return text;
    }

    public String searchPrice(int price){
        assert price >= 0;
        String text = "";
        text = itemList.stream()
                        .filter(t -> t.computePrice() == price)
                        .map(MenuItem::toString)
                        .collect(Collectors.joining());
        assert text != null;
        assert isWellFormed();
        return text;
    }

    public void initialImport(){
        try{
            File inputF = new File("products.csv");
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            itemList = br.lines().skip(1).map(mapToItem).collect(Collectors.toSet());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
        catch(IOException e){
            System.out.println("ERROR");
        }
        System.out.println("Initial import ended successfully\n");
        assert this.itemList.size() != 0;
        assert isWellFormed();
    }

    private transient Function<String, MenuItem> mapToItem = (line) -> {
        String[] p = line.split(",");
        MenuItem item = new BaseProduct(p[0], Double.parseDouble(p[1]), Integer.parseInt(p[2]),
                Integer.parseInt(p[3]), Integer.parseInt(p[4]), Integer.parseInt(p[5]),
                Integer.parseInt(p[6]));
        return item;
    };

    public void addClient(String username, String password){
        users.add(new Client(username, password));
    }

    public void addAdministrator(String username, String password){
        users.add(new Administrator(username, password));
    }

    public void addEmployee(String username, String password){
        users.add(new User(username, password, "EMPLOYEE"));
    }

    public User searchUser(String username, String password){
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void generateTimeIntervalReport(int startHour, int endHour){
        assert startHour >= 0 && endHour >= startHour;
        String fileName = "timeIntervalReport.txt";
        String content = "The orders between " + startHour + " and " + endHour + ":\n";
        List<Order> output =
                orders.stream()
                        .filter(t -> between(t.getOrderDate(), startHour, endHour))
                        //.map()
                        .collect(Collectors.toList());
        for(Order i : output){
            content += String.valueOf(map.get(i)) + "\n";
        }
        Data.FileWriter.writeFile(fileName, content);
        assert true;
        assert isWellFormed();
    }

    boolean between(String date, int startHour, int endHour){
        String a = "";
        a += date.charAt(11);
        a += date.charAt(12);
        int n = Integer.parseInt(a);
        if(n >= startHour && n <= endHour){
            return true;
        }
        return false;
    }

    public void generateOrderedMoreReport(int number){
        assert number >= 0;
        String fileName = "orderedMoreReport.txt";
        String content = "The products ordered more than " + number + " times:\n";
        List<String> output =
                itemList.stream()
                        .filter(t -> t.getNumOfOrders() > number)
                        .map(MenuItem::getName)
                        .collect(Collectors.toList());
        for(String i : output){
            content += i + "\n";
        }
        Data.FileWriter.writeFile(fileName, content);
        assert true;
        assert isWellFormed();
    }

    public void generateReport3(int number, int value){
        assert number >=0 && value >= 0;
        String fileName = "report3.txt";
        String content = "Clients that ordered more than " + number + " of times " +
                "and the value of the order was higher than " + value + ":\n";
        List<String> output =
                users.stream()
                        .filter(t -> t instanceof Client && ((Client) t).getNumOfOrdersGreaterThan(value) > number)
                        .map(User::getUsername)
                        .collect(Collectors.toList());
        for(String i : output){
            content += i + "\n";
        }
        Data.FileWriter.writeFile(fileName, content);
        assert true;
        assert isWellFormed();
    }

    public void generateReport4(String date){
        assert date.length() >= 15;
        String fileName = "report4.txt";
        String content = "The orders ordered at " + date + ":\n";
        List<String> output =
                itemList.stream()
                        .filter(t -> t.getNumberOnDate(date) > 0)
                        .map(t -> helpFunc(t, date) )
                        .collect(Collectors.toList());
        for(String i : output){
            content += i + "\n";
        }
        Data.FileWriter.writeFile(fileName, content);
        assert true;
        assert isWellFormed();
    }

    public String helpFunc(MenuItem item, String date){
        return item.getName() + item.getNumberOnDate(date);
    }

}

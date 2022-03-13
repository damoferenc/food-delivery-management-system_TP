package Presentation;

import Data.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {

    private Client client;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JTextArea area;

    private JButton showAllButton;

    private JTextField titleField;
    private JTextField ratingField;
    private JTextField caloriesField;
    private JTextField proteinField;
    private JTextField fatField;
    private JTextField sodiumField;
    private JTextField priceField;

    private JButton searchTitleButton;
    private JButton searchRatingButton;
    private JButton searchCaloriesButton;
    private JButton searchProteinButton;
    private JButton searchFatButton;
    private JButton searchSodiumButton;
    private JButton searchPriceButton;

    private JTextField orderField;
    private JButton addToOrderButton;
    private JButton addOrderButton;



    public ClientGUI(Client client){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        this.client = client;

        nameLabel = new JLabel("Name: " + client.getUsername());
        idLabel = new JLabel("Id: " + client.getClientID());

        area = new JTextArea("", 2000, 20);
        JScrollPane areaPane = new JScrollPane(area);

        showAllButton = new JButton("SHOW ALL");

        titleField = new JTextField(8);
        ratingField = new JTextField(8);
        caloriesField = new JTextField(8);
        proteinField = new JTextField(8);
        fatField = new JTextField(8);
        sodiumField = new JTextField(8);
        priceField = new JTextField(8);

        JPanel fieldPanel = new JPanel();
        fieldPanel.add(titleField);
        fieldPanel.add(ratingField);
        fieldPanel.add(caloriesField);
        fieldPanel.add(proteinField);
        fieldPanel.add(fatField);
        fieldPanel.add(sodiumField);
        fieldPanel.add(priceField);
        fieldPanel.setLayout(new FlowLayout());

        searchTitleButton = new JButton("SEARCH");
        searchRatingButton = new JButton("SEARCH");
        searchCaloriesButton = new JButton("SEARCH");
        searchProteinButton = new JButton("SEARCH");
        searchFatButton = new JButton("SEARCH");
        searchSodiumButton = new JButton("SEARCH");
        searchPriceButton = new JButton("SEARCH");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchTitleButton);
        buttonPanel.add(searchRatingButton);
        buttonPanel.add(searchCaloriesButton);
        buttonPanel.add(searchProteinButton);
        buttonPanel.add(searchFatButton);
        buttonPanel.add(searchSodiumButton);
        buttonPanel.add(searchPriceButton);
        buttonPanel.setLayout(new FlowLayout());

        orderField = new JTextField(20);
        addToOrderButton = new JButton("ADD");
        addOrderButton = new JButton("CREATE");

        JPanel orderPanel = new JPanel();
        orderPanel.add(orderField);
        orderPanel.add(addToOrderButton);
        orderPanel.add(addOrderButton);
        orderPanel.setLayout(new FlowLayout());

        JPanel contentPane = new JPanel();
        contentPane.add(nameLabel);
        contentPane.add(idLabel);
        contentPane.add(areaPane);
        contentPane.add(showAllButton);
        contentPane.add(fieldPanel);
        contentPane.add(buttonPanel);
        contentPane.add(orderPanel);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        this.setContentPane(contentPane);





    }

    public void addShowAllButtonListener(ActionListener al) {
        this.showAllButton.addActionListener(al);
    }

    public void addSearchTitleButtonListener(ActionListener al) {
        this.searchTitleButton.addActionListener(al);
    }

    public void addSearchRatingButtonListener(ActionListener al) { this.searchRatingButton.addActionListener(al); }

    public void addSearchCaloriesButtonListener(ActionListener al) {
        this.searchCaloriesButton.addActionListener(al);
    }

    public void addSearchProteinButtonListener(ActionListener al) {
        this.searchProteinButton.addActionListener(al);
    }

    public void addSearchFatButtonListener(ActionListener al) {
        this.searchFatButton.addActionListener(al);
    }

    public void addSearchSodiumButtonListener(ActionListener al) {
        this.searchSodiumButton.addActionListener(al);
    }

    public void addSearchPriceButtonListener(ActionListener al) {
        this.searchPriceButton.addActionListener(al);
    }



    public void setProductList(String text){
        area.setText(text);
    }

    public String getTitle(){
        return titleField.getText();
    }

    public double getRating(){
        return Double.parseDouble(ratingField.getText());
    }

    public int getCalories(){
        return Integer.parseInt(caloriesField.getText());
    }

    public int getProtein(){
        return Integer.parseInt(proteinField.getText());
    }

    public int getFat(){
        return Integer.parseInt(fatField.getText());
    }

    public int getSodium(){
        return Integer.parseInt(sodiumField.getText());
    }

    public int getPrice(){
        return Integer.parseInt(priceField.getText());
    }

    public String getOrderElement(){
        return orderField.getText();
    }

    public void addAddToOrderButtonListener(ActionListener al) {
        this.addToOrderButton.addActionListener(al);
    }

    public void addAddOrderButtonListener(ActionListener al) {
        this.addOrderButton.addActionListener(al);
    }

}

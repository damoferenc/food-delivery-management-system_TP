package Presentation;

import Data.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministratorGUI extends JFrame {

    private Administrator administrator;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JButton importButton;

    private JLabel titleLabel;
    private JLabel ratingLabel;
    private JLabel caloriesLabel;
    private JLabel proteinLabel;
    private JLabel fatLabel;
    private JLabel sodiumLabel;
    private JLabel priceLabel;

    private JTextField titleField;
    private JTextField ratingField;
    private JTextField caloriesField;
    private JTextField proteinField;
    private JTextField fatField;
    private JTextField sodiumField;
    private JTextField priceField;

    private JButton addButton;
    private JButton deleteButton;
    private JButton modifyButton;

    private JLabel compositeLabel;
    private JTextField compositeField;
    private JButton addToCompositeButton;
    private JButton addCompositeButton;

    private JButton timeIntervalReportButton;
    private JTextField startHourTextField;
    private JTextField endHourTextField;

    private JButton orderedMoreReportButton;
    private JTextField numberOfTimesField;

    private JButton clientsReportButton;
    private JTextField clientTimesField;
    private JTextField valueField;

    private JButton specifiedDayReportButton;
    private JTextField dateField;



    public AdministratorGUI(Administrator administrator){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);

        this.administrator = administrator;

        nameLabel = new JLabel("Name: " + administrator.getUsername());
        idLabel = new JLabel("Id: " + administrator.getAdminID());
        importButton = new JButton("Import");

        titleLabel = new JLabel("Title: ");
        ratingLabel = new JLabel("Rating: ");
        caloriesLabel = new JLabel("Calories: ");
        proteinLabel = new JLabel("Protein: ");
        fatLabel = new JLabel("Fat: ");
        sodiumLabel = new JLabel("Sodium: ");
        priceLabel = new JLabel("Price: ");

        titleField = new JTextField(20);
        ratingField = new JTextField(20);
        caloriesField = new JTextField(20);
        proteinField = new JTextField(20);
        fatField = new JTextField(20);
        sodiumField = new JTextField(20);
        priceField = new JTextField(20);

        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);
        titlePanel.setLayout(new FlowLayout());
        JPanel ratingPanel = new JPanel();
        ratingPanel.add(ratingLabel);
        ratingPanel.add(ratingField);
        ratingPanel.setLayout(new FlowLayout());
        JPanel caloriesPanel = new JPanel();
        caloriesPanel.add(caloriesLabel);
        caloriesPanel.add(caloriesField);
        caloriesPanel.setLayout(new FlowLayout());
        JPanel proteinPanel = new JPanel();
        proteinPanel.add(proteinLabel);
        proteinPanel.add(proteinField);
        proteinPanel.setLayout(new FlowLayout());
        JPanel fatPanel = new JPanel();
        fatPanel.add(fatLabel);
        fatPanel.add(fatField);
        fatPanel.setLayout(new FlowLayout());
        JPanel sodiumPanel = new JPanel();
        sodiumPanel.add(sodiumLabel);
        sodiumPanel.add(sodiumField);
        sodiumPanel.setLayout(new FlowLayout());
        JPanel pricePanel = new JPanel();
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);
        pricePanel.setLayout(new FlowLayout());

        addButton  = new JButton("ADD");
        deleteButton = new JButton("DELETE");
        modifyButton = new JButton("MODIFY");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(modifyButton);
        buttonPanel.setLayout(new FlowLayout());

        compositeLabel = new JLabel("Create composite products");
        compositeField = new JTextField(20);
        addCompositeButton = new JButton("CREATE");
        addToCompositeButton = new JButton("ADD");

        JPanel compositePanel = new JPanel();
        compositePanel.add(compositeLabel);
        compositePanel.add(compositeField);
        compositePanel.add(addToCompositeButton);
        compositePanel.add(addCompositeButton);
        compositePanel.setLayout(new FlowLayout());

        JPanel intervalPanel = new JPanel();
        timeIntervalReportButton = new JButton("Generate time interval report");
        startHourTextField = new JTextField(20);
        endHourTextField = new JTextField(20);
        intervalPanel.add(startHourTextField);
        intervalPanel.add(endHourTextField);
        intervalPanel.add(timeIntervalReportButton);
        intervalPanel.setLayout(new FlowLayout());

        orderedMoreReportButton = new JButton("Ordered more report");
        numberOfTimesField = new JTextField(20);
        JPanel numberOfTimesPanel = new JPanel();
        numberOfTimesPanel.add(numberOfTimesField);
        numberOfTimesPanel.add(orderedMoreReportButton);
        numberOfTimesPanel.setLayout(new FlowLayout());

        clientsReportButton = new JButton("Report");
        clientTimesField = new JTextField(20);
        valueField = new JTextField(20);
        JPanel thirdReportPanel = new JPanel();
        thirdReportPanel.add(clientTimesField);
        thirdReportPanel.add(valueField);
        thirdReportPanel.add(clientsReportButton);
        thirdReportPanel.setLayout(new FlowLayout());

        JPanel datePanel = new JPanel();
        dateField = new JTextField(20);
        specifiedDayReportButton = new JButton("Report");
        datePanel.add(dateField);
        datePanel.add(specifiedDayReportButton);
        datePanel.setLayout(new FlowLayout());

        JPanel contentPane = new JPanel();
        contentPane.add(nameLabel);
        contentPane.add(idLabel);
        contentPane.add(importButton);
        contentPane.add(titlePanel);
        contentPane.add(ratingPanel);
        contentPane.add(caloriesPanel);
        contentPane.add(proteinPanel);
        contentPane.add(fatPanel);
        contentPane.add(sodiumPanel);
        contentPane.add(pricePanel);
        contentPane.add(buttonPanel);
        contentPane.add(compositePanel);
        contentPane.add(intervalPanel);
        contentPane.add(numberOfTimesPanel);
        contentPane.add(thirdReportPanel);
        contentPane.add(datePanel);
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));

        this.setContentPane(contentPane);



    }

    public void addImportButtonListener(ActionListener al) {
        this.importButton.addActionListener(al);
    }

    public void addAddButtonListener(ActionListener al) {
        this.addButton.addActionListener(al);
    }

    public void addDeleteButtonListener(ActionListener al) {
        this.deleteButton.addActionListener(al);
    }

    public void addModifyButtonListener(ActionListener al) {
        this.modifyButton.addActionListener(al);
    }

    public String getTitle(){
        return titleField.getText();
    }

    public double getRating(){
        return Double.parseDouble(ratingField.getText());
    }

    public int getCalories(){
        return  Integer.parseInt(caloriesField.getText());
    }

    public int getProtein(){
        return  Integer.parseInt(priceField.getText());
    }

    public int getFat(){
        return  Integer.parseInt(fatField.getText());
    }

    public int getSodium(){
        return  Integer.parseInt(sodiumField.getText());
    }

    public int getPrice(){
        return  Integer.parseInt(priceField.getText());
    }

    public void addAddToCompositeButtonListener(ActionListener al) {
        this.addToCompositeButton.addActionListener(al);
    }

    public void addAddCompositeButtonListener(ActionListener al) {
        this.addCompositeButton.addActionListener(al);
    }

    public String getCompositeName(){
        return compositeField.getText();
    }

    public void addTimeIntervalReportButtonListener(ActionListener al) {
        this.timeIntervalReportButton.addActionListener(al);
    }

    public int getStartHour(){
        return Integer.parseInt(startHourTextField.getText());
    }

    public int getEndHour(){
        return Integer.parseInt(endHourTextField.getText());
    }

    public void addOrderedMoreReportButtonListener(ActionListener al) {
        this.orderedMoreReportButton.addActionListener(al);
    }

    public int getNumber(){
        return Integer.parseInt(numberOfTimesField.getText());
    }

    public void addClientsReportButtonListener(ActionListener al) {
        this.clientsReportButton.addActionListener(al);
    }

    public int getReport3Value1(){
        return Integer.parseInt(clientTimesField.getText());
    }

    public int getReport3Value2(){
        return Integer.parseInt(valueField.getText());
    }

    public String getDate(){
        return this.dateField.getText();
    }

    public void addSpecifiedDayReportButtonListener(ActionListener al) {
        this.specifiedDayReportButton.addActionListener(al);
    }

}

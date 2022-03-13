package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogInGUI extends JFrame {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton logInButton;
    private JButton registerButton;
    private JLabel errorLabel;
    private JButton serializeButton;

    public LogInGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);

        serializeButton = new JButton("SERIALIZE");

        JPanel usernamePanel = new JPanel();
        usernameField = new JTextField(20);
        usernameLabel = new JLabel("Username: ");
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        usernamePanel.setLayout(new FlowLayout());

        JPanel passwordPanel = new JPanel();
        passwordField = new JTextField(20);
        passwordLabel = new JLabel("Password: ");
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        passwordPanel.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        logInButton = new JButton("Log in");
        registerButton = new JButton("Register");
        buttonPanel.add(logInButton);
        buttonPanel.add(registerButton);
        buttonPanel.setLayout(new FlowLayout());

        JPanel errorPanel = new JPanel();
        errorLabel = new JLabel("");
        errorPanel.add(errorLabel);
        errorPanel.setLayout(new FlowLayout());

        JPanel contentPane = new JPanel();
        contentPane.add(usernamePanel);
        contentPane.add(passwordPanel);
        contentPane.add(buttonPanel);
        contentPane.add(serializeButton);
        contentPane.add(errorPanel);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));




        this.setContentPane(contentPane);



    }

    public void addLogInButtonListener(ActionListener al) {
        this.logInButton.addActionListener(al);
    }

    public void addRegisterButtonListener(ActionListener al) {
        this.registerButton.addActionListener(al);
    }

    public String getUsername(){
        return usernameField.getText();
    }

    public String getPassword(){
        return passwordField.getText();
    }

    public void setError(String mess){
        errorLabel.setText(mess);
    }

    public void addSerializeButtonListener(ActionListener al) {
        this.serializeButton.addActionListener(al);
    }
}

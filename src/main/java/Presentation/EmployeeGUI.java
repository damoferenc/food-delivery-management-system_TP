package Presentation;

import Data.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeGUI extends JFrame implements Observer{

    private User employee;
    private JLabel nameLabel;
    private List<JLabel> labels;
    private int i;

    public EmployeeGUI(User employee){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        i = 0;
        nameLabel = new JLabel(employee.getUsername());
        JPanel contentPane = new JPanel();
        contentPane.add(nameLabel);

        this.employee = employee;
        this.labels = new ArrayList<JLabel>(20);
        for(int i = 0 ; i < 20 ; i ++){
            labels.add(new JLabel(""));
            contentPane.add(labels.get(i));
        }
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
        this.setContentPane(contentPane);
    }

    public void update(String text){
        this.labels.get(i++).setText(text);
    }

}

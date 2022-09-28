package com.raf.example.view;

import com.raf.example.MainFrame;
import com.raf.example.dto.ClientCreateDto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RegisterClientView extends JPanel{
    private JPanel panel = new JPanel(null);;
    private JTextField nameField = new JTextField("");;
    private JTextField lastnameField = new JTextField("");;
    private JTextField usernameField = new JTextField("");;
    private JTextField passwordField = new JTextField("");;
    private JTextField emailField = new JTextField("");;
    private JTextField dateOfBirthField = new JTextField("");;
    private JTextField passportNumberField = new JTextField("");;
    private JTextField phoneNumberField = new JTextField("");;
    private JButton registerBtn = new JButton("Register");;
    private JButton backBtn = new JButton("Back");;

    public RegisterClientView(){
        addListeners();

        this.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(5,5,5,5));

        List<JTextField> comp = new ArrayList<>();
        comp.add(nameField);
        comp.add(lastnameField);
        comp.add(usernameField);
        comp.add(passwordField);
        comp.add(emailField);
        comp.add(dateOfBirthField);
        comp.add(phoneNumberField);
        comp.add(passportNumberField);

        List<JLabel> lb = new ArrayList<>();
        lb.add(new JLabel("Name:"));
        lb.add(new JLabel("Last name:"));
        lb.add(new JLabel("Username:"));
        lb.add(new JLabel("Password"));
        lb.add(new JLabel("Email:"));
        lb.add(new JLabel("Date of birth:"));
        lb.add(new JLabel("Phone number:"));
        lb.add(new JLabel("Passport number:"));

        panel = new JPanel(null);
        panel.setBorder(new EmptyBorder(5,5,5,5));

        for (int i = 0; i < comp.size(); i++){
            lb.get(i).setBounds(50,20+i*30,200,10);
            comp.get(i).setBounds(210,17+i*30,120,20);
            panel.add(comp.get(i));
            panel.add(lb.get(i));
        }
        
        JPanel optionsPanel = new JPanel(new FlowLayout());
        optionsPanel.add(backBtn);
        optionsPanel.add(registerBtn);
        
        this.add(optionsPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
    }

    private void addListeners() {
        registerBtn.addActionListener( e -> {
            try {
                SimpleDateFormat dateFormatter=new SimpleDateFormat("dd-MM-yyyy");
                System.out.println(dateOfBirthField.getText());
                Date date = Date.valueOf(dateOfBirthField.getText());
                MainFrame.getInstance().getUserServiceRestClient()
                        .registerClient(new ClientCreateDto(usernameField.getText(), passwordField.getText() ,nameField.getText(), lastnameField.getText(),
                                                              emailField.getText(), phoneNumberField.getText(), date, passportNumberField.getText()));

            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while registering client!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } );

        backBtn.addActionListener(e ->{
            try{
                MainFrame.getInstance().showMainView();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });
    }
}

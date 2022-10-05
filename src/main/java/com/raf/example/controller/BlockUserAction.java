package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockUserAction implements ActionListener {
    private JTextArea ta;

    public BlockUserAction(JTextArea ta) {
        this.ta = ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getUserService().blockUser(str[0].split(":")[1].trim());
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error while blocking user!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package com.raf.example.controller;

import com.raf.example.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnblockUserAction implements ActionListener {
    private JTextArea ta;

    public UnblockUserAction(JTextArea ta) {
        this.ta = ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getUserService().unblockUser(str[0].split(":")[1].trim());
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,
                    "Error while unblocking user! \n" +
                            "Possible causes: \n" +
                            "- user does not exist.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.UserDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetUserByIdAction implements ActionListener {
    private JTextArea ta;

    public GetUserByIdAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            UserDto userDto = MainFrame.getInstance().getUserService().getUserById( str[0].split(":")[1].trim() );
            JOptionPane.showMessageDialog(null, userDto);
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null,
                    "Error while getting user by id! \n" +
                            "Possible causes: \n" +
                            "- user does not exist.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

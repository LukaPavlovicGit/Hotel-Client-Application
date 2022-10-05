package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RankDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRankAction implements ActionListener {
    private JTextArea ta;

    public AddRankAction(JTextArea ta) {
        this.ta = ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getUserService().addRank(new RankDto(
                                                                str[0].split(":")[1].trim(),
                                                                Integer.valueOf(str[1].split(":")[1].trim())) );
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,
                    "Error while adding rank! \n" +
                            "Possible causes: \n" +
                            "-Some rank name is already in use.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

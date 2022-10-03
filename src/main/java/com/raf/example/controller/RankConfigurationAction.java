package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RankDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankConfigurationAction implements ActionListener {
    private JTextArea ta;

    public RankConfigurationAction(JTextArea ta) {
        this.ta = ta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String[] str = ta.getText().split("[\n]");
            MainFrame.getInstance().getUserService()
                    .rankConfiguration(new RankDto(
                            Long.valueOf(str[0].split(":")[1].trim()),
                            str[1].split(":")[1].trim(),
                            Integer.valueOf(str[2].split(":")[1].trim())) );
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
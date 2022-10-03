package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.RankDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddAllRanksAction implements ActionListener {

    private JTextArea ta;

    public AddAllRanksAction(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String text = ta.getText().split("[+]")[1];
            String[] str = text.split("#");
            List<RankDto> list = new ArrayList<>();
            for(String line : str) {
                list.add(new RankDto(
                        str[0].split(":")[1].trim(),
                        Integer.valueOf(str[1].split(":")[1].trim())) );
            }
            MainFrame.getInstance().getUserService().addAllRanks(list);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}

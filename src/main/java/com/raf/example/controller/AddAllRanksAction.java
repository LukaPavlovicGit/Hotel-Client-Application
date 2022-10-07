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
            // na server strani implementirati da kada se dodaju rankovi, da se te izmene odraze na user-e!!!!
            String text = ta.getText().trim().split("[+]")[1];
            String[] str = text.split("[#]");
            List<RankDto> list = new ArrayList<>();
            for(String line : str) {
                String decomposeLine[] = line.split(",");
                list.add(new RankDto(
                        decomposeLine[0].split(":")[1].trim(),
                        Integer.valueOf(decomposeLine[1].split(":")[1].trim())) );
            }
            MainFrame.getInstance().getUserService().addAllRanks(list);
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Error while adding all ranks! \n" +
                    "Possible causes: \n" +
                    "-Some rank name is already in use.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

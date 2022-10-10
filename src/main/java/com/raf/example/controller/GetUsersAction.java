package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.UserDto;
import com.raf.example.dto.UsersListDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetUsersAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            UsersListDto list = MainFrame.getInstance().getUserService().getAllUsers();
            List<UserDto> content = list.getContent();

            Object [][] data = new Object[50][50];
            int k=0;
            for (UserDto dto : content)
                data[k++] = new Object[]{dto.getId(), dto.getUsername(), dto.getRoleName()};

            String[] header = {"User id", "Username", "Role"};
            JTable table = new JTable(data,header);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(table.getTableHeader(), BorderLayout.NORTH);
            panel.add(table, BorderLayout.CENTER);

            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(700, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(panel);
            jDialog.setVisible(true);

        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while getting all users!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
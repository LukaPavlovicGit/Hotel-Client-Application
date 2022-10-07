package com.raf.example.controller;

import com.raf.example.MainFrame;
import com.raf.example.dto.UserDto;
import com.raf.example.dto.UsersListDto;
import com.raf.example.model.UserTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GetUsersAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            UserTableModel tableModel = new UserTableModel();
            UsersListDto list = MainFrame.getInstance().getUserService().getAllUsers();
            List<UserDto> content = list.getContent();

            for (UserDto dto : content)
                tableModel.addRow(new Object[]{dto.getId(), dto.getUsername(), dto.getRoleName()});

            JTable table;
            table = new JTable(tableModel);
            JDialog jDialog = new JDialog();
            jDialog.setSize(new Dimension(1500, 500));
            jDialog.setLocationRelativeTo(MainFrame.getInstance());
            jDialog.add(table);
            jDialog.setVisible(true);

        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while getting all users!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
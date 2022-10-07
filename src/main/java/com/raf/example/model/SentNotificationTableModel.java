package com.raf.example.model;


import com.raf.example.dto.NotificationTypeDto;
import com.raf.example.dto.SentNotificationDto;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class SentNotificationTableModel extends DefaultTableModel {

    private List<SentNotificationDto> content = new ArrayList<>();

    public SentNotificationTableModel() throws IllegalAccessError{
        super(new String[]{"Email", "Text", "Type", "Date"}, 0);
    }

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        SentNotificationDto dto = new SentNotificationDto();
        dto.setEmail(String.valueOf(row[0]));
        dto.setText(String.valueOf(row[1]));
        dto.setType(String.valueOf(row[2]));
        dto.setType(String.valueOf(row[3]));
        content.add(dto);
    }

    public List<SentNotificationDto> getContent() {
        return content;
    }

    public void setContent(List<SentNotificationDto> content) {
        this.content = content;
    }
}

package com.raf.example.model;


import com.raf.example.dto.SentEmailDto;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class NotificationTableModel extends DefaultTableModel {

    private List<SentEmailDto> content = new ArrayList<>();

    public NotificationTableModel() throws IllegalAccessError{
        super(new String[]{"Email", "Text", "Type", "Date"}, 0);
    }

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        SentEmailDto dto = new SentEmailDto();
        dto.setEmail(String.valueOf(row[0]));
        dto.setText(String.valueOf(row[1]));
        dto.setType(String.valueOf(row[2]));
        dto.setType(String.valueOf(row[3]));
        content.add(dto);
    }

    public List<SentEmailDto> getContent() {
        return content;
    }

    public void setContent(List<SentEmailDto> content) {
        this.content = content;
    }
}

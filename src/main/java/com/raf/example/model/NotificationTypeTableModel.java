package com.raf.example.model;

import com.raf.example.dto.NotificationTypeDto;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class NotificationTypeTableModel extends DefaultTableModel {
    List<NotificationTypeDto> content = new ArrayList<>();

    public NotificationTypeTableModel() throws IllegalAccessError{
        super(new String[]{"Id", "Type", "Text"}, 0);
    }

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        NotificationTypeDto dto = new NotificationTypeDto();
        dto.setId(Long.valueOf(String.valueOf(row[0])));
        dto.setType(String.valueOf(row[1]));
        dto.setText(String.valueOf(row[2]));
        content.add(dto);
    }

    public List<NotificationTypeDto> getContent() {
        return content;
    }

    public void setContent(List<NotificationTypeDto> content) {
        this.content = content;
    }
}

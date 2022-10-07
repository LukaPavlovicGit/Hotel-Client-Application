package com.raf.example.model;

import com.raf.example.dto.RoomDto;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class RoomTableModel extends DefaultTableModel {
    private List<RoomDto> content = new ArrayList<>();

    public RoomTableModel() throws IllegalAccessError{
        super(new String[]{"Hotel id", "room number", "Type"}, 0);
    }

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        RoomDto dto = new RoomDto();
        dto.setHotelId(Long.valueOf(String.valueOf(row[0])));
        dto.setRoomNumber(Integer.valueOf(String.valueOf(row[1])));
        dto.setTypeName(String.valueOf(row[2]));
        content.add(dto);
    }

    public void refresh(){
        fireTableDataChanged();
    }

    public List<RoomDto> getContent() {
        return content;
    }

    public void setContent(List<RoomDto> content) {
        this.content = content;
    }
}

package com.raf.example.model;

import com.raf.example.dto.HotelDto;
import com.raf.example.dto.RoomDto;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class HotelTableModel extends DefaultTableModel {
    private List<HotelDto> content = new ArrayList<>();

    public HotelTableModel() throws IllegalAccessError{
        super(new String[]{"city", "name", "description"}, 0);
    }

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        HotelDto dto = new HotelDto();
        dto.setCity(String.valueOf(row[0]));
        dto.setName(String.valueOf(row[1]));
        dto.setDescription(String.valueOf(row[2]));
        content.add(dto);
    }

    public void refresh(){
        fireTableDataChanged();
    }

    public List<HotelDto> getContent() {
        return content;
    }

    public void setContent(List<HotelDto> content) {
        this.content = content;
    }
}

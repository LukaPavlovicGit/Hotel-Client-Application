package com.raf.example.model;

import com.raf.example.dto.ReservationDto;
import com.raf.example.dto.RoomDto;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationModelTable extends DefaultTableModel {
    private List<ReservationDto> content = new ArrayList<>();

    public ReservationModelTable() throws IllegalAccessError{
        super(new String[]{"client email", "start", "end", "price"}, 0);
    }

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        ReservationDto dto = new ReservationDto();
        dto.setClientEmail(String.valueOf(row[0]));
        dto.setStartDate(LocalDate.parse(String.valueOf(row[1])));
        dto.setEndDate(LocalDate.parse(String.valueOf(row[2])));
        dto.setPrice(Double.valueOf(String.valueOf(row[3])));
        content.add(dto);
    }

    public void refresh(){
        fireTableDataChanged();
    }

    public List<ReservationDto> getContent() {
        return content;
    }

    public void setContent(List<ReservationDto> content) {
        this.content = content;
    }
}

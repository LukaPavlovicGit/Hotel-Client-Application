package com.raf.example.model;

import com.raf.example.dto.ReviewDto;
import com.raf.example.dto.RoomDto;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ReviewTableModel extends DefaultTableModel {
    private List<ReviewDto> content = new ArrayList<>();

    public ReviewTableModel() throws IllegalAccessError{
        super(new String[]{"Reservation id", "Client id", "Rating", "Comment"}, 0);
    }
    /*

    private Long reservationId;
    private Long clientId;
    private Integer rating;
    private String comment;

     */

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        ReviewDto dto = new ReviewDto();
        dto.setReservationId(Long.valueOf(String.valueOf(row[0])));
        dto.setClientId(Long.valueOf(String.valueOf(row[1])));
        dto.setRating(Integer.valueOf(String.valueOf(row[2])));
        dto.setComment(String.valueOf(row[3]));
        content.add(dto);
    }

    public void refresh(){
        fireTableDataChanged();
    }

    public List<ReviewDto> getContent() {
        return content;
    }

    public void setContent(List<ReviewDto> content) {
        this.content = content;
    }
}
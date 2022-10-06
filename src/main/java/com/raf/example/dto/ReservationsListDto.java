package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class ReservationsListDto {
    private List<ReservationDto> content = new ArrayList<>();

    public ReservationsListDto() {
    }

    public ReservationsListDto(List<ReservationDto> content) {
        this.content = content;
    }

    public List<ReservationDto> getContent() {
        return content;
    }

    public void setContent(List<ReservationDto> content) {
        this.content = content;
    }
}

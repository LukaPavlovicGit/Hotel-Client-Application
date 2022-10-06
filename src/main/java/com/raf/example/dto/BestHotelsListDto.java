package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class BestHotelsListDto {
    private List<HotelDto> content = new ArrayList<>();

    public BestHotelsListDto() {
    }

    public BestHotelsListDto(List<HotelDto> content) {
        this.content = content;
    }

    public List<HotelDto> getContent() {
        return content;
    }

    public void setContent(List<HotelDto> content) {
        this.content = content;
    }
}

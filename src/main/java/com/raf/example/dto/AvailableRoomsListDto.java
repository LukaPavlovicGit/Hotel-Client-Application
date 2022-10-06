package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class AvailableRoomsListDto {
    private List<RoomDto> content = new ArrayList<>();

    public AvailableRoomsListDto() {
    }

    public AvailableRoomsListDto(List<RoomDto> content) {
        this.content = content;
    }

    public List<RoomDto> getContent() {
        return content;
    }

    public void setContent(List<RoomDto> content) {
        this.content = content;
    }
}

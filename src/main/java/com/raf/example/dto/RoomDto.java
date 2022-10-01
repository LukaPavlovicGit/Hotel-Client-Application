package com.raf.example.dto;

public class RoomDto {
    private Long hotelId;
    private Integer roomNumber;
    private String type;

    public RoomDto() {
    }

    public RoomDto(Integer roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
    }

    public RoomDto(Long hotelId, Integer roomNumber, String type, Double pricePerDay) {
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.type = type;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

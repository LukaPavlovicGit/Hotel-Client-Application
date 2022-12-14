package com.raf.example.dto;

public class RoomTypeDto {
    private String typeName;
    private Double pricePerDay;
    private Long hotelId;

    public RoomTypeDto() {
    }

    public RoomTypeDto(String typeName, Double pricePerDay, Long hotelId) {
        this.typeName = typeName;
        this.pricePerDay = pricePerDay;
        this.hotelId = hotelId;
    }

    public RoomTypeDto(String typeName, Double pricePerDay) {
        this.typeName = typeName;
        this.pricePerDay = pricePerDay;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}

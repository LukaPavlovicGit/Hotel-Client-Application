package com.raf.example.dto;

public class HotelDto {

    private String city;
    private String name;
    private String description;

    public HotelDto() {
    }

    public HotelDto(String city, String name, String description) {
        this.city = city;
        this.name = name;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

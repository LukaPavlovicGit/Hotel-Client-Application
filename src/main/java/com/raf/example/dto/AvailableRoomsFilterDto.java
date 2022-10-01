package com.raf.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AvailableRoomsFilterDto {
    private String hotelName;
    private String city;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String sort;

    public AvailableRoomsFilterDto(){

    }

    public AvailableRoomsFilterDto(String hotelName, String city, LocalDate startDate, LocalDate endDate, String sort) {
        this.hotelName = hotelName;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sort = sort;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}

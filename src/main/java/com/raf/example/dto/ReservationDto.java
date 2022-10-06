package com.raf.example.dto;

import java.time.LocalDate;

public class ReservationDto {

    private Long roomId;
    private Long clientId;
    private String clientEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;

    private Long hotelId;

    public ReservationDto(){

    }

    public ReservationDto(Long roomId, Long clientId, String clientEmail, LocalDate startDate, LocalDate endDate) {
        this.roomId = roomId;
        this.clientId = clientId;
        this.clientEmail = clientEmail;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ReservationDto(Long roomId, Long clientId, String clientEmail, LocalDate startDate, LocalDate endDate, Long hotelId) {
        this.roomId = roomId;
        this.clientId = clientId;
        this.clientEmail = clientEmail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotelId = hotelId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}
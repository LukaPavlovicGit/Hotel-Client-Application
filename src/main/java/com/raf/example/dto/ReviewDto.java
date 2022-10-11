package com.raf.example.dto;

public class ReviewDto {
    private Long reviewId;
    private Long reservationId;
    private Long clientId;
    private Integer rating;
    private String comment;

    public ReviewDto(){}

    public ReviewDto(Long reviewId, Integer rating, String comment) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
    }

    public ReviewDto(Long reservationId, Long clientId, Integer rating, String comment) {
        this.reservationId = reservationId;
        this.clientId = clientId;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}



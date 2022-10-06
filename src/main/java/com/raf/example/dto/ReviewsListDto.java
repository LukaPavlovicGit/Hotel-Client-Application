package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class ReviewsListDto {
    private List<ReviewDto> content = new ArrayList<>();

    public ReviewsListDto() {
    }

    public ReviewsListDto(List<ReviewDto> content) {
        this.content = content;
    }

    public List<ReviewDto> getContent() {
        return content;
    }

    public void setContent(List<ReviewDto> content) {
        this.content = content;
    }
}

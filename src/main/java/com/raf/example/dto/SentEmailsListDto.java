package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class SentEmailsListDto {
    private List<SentEmailDto> content = new ArrayList<>();

    public SentEmailsListDto() {
    }

    public SentEmailsListDto(List<SentEmailDto> content) {
        this.content = content;
    }

    public List<SentEmailDto> getContent() {
        return content;
    }

    public void setContent(List<SentEmailDto> content) {
        this.content = content;
    }
}

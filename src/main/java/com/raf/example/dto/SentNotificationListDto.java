package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class SentNotificationListDto {
    private List<SentNotificationDto> content = new ArrayList<>();

    public SentNotificationListDto() {
    }

    public SentNotificationListDto(List<SentNotificationDto> content) {
        this.content = content;
    }

    public List<SentNotificationDto> getContent() {
        return content;
    }

    public void setContent(List<SentNotificationDto> content) {
        this.content = content;
    }
}

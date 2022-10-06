package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class NotificationsListDto {
    private List<EmailNotificationDto> content = new ArrayList<>();

    public NotificationsListDto() {
    }

    public NotificationsListDto(List<EmailNotificationDto> content) {
        this.content = content;
    }

    public List<EmailNotificationDto> getContent() {
        return content;
    }

    public void setContent(List<EmailNotificationDto> content) {
        this.content = content;
    }
}

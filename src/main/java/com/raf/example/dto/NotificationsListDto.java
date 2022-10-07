package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class NotificationsListDto {
    private List<NotificationTypeDto> content = new ArrayList<>();

    public NotificationsListDto() {
    }

    public NotificationsListDto(List<NotificationTypeDto> content) {
        this.content = content;
    }

    public List<NotificationTypeDto> getContent() {
        return content;
    }

    public void setContent(List<NotificationTypeDto> content) {
        this.content = content;
    }
}

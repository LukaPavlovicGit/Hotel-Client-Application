package com.raf.example.dto;

public class NotificationTypeDto {
    private Long id;
    private String type;
    private String text;

    public NotificationTypeDto(Long id, String type, String text) {
        this.id = id;
        this.type = type;
        this.text = text;
    }

    public NotificationTypeDto(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public NotificationTypeDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EmailNotificationDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

package com.raf.example.dto;

public class EmailNotificationDto {
    private Long id;
    private String type;
    private String text;

    public EmailNotificationDto(Long id, String type, String text) {
        this.id = id;
        this.type = type;
        this.text = text;
    }

    public EmailNotificationDto(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public EmailNotificationDto() {
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
}

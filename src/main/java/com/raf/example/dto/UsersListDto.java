package com.raf.example.dto;

import java.util.ArrayList;
import java.util.List;

public class UsersListDto {
    private List<UserDto> content = new ArrayList<>();

    public UsersListDto() {
    }

    public UsersListDto(List<UserDto> content) {
        this.content = content;
    }

    public List<UserDto> getContent() {
        return content;
    }

    public void setContent(List<UserDto> content) {
        this.content = content;
    }
}

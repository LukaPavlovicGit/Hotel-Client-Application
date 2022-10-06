package com.raf.example.model;

import com.raf.example.dto.UserDto;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class UserTableModel extends DefaultTableModel {

    private List<UserDto> content = new ArrayList<>();

    public UserTableModel() throws IllegalAccessError{
        super(new String[]{"Id", "Username", "Role"}, 0);
    }

    @Override
    public void addRow(Object[] row){
        super.addRow(row);
        UserDto dto = new UserDto();
        dto.setId(Long.valueOf(String.valueOf(row[0])));
        dto.setUsername(String.valueOf(row[1]));
        dto.setRoleName(String.valueOf(row[2]));
        content.add(dto);
    }

    public void refresh(){
        fireTableDataChanged();
    }

    public List<UserDto> getContent() {
        return content;
    }

    public void setContent(List<UserDto> content) {
        this.content = content;
    }
}
package com.raf.example.dto;

public class RankDto {
    private Long id;
    private String name;
    private Integer reach;

    public RankDto() {
    }

    public RankDto(String name, Integer reach) {
        this.name = name;
        this.reach = reach;
    }

    public RankDto(Long id, String name, Integer reach) {
        this.id = id;
        this.name = name;
        this.reach = reach;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReach() {
        return reach;
    }

    public void setReach(Integer reach) {
        this.reach = reach;
    }

    @Override
    public String toString() {
        return "RankDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reach=" + reach +
                '}';
    }
}

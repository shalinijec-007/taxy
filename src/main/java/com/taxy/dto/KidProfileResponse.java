package com.taxy.dto;

public class KidProfileResponse {

    private Long id;
    private String name;
    private Integer age;
    private Integer totalXp;
    private Integer level;

    public KidProfileResponse(
            Long id,
            String name,
            Integer age,
            Integer totalXp,
            Integer level) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.totalXp = totalXp;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getTotalXp() {
        return totalXp;
    }

    public Integer getLevel() {
        return level;
    }
}
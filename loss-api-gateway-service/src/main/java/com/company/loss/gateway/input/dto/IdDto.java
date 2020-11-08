package com.company.loss.gateway.input.dto;

public class IdDto {

    private String id;

    public IdDto() {
    }

    public IdDto(String id) {
        this.id = id;
    }

    public String value() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdDto{" +
                "id='" + id + '\'' +
                '}';
    }
}

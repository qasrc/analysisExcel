package com.realcan;

public enum ManufacturerEnum {

    ID("厂商"), NAME1("名称1"), NAME2("名称2");

    private String description;

    ManufacturerEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

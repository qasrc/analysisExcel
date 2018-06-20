package com.realcan;

public enum CellType {

    CODE("物料"), DESC("物料描述"), BRAND("产品品牌"), COMMONNAME("通用名称"), PRODUCT_LINE("产品线"),
    SPECIFICATION("规格"), MANUFACTURER("生产厂商"), GAUGE_TICHET("计量单"), STORE("贮藏"), QUALITY_STANDARD("质量标准"),
    MAJOR_FUNCTION("功能主治"), VALIDITY("有效期(月)"), APPROVAL_NUMBER("批准文号"), ROUGH_WEIGHT("毛重"), SIZE("大小");

    private String description;

    CellType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

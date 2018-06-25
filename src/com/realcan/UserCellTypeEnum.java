package com.realcan;

public enum UserCellTypeEnum {
    COMPANYID("公司"), SOLD_TO_ID("soldto客户"), HOSPITAL_NAME("名称1"), LINKMAN("联系人"), MOBILE_NUM("手机号"),
    SHIP_TO_ID("shipto客户"), POSTALCODE("邮政编码"), COUNTRY("国"), DESC("描述"), STREET_NAME("街道"), DESC1("描述1"),
    SHIP_TO_LINKMAN("shipto联系人"), NAME2("名称 2"), MOBILE_NUM1("电话1");

    private String description;

    UserCellTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

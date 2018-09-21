package com.realcan;

public enum UserCellTypeEnum {
    COMPANYID("公司"), SOLD_TO_ID("soldto客户"), HOSPITAL_NAME("名称1"), LINKMAN("登录人姓名"), MOBILE_NUM("登录人电话"), DEFAULT("默认地址"),
    SHIP_TO_ID("shipto客户"), POSTALCODE("邮政编码"), COUNTRY("国"), DESC("描述"), STREET_NAME("街道"), DESC1("描述1"), RG("Rg"),
    SHIP_TO_LINKMAN("shipto联系人"), NAME2("名称 2"), MOBILE_NUM1("电话1"), SALESMAN_ID("业务员ID"), SALESMAN_NAME("业务员姓名"), DIVISION("组");

    private String description;

    UserCellTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

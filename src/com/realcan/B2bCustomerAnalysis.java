package com.realcan;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B2bCustomerAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {

        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>>>>> RealcanB2BCustomer start");
        Set<String> tmp = new HashSet<>();
        for (Map<String, String> userMapDatum : ExcelUtil.userMapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.LINKMAN.getDescription()))
                    .append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.MOBILE_NUM.getDescription()))
                    .append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.MOBILE_NUM.getDescription()))
                    .append(";;")
                    .append(userMapDatum.get(UserCellTypeEnum.LINKMAN.getDescription()))
                    .append(";rev;")
                    .append(userMapDatum.get(UserCellTypeEnum.SOLD_TO_ID.getDescription()))
                    .append(",b2bcustomergroup;")
                    .append(userMapDatum.get(UserCellTypeEnum.SOLD_TO_ID.getDescription()))
                    .append(";");
            tmp.add(stringBuilder.toString());

        }
        result.addAll(tmp);
        result.add(">>>>>>>>>>>>>>>>>>>>> RealcanB2BCustomer end");
        result.add("------------------------user-groups.impex end------------------------");
    }


    static class B2bCustomer {
        private String linkMan;
        private String mobileNum;
        private String soldToId;

        public String getLinkMan() {
            return linkMan;
        }

        public void setLinkMan(String linkMan) {
            this.linkMan = linkMan;
        }

        public String getMobileNum() {
            return mobileNum;
        }

        public void setMobileNum(String mobileNum) {
            this.mobileNum = mobileNum;
        }

        public String getSoldToId() {
            return soldToId;
        }

        public void setSoldToId(String soldToId) {
            this.soldToId = soldToId;
        }
    }
}

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
        result.add("--------------------customer start--------------");
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
        result.add("---------------------customer end-----------------");
    }
}

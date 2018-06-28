package com.realcan;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B2bUnitAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        result.add("");
        result.add("");
        result.add("!!!上方数据无用，仅作加载数据使用");
        for (int i = 0; i < 3; i++) {
            result.add("");
        }
        result.add("--------------------user-groups.impex start--------------");
        result.add(">>>>>>>>>>>>>>>> B2BUnit start");
        Set<String> tmp = new HashSet<>();
        for (Map<String, String> userMapDatum : ExcelUtil.userMapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.HOSPITAL_NAME.getDescription()))
                    .append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.SOLD_TO_ID.getDescription()))
                    .append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.HOSPITAL_NAME.getDescription()))
                    .append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.HOSPITAL_NAME.getDescription()))
                    .append(";")
                    .append(userMapDatum.get(UserCellTypeEnum.COMPANYID.getDescription()))
                    .append("-30-17_sellerOrg")
                    .append(";;RealcanAddrID_")
                    .append(userMapDatum.get(UserCellTypeEnum.SHIP_TO_ID.getDescription()))
                    .append(";RealcanID_")
                    .append(userMapDatum.get(UserCellTypeEnum.SOLD_TO_ID.getDescription()))
                    .append(";acctmgoral;;;;");
            tmp.add(stringBuilder.toString());
        }
        result.addAll(tmp);
        result.add(">>>>>>>>>>>>>>>>>>> B2BUnit end");
    }
}

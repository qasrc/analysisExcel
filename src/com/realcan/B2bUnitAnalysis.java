package com.realcan;

import com.microsoft.schemas.office.office.STInsetMode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B2bUnitAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("--------------------unitanalysis start--------------");
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
                    .append("-30-17")
                    .append(";;RealcanAddrID_")
                    .append(userMapDatum.get(UserCellTypeEnum.SHIP_TO_ID.getDescription()))
                    .append(";RealcanID_")
                    .append(userMapDatum.get(UserCellTypeEnum.SOLD_TO_ID.getDescription()))
                    .append(";acctmgoral;;;;");
            tmp.add(stringBuilder.toString());
        }
        result.addAll(tmp);
        result.add("-------------------unitanalysis end-------------------");
    }
}

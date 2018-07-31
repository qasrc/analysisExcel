package com.realcan;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B2bAddressAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {

        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>>>> RealcanB2BAddress start");
        Set<String> tmp = new HashSet<>();
        for (Map<String, String> userMapDatum : ExcelUtil.userMapData) {
            StringBuilder stringBuilder = new StringBuilder();
            String soldToId = userMapDatum.get(UserCellTypeEnum.SOLD_TO_ID.getDescription());
            if (StringUtils.isNotBlank(soldToId)) {
                String shipToId = userMapDatum.get(UserCellTypeEnum.SHIP_TO_ID.getDescription());
                stringBuilder.append(";")
                        .append(shipToId)
                        .append(";")
                        .append(userMapDatum.get(UserCellTypeEnum.STREET_NAME.getDescription()))
                        .append(";")
                        .append(userMapDatum.get(UserCellTypeEnum.POSTALCODE.getDescription()))
                        .append(";")
                        .append(userMapDatum.get(UserCellTypeEnum.DESC1.getDescription()))
                        .append(";")
                        .append(userMapDatum.get(UserCellTypeEnum.COUNTRY.getDescription()))
                        .append(";TRUE;TRUE;TRUE;TRUE;;")
                        .append(userMapDatum.get(UserCellTypeEnum.NAME2.getDescription()))
                        .append(";;rev;RealcanAddrID_")
                        .append(shipToId)
                        .append(";RealcanID_")
                        .append(soldToId)
                        .append(";")
                        .append(userMapDatum.get(UserCellTypeEnum.COMPANYID.getDescription()))
                        .append("-30-17_sellerOrg")
                        .append(";CN-37;")
                        .append(userMapDatum.get(UserCellTypeEnum.MOBILE_NUM1.getDescription()))
                        .append(";RealcanID_")
                        .append(soldToId);
                if (soldToId.equals(shipToId)) {
                    stringBuilder.append(";true");
                } else {
                    stringBuilder.append(";false");
                }


                tmp.add(stringBuilder.toString());
            }

        }
        result.addAll(tmp);
        result.add(">>>>>>>>>>>>>>>>>>> RealcanB2BAddress end");
    }
}

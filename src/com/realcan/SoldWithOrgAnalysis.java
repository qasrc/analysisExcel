package com.realcan;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangzhan
 * @date 2018/8/1 下午6:19
 */
public class SoldWithOrgAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>>soldwithorg start");
        Set<String> orgs = new HashSet<>();
        ExcelUtil.userMapData.forEach(ele -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(ele.get(UserCellTypeEnum.COMPANYID.getDescription()))
                    .append("-30-11_sellerOrg;")
                    .append(ele.get(UserCellTypeEnum.SOLD_TO_ID.getDescription()));
            orgs.add(stringBuilder.toString());
        });
        result.addAll(orgs);
        result.add(">>>>>>>>>>>>>>>>>soldwithorg end");
    }
}

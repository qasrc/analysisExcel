package com.realcan;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangzhan
 * @date 2018/8/1 下午6:21
 */
public class UserB2BUnitAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>b2bunit start");
        Set<String> soldToIds = new HashSet<>();
        ExcelUtil.userMapData.forEach(ele -> soldToIds.add(ele.get(UserCellTypeEnum.SOLD_TO_ID.getDescription())));
        soldToIds.forEach(ele -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(ele)
                    .append(";false");
            result.add(stringBuilder.toString());
        });

        result.add(">>>>>>>>>>>>>>b2bunit end");
    }
}

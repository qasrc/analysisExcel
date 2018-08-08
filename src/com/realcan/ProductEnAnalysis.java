package com.realcan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzhan
 * @date 2018/8/6 下午2:13
 */
public class ProductEnAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>>product_en.impex start");

        Map<String, String> productMap = new HashMap<>();
        ExcelUtil.mapData.forEach(ele -> {
            String code = ele.get(CellTypeEnum.CODE.getDescription());
            String desc = ele.get(CellTypeEnum.DESC.getDescription());
            productMap.put(code, desc);
        });
        productMap.keySet().forEach(key -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";");
            stringBuilder.append(key);
            stringBuilder.append(";;");
            stringBuilder.append(productMap.get(key));
            stringBuilder.append(";");
            stringBuilder.append(productMap.get(key));
            stringBuilder.append(";");
            stringBuilder.append(productMap.get(key));
            result.add(stringBuilder.toString());
        });


        result.add(">>>>>>>>>>>>>>>>>product_en.impex end");
    }
}

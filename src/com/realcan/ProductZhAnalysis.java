package com.realcan;

import java.util.HashMap;
import java.util.Map;

public class ProductZhAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("-----------------products-zh.impex   start-----------------");
        Map<String, String> productMap = new HashMap<>();
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            String code = mapDatum.get(CellTypeEnum.CODE.getDescription());
            String desc = mapDatum.get(CellTypeEnum.DESC.getDescription());
            productMap.put(code, desc);
        }

        productMap.keySet().forEach(key -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(key)
                    .append(";          ;")
                    .append(productMap.get(key))
                    .append(";")
                    .append(productMap.get(key))
                    .append("<br>;")
                    .append(productMap.get(key));
            result.add(stringBuilder.toString());
        });
        result.add("---------------products-zh.impex    end------------------");
    }
}

package com.realcan;

import java.util.Map;

public class ProductZhAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("-----------------products-zh.impex   start-----------------");
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append(";          ;")
                    .append(mapDatum.get(CellTypeEnum.DESC.getDescription()))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.DESC.getDescription()))
                    .append("<br>;")
                    .append(mapDatum.get(CellTypeEnum.DESC.getDescription()));
            result.add(stringBuilder.toString());
        }
        result.add("---------------products-zh.impex    end------------------");
    }
}

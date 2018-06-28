package com.realcan;

import java.util.Map;

public class PriceExtendAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("------------------------products-price.impex  start-----------------");
        for (Map<String, String> datum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(datum.get(CellTypeEnum.CODE.getDescription()))
                    .append("_")
                    .append(datum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17")
                    .append(";B2B_DEFAULT_PRICE_GROUP 1 ")
                    .append(ExcelUtil.getUnitNameByCode(datum.get(CellTypeEnum.GAUGE_TICHET.getDescription())))
                    .append(" = ")
                    .append(ExcelUtil.randomNum())
                    .append(" CNY Y;");
            result.add(stringBuilder.toString());
        }
        result.add("-----------------------products-price.impex  end------------------");
    }
}

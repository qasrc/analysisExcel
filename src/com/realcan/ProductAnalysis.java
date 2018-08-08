package com.realcan;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {
        if (!ExcelUtil.flag) {
            ExcelUtil.initSheetData(filePath, sheetName);
        }
        List<Map<String, String>> data = ExcelUtil.mapData;
        result.add("---------------------------products.impex  start-----------------------------");
        result.add("");
        result.add(">>>>>>>>>>>>>>>>>ConsumableProduct start");


        Set<String> codes = new HashSet<>();


        for (Map<String, String> datum : data) {
            StringBuilder stringBuilder = new StringBuilder();
            String code = datum.get(CellTypeEnum.CODE.getDescription());
            if (!codes.contains(code)) {
                codes.add(code);
                stringBuilder.append(";")
                        .append(datum.get(CellTypeEnum.CODE.getDescription()))
                        .append(";")
                        .append("5200")
                        .append(",")
                        .append(datum.get(CellTypeEnum.COMMONNAME.getDescription()))
                        .append(",")
                        .append(datum.get(CellTypeEnum.BRAND.getDescription()))
                        .append(",")
                        .append("B2B_Seller")
                        .append(";")
                        .append(ExcelUtil.getSupplierNameById(datum.get(CellTypeEnum.MANUFACTURER.getDescription())))
                        .append(";")
                        .append(datum.get(CellTypeEnum.MANUFACTURER.getDescription()))
                        .append(";;;")
                        .append(ExcelUtil.unitMap.get(datum.get(CellTypeEnum.GAUGE_TICHET.getDescription())));
                result.add(stringBuilder.toString());
            }

        }
        result.add(">>>>>>>>>>>>>>>>>ConsumableProduct end");

    }
}

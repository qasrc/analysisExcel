package com.realcan;

import java.util.List;
import java.util.Map;

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
        for (Map<String, String> datum : data) {
            StringBuilder stringBuilder = new StringBuilder();
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
        result.add(">>>>>>>>>>>>>>>>>ConsumableProduct end");

    }
}

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
                    .append(";")
                    .append(ExcelUtil.getSupplierNameById(datum.get(CellTypeEnum.MANUFACTURER.getDescription())))
                    .append(";")
                    .append(datum.get(CellTypeEnum.MANUFACTURER.getDescription()))
                    .append(";;");
            result.add(stringBuilder.toString());
        }
        result.add("---------------------------products.impex  end---------------------------------");

    }
}

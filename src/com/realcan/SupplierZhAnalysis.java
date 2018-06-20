package com.realcan;

import java.util.Map;

public class SupplierZhAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {

        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("-------------------suppliers-zh.impex    start-----------------");
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";;")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";");
            result.add(stringBuilder.toString());
        }
        for (int i = 0; i < 3; i++) {
            result.add("");
        }
        for (String brand : ExcelUtil.getAllBrands()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";;")
                    .append(brand)
                    .append(";")
                    .append(brand)
                    .append(";")
                    .append(brand)
                    .append(";");
            result.add(stringBuilder.toString());
        }
        result.add("------------------suppliers-zh.impex    end-------------------");
    }
}

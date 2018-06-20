package com.realcan;

import java.util.Map;

public class SuppliersAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {

        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("---------------suppliers.impex   start------------------");
        result.add("++++++++++++++categories");
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";;")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";commonnames");
            result.add(stringBuilder.toString());

        }
        result.add("++++++++++++++++brands");
        for (String brand : ExcelUtil.getAllBrands()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";;")
                    .append(brand)
                    .append(";brands");
            result.add(stringBuilder.toString());
        }
        result.add("------------------suppliers.impex    end-----------------");
    }
}

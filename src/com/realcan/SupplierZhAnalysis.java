package com.realcan;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SupplierZhAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {

        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("-------------------suppliers-zh.impex    start-----------------");
        //使用set集合去除重复数据
        Set<String> strings = new HashSet<>();
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";;")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";");
            strings.add(stringBuilder.toString());
        }
        result.addAll(strings);
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

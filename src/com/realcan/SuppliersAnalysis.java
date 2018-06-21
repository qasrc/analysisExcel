package com.realcan;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SuppliersAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {

        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("---------------suppliers.impex   start------------------");
        result.add("++++++++++++++categories");
        //使用set集合去除重复数据
        Set<String> tmp = new HashSet<>();
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";;")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";commonnames");
            tmp.add(stringBuilder.toString());

        }
        result.addAll(tmp);
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

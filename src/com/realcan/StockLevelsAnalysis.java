package com.realcan;

import java.util.*;

public class StockLevelsAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        List<String> productTemp = new ArrayList<>();
        result.add("------------------------products-stocklevels.impex    start---------------------");
        result.add(">>>>>>>>>>>>>>>>>>> stocklevel start");

        Set<String> productCode = new HashSet<>();

        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            productCode.add(mapDatum.get(CellTypeEnum.CODE.getDescription()));
        }

        for (String code : productCode) {
            StringBuilder stocklevels = new StringBuilder();
            StringBuilder product = new StringBuilder();
            stocklevels.append(";")
                    .append(code)
                    .append(";pw_warehouse_e;")
                    .append(ExcelUtil.randomNum())
                    .append(";notSpecified");
            product.append(";")
                    .append(code)
                    .append(";")
                    .append(code)
                    .append(":pw_warehouse_e");
            result.add(stocklevels.toString());
            productTemp.add(product.toString());
        }

        result.add(">>>>>>>>>>>>>>>>> stocklevel end");
        result.add("");
        result.add(">>>>>>>>>>>>>>>>>>>> product start");
        result.addAll(productTemp);
        result.add(">>>>>>>>>>>>>>>>>>> product end");
        result.add("--------------------------products-stocklevels.impex    end----------------------");
    }
}

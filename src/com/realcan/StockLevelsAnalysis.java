package com.realcan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StockLevelsAnalysis extends ExcelAnalysis {
    @Override
    public void analysis(String filePath,String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        List<String> productTemp = new ArrayList<>();
        result.add("------------------------products-stocklevels.impex    start---------------------");
        result.add(">>>>>>>>>>>>>>>>>>> stocklevel start");
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stocklevels = new StringBuilder();
            StringBuilder product = new StringBuilder();
            stocklevels.append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append(";pw_warehouse_e;")
                    .append(ExcelUtil.randomNum())
                    .append(";notSpecified");
            product.append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
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

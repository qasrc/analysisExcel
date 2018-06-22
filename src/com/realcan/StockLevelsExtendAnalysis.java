package com.realcan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StockLevelsExtendAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        List<String> productTemp = new ArrayList<>();
        result.add("------------------------products-stocklevels.impex  extend  start---------------------");
        result.add("++++++++++++++++++++stocklevel");
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stocklevels = new StringBuilder();
            StringBuilder product = new StringBuilder();
            stocklevels.append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append("_")
                    .append(mapDatum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17")
                    .append(";pw_warehouse_e;")
                    .append(ExcelUtil.randomNum())
                    .append(";notSpecified");
            product.append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append("_")
                    .append(mapDatum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17")
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append("_")
                    .append(mapDatum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17")
                    .append(":pw_warehouse_e");
            result.add(stocklevels.toString());
            productTemp.add(product.toString());
        }

        result.add("+++++++++++++++++++product");
        result.addAll(productTemp);
        result.add("--------------------------products-stocklevels.impex  extend  end----------------------");

    }
}

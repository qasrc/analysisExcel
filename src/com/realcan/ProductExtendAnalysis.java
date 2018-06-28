package com.realcan;

import java.util.Map;

public class ProductExtendAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 3; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>> RealcanB2BSellerProduct start");
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append("_")
                    .append(mapDatum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17;")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append(";;")
                    .append(mapDatum.get(CellTypeEnum.DESC.getDescription()))
                    .append(";;")
                    .append(mapDatum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17;")
                    .append("approved");
            result.add(stringBuilder.toString());

        }
        result.add(">>>>>>>>>>>>>>>>>> RealcanB2BSellerProduct end");
        result.add("-----------------------products.impex   end-----------------------");
    }
}

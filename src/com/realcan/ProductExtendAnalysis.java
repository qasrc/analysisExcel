package com.realcan;

import java.util.Map;

public class ProductExtendAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 3; i++) {
            result.add("");
        }
        result.add("----------------------GenericVariantProduct    start----------------");
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append("_")
                    .append(mapDatum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17;")
                    .append(mapDatum.get(CellTypeEnum.CODE.getDescription()))
                    .append(";;")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";;")
                    .append(mapDatum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-17;")
                    .append("approved;")
                    .append(mapDatum.get(CellTypeEnum.DESC.getDescription()));
            result.add(stringBuilder.toString());

        }
        result.add("--------------------GenericVariantProduct  end-----------------");
    }
}

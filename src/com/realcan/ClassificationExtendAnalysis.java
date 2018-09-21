package com.realcan;

import java.util.List;
import java.util.Map;

public class ClassificationExtendAnalysis extends ExcelAnalysis {

    @Override
    void analysis(String filePath, String sheetName) {
        List<Map<String, String>> data = ExcelUtil.mapData;
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("----------------------classification.impex  extend  start------------------");
        for (Map<String, String> datum : data) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(datum.get(CellTypeEnum.CODE.getDescription()))
                    .append("_")
                    .append(datum.get(CellTypeEnum.COMPANY.getDescription()))
                    .append("-30-12")
                    .append(";")
                    .append(datum.get(CellTypeEnum.VALIDITY.getDescription()))
                    .append(";")
                    .append(datum.get(CellTypeEnum.MAJOR_FUNCTION.getDescription()))
                    .append(";<ignore>;<ignore>;")
                    .append(datum.get(CellTypeEnum.STORE.getDescription()))
                    .append(";")
                    .append(datum.get(CellTypeEnum.APPROVAL_NUMBER.getDescription()))
                    .append(";")
                    .append(datum.get(CellTypeEnum.COMMONNAME.getDescription()))
                    .append(";")
                    .append(ExcelUtil.getUnitNameByCode(datum.get(CellTypeEnum.GAUGE_TICHET.getDescription())))
                    .append(";")
                    .append(ExcelUtil.getSupplierNameById(datum.get(CellTypeEnum.MANUFACTURER.getDescription())))
                    .append(";")
                    .append(datum.get(CellTypeEnum.SPECIFICATION.getDescription()))
                    .append(";")
                    .append(datum.get(CellTypeEnum.QUALITY_STANDARD.getDescription()))
                    .append(";")
                    .append(datum.get(CellTypeEnum.ROUGH_WEIGHT.getDescription()))
                    .append(";")
                    .append(datum.get(CellTypeEnum.SIZE.getDescription()))
                    .append(";");
            result.add(stringBuilder.toString());
        }
        result.add("-----------------------classification.impex  extend  end-------------------");
    }
}

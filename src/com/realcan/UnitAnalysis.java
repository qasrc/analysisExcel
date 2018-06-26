package com.realcan;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnitAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("--------------------unit start--------------");
        Set<String> tmp = new HashSet<>();
        for (Map<String, String> mapDatum : ExcelUtil.mapData) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(ExcelUtil.getUnitNameByCode(mapDatum.get(CellTypeEnum.GAUGE_TICHET.getDescription())))
                    .append(";")
                    .append(ExcelUtil.getUnitNameByCode(mapDatum.get(CellTypeEnum.GAUGE_TICHET.getDescription())))
                    .append(";")
                    .append(mapDatum.get(CellTypeEnum.GAUGE_TICHET.getDescription()));
            tmp.add(stringBuilder.toString());
        }
        result.addAll(tmp);
        result.add("-------------------unit  end-----------------");
    }
}

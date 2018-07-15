package com.realcan;

import java.util.HashSet;
import java.util.Set;

public class UnitAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>unit start");
        Set<String> tmp = new HashSet<>();
        for (String s : ExcelUtil.unitMap.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(ExcelUtil.unitMap.get(s))
                    .append(";")
                    .append(ExcelUtil.unitMap.get(s))
                    .append(";")
                    .append(s)
                    .append(";")
                    .append(s);
            tmp.add(stringBuilder.toString());
        }
        result.addAll(tmp);
        result.add(">>>>>>>>>>>>>>unit  end");
    }
}

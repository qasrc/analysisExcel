package com.realcan;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 4; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>> manufacturer start");
        List<String> temp = new ArrayList<>();
        for (String s : ExcelUtil.manufacturerMap.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(s)
                    .append(";")
                    .append(ExcelUtil.manufacturerMap.get(s));
            temp.add(stringBuilder.toString());
        }
        result.addAll(temp);
        result.add(">>>>>>>>>>>>>> manufacture end");
    }
}

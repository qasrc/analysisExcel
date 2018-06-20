package com.realcan;

import java.util.ArrayList;
import java.util.List;

public abstract class ExcelAnalysis {

    static List<String> result = new ArrayList<>(100);

    /**
     * 解析文件
     * @param filePath excel文件路径
     */
    abstract void analysis(String filePath, String sheetName);

}

package com.realcan;

/**
 * @author zhangzhan
 * @date 2018/8/6 下午2:13
 */
public class ProductEnAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>>product_en.impex start");
        ExcelUtil.mapData.forEach(ele -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";");
            stringBuilder.append(ele.get(CellTypeEnum.CODE.getDescription()));
            stringBuilder.append(";;");
            stringBuilder.append(ele.get(CellTypeEnum.DESC.getDescription()));
            stringBuilder.append(";");
            stringBuilder.append(ele.get(CellTypeEnum.DESC.getDescription()));
            stringBuilder.append(";");
            stringBuilder.append(ele.get(CellTypeEnum.DESC.getDescription()));
            result.add(stringBuilder.toString());
        });

        result.add(">>>>>>>>>>>>>>>>>product_en.impex end");
    }
}

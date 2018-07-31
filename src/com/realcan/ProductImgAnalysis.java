package com.realcan;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhangzhan
 * @date 2018/7/28 下午5:26
 */
public class ProductImgAnalysis extends ExcelAnalysis {
    private Map<String, String> imageUUid = new HashMap<>();

    @Override
    void analysis(String filePath, String sheetName) {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add("---------------------products-media.impex  start-------------");
        result.add(">>>>>>>>>>>>>> Media start");
        addMediaListToResult("30Wx30H");
        emptyContentToResult();
        addMediaListToResult("65Wx65H");
        emptyContentToResult();
        addMediaListToResult("96Wx96H");
        emptyContentToResult();
        addMediaListToResult("300Wx300H");
        emptyContentToResult();
        addMediaListToResult("515Wx515H");
        emptyContentToResult();
        addMediaListToResult("1200Wx1200H");
        result.add(">>>>>>>>>>>>>> Media end");
        emptyContentToResult();
        result.add(">>>>>>>>>>>>>>MediaContainer start");
        ExcelUtil.allImags.forEach(ele -> {
            String uuid = UUID.randomUUID().toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";");
            stringBuilder.append(uuid);
            stringBuilder.append(";/30Wx30H/");
            stringBuilder.append(ele);
            stringBuilder.append(",/65Wx65H/");
            stringBuilder.append(ele);
            stringBuilder.append(",/96Wx96H/");
            stringBuilder.append(ele);
            stringBuilder.append(",/300Wx300H/");
            stringBuilder.append(ele);
            stringBuilder.append(",/515Wx515H/");
            stringBuilder.append(ele);
            stringBuilder.append(",/1200Wx1200H/");
            stringBuilder.append(ele);
            imageUUid.put(ele, uuid);
            result.add(stringBuilder.toString());
        });
        result.add(">>>>>>>>>>>>>>MediaContainer end");
        emptyContentToResult();
        result.add(">>>>>>>>>>>>>>product start");
        ExcelUtil.productImagMap.keySet().forEach(key -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";");
            stringBuilder.append(key);
            stringBuilder.append(";/300Wx300H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(";/96Wx96H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(";/1200Wx1200H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(";/515Wx515H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(",/65Wx65H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(",/30Wx30H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(";/30Wx30H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(";/96Wx96H/");
            stringBuilder.append(ExcelUtil.productImagMap.get(key).toArray()[0]);
            stringBuilder.append(";");
            stringBuilder.append(getGalleryImgs(key));
            result.add(stringBuilder.toString());
        });
        result.add(">>>>>>>>>>>>>>>>>product end");

    }

    private String getGalleryImgs(String productCode) {
        StringBuilder stringBuilder = new StringBuilder();
        ExcelUtil.productImagMap.get(productCode).forEach(ele -> {
            stringBuilder.append(imageUUid.get(ele));
            stringBuilder.append(",");
        });
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 2);
    }

    private void emptyContentToResult() {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
    }


    private void addMediaListToResult(String pageSize) {
        ExcelUtil.allImags.forEach(ele -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";");
            stringBuilder.append(pageSize);
            stringBuilder.append(";/");
            stringBuilder.append(pageSize);
            stringBuilder.append("/");
            stringBuilder.append(ele);
            stringBuilder.append(";$siteResource/realcanImages/");
            stringBuilder.append(pageSize);
            stringBuilder.append("/");
            stringBuilder.append(ele);
            stringBuilder.append(";;;realcanImages");
            result.add(stringBuilder.toString());
        });

    }
}

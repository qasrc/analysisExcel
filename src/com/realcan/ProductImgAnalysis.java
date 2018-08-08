package com.realcan;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author zhangzhan
 * @date 2018/7/28 下午5:26
 */
public class ProductImgAnalysis extends ExcelAnalysis {
    private Map<String, String> imageUUid = new HashMap<>();
    private static int i = 84;

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
            String imageName = ele.substring(ele.lastIndexOf(",") + 1);
            String uuid = String.valueOf(i++);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";");
            stringBuilder.append(uuid);
            stringBuilder.append(";/30Wx30H/");
            stringBuilder.append(imageName);
            stringBuilder.append(",/65Wx65H/");
            stringBuilder.append(imageName);
            stringBuilder.append(",/96Wx96H/");
            stringBuilder.append(imageName);
            stringBuilder.append(",/300Wx300H/");
            stringBuilder.append(imageName);
            stringBuilder.append(",/515Wx515H/");
            stringBuilder.append(imageName);
            stringBuilder.append(",/1200Wx1200H/");
            stringBuilder.append(imageName);
            imageUUid.put(imageName, uuid);
            result.add(stringBuilder.toString());
        });
        result.add(">>>>>>>>>>>>>>MediaContainer end");
        emptyContentToResult();
        result.add(">>>>>>>>>>>>>>product start");
        ExcelUtil.productImagMap.keySet().forEach(key -> {
            String productCode = getCodeByKey(key);
            if (StringUtils.isNotBlank(productCode)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(";");
                stringBuilder.append(productCode);
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
            }

        });
        result.add(">>>>>>>>>>>>>>>>>product end");

    }


    private String getCodeByKey(String key) {
        String productstr = "000000000000078195," +
                "000000000000078199," +
                "000000000000078201," +
                "000000000000078205," +
                "000000000000078207," +
                "000000000000078210," +
                "000000000000078214," +
                "000000000000078220," +
                "000000000000078227," +
                "000000000000078228," +
                "000000000000078229," +
                "000000000000078239," +
                "000000000000078242," +
                "000000000000078252," +
                "000000000000078254," +
                "000000000000078258," +
                "000000000000086339," +
                "000000000000086340," +
                "000000000000086341," +
                "000000000000086374," +
                "000000000000086378," +
                "000000000000086379," +
                "000000000000086380," +
                "000000000000086381," +
                "000000000000086382," +
                "000000000000086385," +
                "000000000000086386," +
                "000000000000086387," +
                "000000000000086388," +
                "000000000000086389," +
                "000000000000086390," +
                "000000000000086391," +
                "000000000000086392," +
                "000000000000086396," +
                "000000000000086397," +
                "000000000000086398," +
                "000000000000086399," +
                "000000000000086400," +
                "000000000000086401," +
                "000000000000086402," +
                "000000000000086403," +
                "000000000000086404," +
                "000000000000086405," +
                "000000000000086407," +
                "000000000000086409," +
                "000000000000086412," +
                "000000000000086413," +
                "000000000000086614," +
                "000000000000086616," +
                "000000000000086799," +
                "000000000000086920," +
                "000000000000096662," +
                "000000000000096705," +
                "000000000000096707," +
                "000000000000096710," +
                "000000000000096713," +
                "000000000000096715," +
                "000000000000097308," +
                "000000000000097309," +
                "000000000000097316," +
                "000000000000097323," +
                "000000000000107438," +
                "000000000000108117," +
                "000000000000140749," +
                "000000000000140750," +
                "000000000000142821," +
                "000000000000142827," +
                "000000000000142831," +
                "000000000000142854," +
                "000000000000142860," +
                "000000000000142875," +
                "000000000000144748," +
                "000000000000144749," +
                "000000000000144751," +
                "000000000000144771," +
                "000000000000144772," +
                "000000000000144773," +
                "000000000000144774," +
                "000000000000144776," +
                "000000000000153524," +
                "000000000000153525," +
                "000000000000160948," +
                "000000000000167549," +
                "000000000000193683," +
                "000000000000193948," +
                "000000000000193950," +
                "000000000000195910," +
                "000000000000078195," +
                "000000000000078199," +
                "000000000000078201," +
                "000000000000078205," +
                "000000000000078207," +
                "000000000000078210," +
                "000000000000078214," +
                "000000000000078220," +
                "000000000000078227," +
                "000000000000078228," +
                "000000000000078229," +
                "000000000000078239," +
                "000000000000078242," +
                "000000000000078252," +
                "000000000000078254," +
                "000000000000078258," +
                "000000000000086339," +
                "000000000000086340," +
                "000000000000086341," +
                "000000000000086354," +
                "000000000000086371," +
                "000000000000086374," +
                "000000000000086378," +
                "000000000000086379," +
                "000000000000086380," +
                "000000000000086381," +
                "000000000000086382," +
                "000000000000086385," +
                "000000000000086386," +
                "000000000000086387," +
                "000000000000086388," +
                "000000000000086389," +
                "000000000000086390," +
                "000000000000086391," +
                "000000000000086392," +
                "000000000000086395," +
                "000000000000086396," +
                "000000000000086397," +
                "000000000000086398," +
                "000000000000086399," +
                "000000000000086400," +
                "000000000000086401," +
                "000000000000086402," +
                "000000000000086403," +
                "000000000000086404," +
                "000000000000086405," +
                "000000000000086406," +
                "000000000000086407," +
                "000000000000086408," +
                "000000000000086409," +
                "000000000000086412," +
                "000000000000086413," +
                "000000000000086414," +
                "000000000000086415," +
                "000000000000086614," +
                "000000000000086616," +
                "000000000000086617," +
                "000000000000086799," +
                "000000000000086920," +
                "000000000000087566," +
                "000000000000096662," +
                "000000000000096673," +
                "000000000000096675," +
                "000000000000096677," +
                "000000000000096700," +
                "000000000000096705," +
                "000000000000096707," +
                "000000000000096710," +
                "000000000000096713," +
                "000000000000096715," +
                "000000000000097301," +
                "000000000000097308," +
                "000000000000097309," +
                "000000000000097316," +
                "000000000000097323," +
                "000000000000107438," +
                "000000000000108117," +
                "000000000000108474," +
                "000000000000140748," +
                "000000000000140749," +
                "000000000000140750," +
                "000000000000142821," +
                "000000000000142827," +
                "000000000000142831," +
                "000000000000142843," +
                "000000000000142846," +
                "000000000000142854," +
                "000000000000142859," +
                "000000000000142860," +
                "000000000000142861," +
                "000000000000142875," +
                "000000000000144748," +
                "000000000000144749," +
                "000000000000144750," +
                "000000000000144751," +
                "000000000000144771," +
                "000000000000144772," +
                "000000000000144773," +
                "000000000000144774," +
                "000000000000144776," +
                "000000000000145942," +
                "000000000000153507," +
                "000000000000153524," +
                "000000000000153525," +
                "000000000000160948," +
                "000000000000167549," +
                "000000000000174393," +
                "000000000000193683," +
                "000000000000193684," +
                "000000000000193685," +
                "000000000000193714," +
                "000000000000193944," +
                "000000000000193945," +
                "000000000000193947," +
                "000000000000193948," +
                "000000000000193949," +
                "000000000000193950," +
                "000000000000193952," +
                "000000000000193955," +
                "000000000000193956," +
                "000000000000193958," +
                "000000000000193967," +
                "000000000000193969," +
                "000000000000193976," +
                "000000000000193977," +
                "000000000000195910";
        String[] products = productstr.split(",");
        Set<String> productSet = new HashSet<>();
        productSet.addAll(Arrays.asList(products));
        for (String productCode : productSet) {
            String splitCode = getStr(productCode);
            if (key.equals(splitCode)) {
                return productCode;
            }
        }
        return null;
    }

    /**
     * remove 0 of start
     *
     * @param string
     * @return
     */
    private String getStr(String string) {
        char[] chars = string.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if (aChar != '0') {
                break;
            } else {
                index++;
            }
        }
        return string.substring(index);
    }


    private String getGalleryImgs(String productCode) {
        StringBuilder stringBuilder = new StringBuilder();
        ExcelUtil.productImagMap.get(productCode).forEach(ele -> {
            String imageName = ele.substring(ele.lastIndexOf(",") + 1);
            stringBuilder.append(imageUUid.get(imageName));
            stringBuilder.append(",");
        });
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }

    private void emptyContentToResult() {
        for (int i = 0; i < 5; i++) {
            result.add("");
        }
    }




    private void addMediaListToResult(String pageSize) {
        ExcelUtil.allImags.forEach(ele -> {
            String imageName = ele.substring(ele.lastIndexOf(",") + 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";");
            stringBuilder.append(pageSize);
            stringBuilder.append(";/");
            stringBuilder.append(pageSize);
            stringBuilder.append("/");
            stringBuilder.append(imageName);
            stringBuilder.append(";$siteResource/realcanImages/");
            stringBuilder.append(pageSize);
            stringBuilder.append("/");
            stringBuilder.append(imageName);
            stringBuilder.append(";;;realcanImages");
            result.add(stringBuilder.toString());
        });

    }
}

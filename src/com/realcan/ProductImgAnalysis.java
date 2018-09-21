package com.realcan;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author zhangzhan
 * @date 2018/7/28 下午5:26
 */
public class ProductImgAnalysis extends ExcelAnalysis {
    private Map<String, String> imageUUid = new HashMap<>();
    private static int i = 200;

    @Override
    void analysis(String filePath, String sheetName) {
        for (int j = 0; j < 5; j++) {
            result.add("");
        }
        result.add("------------------------product-media.impex start-----------------------");
        result.add(">>>>>>>>>>>>>>>>>>>>media start");
        ExcelUtil.allImags.forEach(ele -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";;");
            //String code = ele.substring(0, ele.lastIndexOf("."));
            stringBuilder.append(ele);
            stringBuilder.append(";$siteResource/realcanImages/");
            stringBuilder.append(ele);
            stringBuilder.append(".jpg;;;");
            result.add(stringBuilder.toString());
        });
        result.add(">>>>>>>>>>>>>>>>>>>media end");

        result.add(">>>>>>>>>>>>>>>>>>>MediaContainer start");
        ExcelUtil.allImags.forEach(ele -> {
            StringBuilder stringBuilder = new StringBuilder();
            String uid = String.valueOf(i++);
            stringBuilder.append(";");
            stringBuilder.append(uid);
            stringBuilder.append(";");
            //String code = ele.substring(0, ele.lastIndexOf("."));
            stringBuilder.append(ele);
            stringBuilder.append(";;");
            imageUUid.put(ele, uid);
            result.add(stringBuilder.toString());
        });
        result.add(">>>>>>>>>>>>>>>>>>>MediaContainer end");

        result.add(">>>>>>>>>>>>>>>>>>>product start");
        Set<String> products = new HashSet<>();
        ExcelUtil.mapData.forEach(ele -> {
            if (StringUtils.isNotBlank(ele.get(CellTypeEnum.CODE.getDescription()))) {
                products.add(ele.get(CellTypeEnum.CODE.getDescription()));
            }
        });
        products.forEach(key -> {
            if (StringUtils.isNotBlank(key)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(";");
                stringBuilder.append(key);
                stringBuilder.append(";");
                Set<String> result1 = ExcelUtil.productImagMap.get(getStr(key));
                if (result1 != null && result1.size() > 0) {
                    stringBuilder.append(result1.toArray()[0]);
                    stringBuilder.append(";;;;;;");
                    stringBuilder.append(getGalleryImgs(getStr(key)));
                    result.add(stringBuilder.toString());
                }
            }
        });
        result.add(">>>>>>>>>>>>>>>>>>product end");

        diff();


    }

    void diff() {
        System.out.println("无图片的商品");
        Set<String> codes = new HashSet<>();
        Set<String> images = new HashSet<>();
        ExcelUtil.mapData.forEach(ele -> {
            String code = ele.get(CellTypeEnum.CODE.getDescription());
            if (StringUtils.isNotBlank(code)) {
                codes.add(getStr(code));

            }
        });
        ExcelUtil.productImagMap.keySet().forEach(images::add);
        codes.removeAll(images);
        System.out.println(codes);
    }


    void analysis1(String filePath, String sheetName) {
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
            String productCode = "";
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


    public String getCodeByKey(String key) {

        Set<String> codes = new HashSet<>();
        ExcelUtil.mapData.forEach(ele -> {
            codes.add(ele.get(CellTypeEnum.CODE.getDescription()));
        });

        for (String productCode : codes) {
            String splitCode = getStr(productCode);
            if (key.equals(splitCode)) {
                return productCode;
            }
        }
        return null;
    }

    public static void test(Set<String> stringset) {
        List<String> strings = new ArrayList<>();
        strings.add("86341,86340,86339.png");
        strings.add("86388,86389,86392,142875,86393,86615,86396,142876,86400.png");
        strings.add("86395,193956,193955,193684,193685.png");
        strings.add("86410,86412,86413,86414,86415,86617,144773,86404,86616,86405,86406,87566,86407,86403,86408.png");
        strings.add("87529,78245,78257,96715,96664,96662,78242,78252,78227,107438,78210,78212,78200,87546,96681,97322,78263,78214,96680,78202,78249,96715,142843,78228,78197,78214,142828,151292,78214,96658,78225,142847,153506.png");
        strings.add("142831,140748,140749,140750,142859,142854,142860,142861,145942.png");
        strings.add("144748,144771,193950,193952,193949,193948,144772,144749,144750,193945,193944,193947.png");
        strings.add("144770,144747,144769,144767.png");
        strings.add("144774,144751,144776.png");
        strings.add("152264,152266,820299,820300,78192.png");
        strings.add("160948,153524,153525.png");
        strings.add("193712,193969,193978,193683,193713,193977,193965,193967.png");
        strings.add("195910,86374,86377,86378,86379,86380,170399,86374,86383,86799,86385,86386,87681.png");
        strings.forEach(ele -> {
            String[] productCodes = ele.split(",");
            for (String productCode : productCodes) {
                productCode = productCode.trim();
                if (!productCode.endsWith(".png")) {
                    stringset.add(productCode);
                } else {
                    String subProductCode = productCode.substring(0, productCode.indexOf("."));
                    stringset.add(subProductCode);
                }
            }
        });
    }


    public static void analysis(Map<String, String> productImageMap) {
        List<String> strings = new ArrayList<>();
        strings.add("86341,86340,86339.png");
        strings.add("86388,86389,86392,142875,86393,86615,86396,142876,86400.png");
        strings.add("86395,193956,193955,193684,193685.png");
        strings.add("86410,86412,86413,86414,86415,86617,144773,86404,86616,86405,86406,87566,86407,86403,86408.png");
        strings.add("87529,78245,78257,96715,96664,96662,78242,78252,78227,107438,78210,78212,78200,87546,96681,97322,78263,78214,96680,78202,78249,96715,142843,78228,78197,78214,142828,151292,78214,96658,78225,142847,153506.png");
        strings.add("142831,140748,140749,140750,142859,142854,142860,142861,145942.png");
        strings.add("144748,144771,193950,193952,193949,193948,144772,144749,144750,193945,193944,193947.png");
        strings.add("144770,144747,144769,144767.png");
        strings.add("144774,144751,144776.png");
        strings.add("152264,152266,820299,820300,78192.png");
        strings.add("160948,153524,153525.png");
        strings.add("193712,193969,193978,193683,193713,193977,193965,193967.png");
        strings.add("195910,86374,86377,86378,86379,86380,170399,86374,86383,86799,86385,86386,87681.png");

        strings.forEach(ele -> {
            String[] productCodes = ele.split(",");
            for (String productCode : productCodes) {
                productCode = productCode.trim();
                if (!productCode.endsWith(".png")) {
                    productImageMap.put(productCode, ele);
                } else {
                    String subProductCode = productCode.substring(0, productCode.indexOf("."));
                    productImageMap.put(subProductCode, ele);
                }
            }
        });

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

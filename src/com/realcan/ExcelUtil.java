package com.realcan;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public abstract class ExcelUtil {


    public static List<String> columnHeadList = new ArrayList<>();
    public static List<List<String>> listData = new ArrayList<>();
    public static List<Map<String, String>> mapData = new ArrayList<>();
    public static Map<String, String> manufacturerMap = new HashMap<>();
    public static Map<String, String> unitMap = new HashMap<>();
    public static List<String> userHeadList = new ArrayList<>();
    public static List<Map<String, String>> userMapData = new ArrayList<>();
    public static Map<String, String> regionRgMap = new HashMap<>();
    /**
     * key:productCode
     * value:imageName
     */
    public static Map<String, Set<String>> productImagMap = new HashMap<>();
    public static Set<String> allImags = new HashSet<>();
    public static Map<String, String> imageProductMap = new HashMap<>();
    public static Map<String, String> productPriceMap = new HashMap<>();
    /**
     * 标志初始化是否完成
     */
    public static boolean flag = false;

    /**
     * 初始化sheet数据
     *
     * @param filePath  文件路径
     * @param sheetName sheet名称
     */
    public static void initSheetData(String filePath, String sheetName) {
        Sheet sheet = loadSheet(filePath, sheetName);
        int numOfRows = sheet.getLastRowNum() + 1;
        for (int i = 0; i < numOfRows; i++) {
            List<String> list = new ArrayList<>(40);
            Map<String, String> map = new HashMap<>(40);
            Row row = sheet.getRow(i);
            putRowValue(i, list, map, row, columnHeadList);
            if (i > 0) {
                mapData.add(map);
            }
            listData.add(list);
        }
        flag = true;
    }

    public static void initUserData(String userFilePath, String userSheet) {
        Sheet sheet = loadSheet(userFilePath, userSheet);
        int numOfRows = sheet.getLastRowNum() + 1;
        for (int i = 0; i < numOfRows; i++) {
            List<String> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            Row row = sheet.getRow(i);
            putRowValue(i, list, map, row, userHeadList);
            if (i > 0) {
                userMapData.add(map);
            }
        }
    }

    private static void putRowValue(int i, List<String> list, Map<String, String> map, Row row, List<String> userHeadList) {
        if (row != null) {
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    if (i == 0) {
                        userHeadList.add(getCellValue(cell));
                    } else {
                        if (j < userHeadList.size()) {
                            map.put(userHeadList.get(j), getCellValue(cell));
                        }
                    }
                    list.add(getCellValue(cell));

                }

            }
        }
    }


    /**
     * 生成100-1000内的随机数
     *
     * @return
     */
    public static int randomNum() {
        Random random = new Random();
        return random.nextInt(100) + 900;
    }

    /**
     * 获取所有的产品品牌
     *
     * @return
     */
    public static Set<String> getAllBrands() {
        Set<String> brands = new HashSet<>();
        if (mapData.size() == 0) {
            System.out.println("产品列表未初始化！");
        } else {
            for (Map<String, String> mapDatum : mapData) {
                brands.add(mapDatum.get(CellTypeEnum.BRAND.getDescription()));
            }
        }
        return brands;
    }

    private static String getCellValue(Cell cell) {
        if (cell != null) {
            String cellValue;
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cellValue = cell.getStringCellValue();
            return cellValue.trim();
        } else {
            return null;
        }

    }


    private static Sheet loadSheet(String filePath, String sheetName) {
        FileInputStream fileInputStream = null;
        Sheet sheet = null;
        try {
            fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sheet;
    }

    public static String getSupplierNameById(String id) {
        if (manufacturerMap.size() == 0) {
            System.out.println("生产厂商对照表初始化失败！");
            System.exit(0);
        }
        //去除ID中前面的0
        /*char[] chars = id.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if (aChar != '0') {
                break;
            } else {
                index++;
            }
        }
        id = id.substring(index);*/
        return manufacturerMap.get(id);
    }

    public static String getUnitNameByCode(String code) {
        if (unitMap.size() == 0) {
            System.out.println("计量单位对照表数据初始化失败！");
            System.exit(0);
        }
        return unitMap.get(code);
    }


    /**
     * 初始化厂商数据
     *
     * @param filePath 生产厂商对照表路径
     */
    public static void initManufacturerData(String filePath, String sheetName) {
        Sheet sheet = loadSheet(filePath, sheetName);
        int numOfRows = sheet.getLastRowNum() + 1;
        putvalue(sheet, numOfRows, manufacturerMap);
    }

    private static void putvalue(Sheet sheet, int numOfRows, Map<String, String> valueMap) {
        for (int i = 0; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    if (i > 0) {
                        valueMap.put(getCellValue(row.getCell(0)), getCellValue(row.getCell(1)));
                    }
                }
            }
        }
    }

    public static void initProductPrice(String filePath, String sheetName) {
        Sheet sheet = loadSheet(filePath, sheetName);
        int numOfRows = sheet.getLastRowNum() + 1;
        putvalue(sheet, numOfRows, productPriceMap);
    }

    public static void initUnitData(String unitFilePath, String unitSheet) {
        Sheet sheet = loadSheet(unitFilePath, unitSheet);
        int numOfRows = sheet.getLastRowNum() + 1;
        for (int i = 0; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                if (i > 0) {
                    unitMap.put(getCellValue(row.getCell(1)), getCellValue(row.getCell(27)));

                }
            }
        }
    }

    public static void initRegionRgMap() {

        /**
         * ;10	;CN-11;  北京
         * ;20	;CN-31;  上海
         * ;30	;CN-12;  天津
         * ;40	;CN-15;  内蒙古
         * ;50	;CN-14;  山西
         * ;60	;CN-13;  河北
         * ;70	;CN-21;  辽宁
         * ;80	;CN-22;  吉林
         * ;90	;CN-23;  黑龙江
         * ;100;CN-32;	江苏
         * ;110;CN-34;	安徽
         * ;120;CN-37;	山东
         * ;130;CN-33;	浙江
         * ;140;CN-36;	江西
         * ;150;CN-35;	福建
         * ;160;CN-43;	湖南
         * ;170;CN-42;	湖北
         * ;180;CN-41;	河南
         * ;190;CN-44;	广东
         * ;200;CN-46;	海南
         * ;210;CN-45;	广西
         * ;220;CN-52;	贵州
         * ;230;CN-51;	四川
         * ;240;CN-53;	云南
         * ;250;CN-61;	陕西
         * ;260;CN-62;	甘肃
         * ;270;CN-64;	宁夏
         * ;280;CN-63;	青海
         * ;290;CN-65;	新疆
         * ;300;CN-54;	西藏
         * ;320;CN-50;	重庆
         * ;330;CN-91;	香港
         * ;340;CN-92;	澳门
         * ;350;CN-71;	台湾
         */

        regionRgMap.put("010", "CN-11");
        regionRgMap.put("020", "CN-31");
        regionRgMap.put("030", "CN-12");
        regionRgMap.put("040", "CN-15");
        regionRgMap.put("050", "CN-14");
        regionRgMap.put("060", "CN-13");
        regionRgMap.put("070", "CN-21");
        regionRgMap.put("080", "CN-22");
        regionRgMap.put("090", "CN-23");
        regionRgMap.put("100", "CN-32");
        regionRgMap.put("110", "CN-34");
        regionRgMap.put("120", "CN-37");
        regionRgMap.put("130", "CN-33");
        regionRgMap.put("140", "CN-36");
        regionRgMap.put("150", "CN-35");
        regionRgMap.put("160", "CN-43");
        regionRgMap.put("170", "CN-42");
        regionRgMap.put("180", "CN-41");
        regionRgMap.put("190", "CN-44");
        regionRgMap.put("200", "CN-46");
        regionRgMap.put("210", "CN-45");
        regionRgMap.put("220", "CN-52");
        regionRgMap.put("230", "CN-51");
        regionRgMap.put("240", "CN-53");
        regionRgMap.put("250", "CN-61");
        regionRgMap.put("260", "CN-62");
        regionRgMap.put("270", "CN-64");
        regionRgMap.put("280", "CN-63");
        regionRgMap.put("290", "CN-65");
        regionRgMap.put("300", "CN-54");
        regionRgMap.put("320", "CN-50");
        regionRgMap.put("330", "CN-91");
        regionRgMap.put("340", "CN-92");
        regionRgMap.put("350", "CN-71");
    }


    public static void initProductImage(String imageFilePath) {
        productImageStage1(imageFilePath);
        //productImageStage2();
    }

    public static void productImageStage1(String imageFilePath) {
        Sheet sheet = loadSheet(imageFilePath, "工作表1");
        int numOfRows = sheet.getLastRowNum() + 1;
        for (int i = 0; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                if (i > 0) {
                    String productCode = getCellValue(row.getCell(0));
                    String imgName = getCellValue(row.getCell(1));
                    if (StringUtils.isNotBlank(imgName)) {
                        if (productImagMap.containsKey(productCode)) {
                            Set<String> imgNames = productImagMap.get(productCode);
                            imgNames.add(imgName);
                        } else {
                            Set<String> imgNames = new HashSet<>();
                            imgNames.add(imgName);
                            productImagMap.put(productCode, imgNames);
                        }
                        imageProductMap.put(imgName, productCode);
                        allImags.add(imgName);
                    }

                }
            }
        }
    }

}

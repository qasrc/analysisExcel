package com.realcan;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;

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
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    if (i == 0) {
                        //将标题添加到集合中
                        columnHeadList.add(getCellValue(cell));
                    } else {
                        //将数据添加到集合中
                        map.put(columnHeadList.get(j), getCellValue(cell));
                    }
                    list.add(getCellValue(cell));
                }
            }
            if (i > 0) {
                mapData.add(map);
            }
            listData.add(list);
        }
        flag = true;
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
        String cellValue;
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case NUMERIC:
                cellValue = String.valueOf(((int) cell.getNumericCellValue()));
                break;
            case BLANK:
                cellValue = "";
                break;
            case ERROR:
                cellValue = "";
                break;
            default:
                cellValue = cell.toString();
                break;
        }
        return cellValue.trim();
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
        char[] chars = id.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if (aChar != '0') {
                break;
            } else {
                index++;
            }
        }
        id = id.substring(index);
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
        for (int i = 0; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    if (i > 0) {
                        manufacturerMap.put(getCellValue(row.getCell(0)), getCellValue(row.getCell(1)));
                    }
                }
            }
        }
    }

    public static void initUnitData(String unitFilePath, String unitSheet) {
        Sheet sheet = loadSheet(unitFilePath, unitSheet);
        int numOfRows = sheet.getLastRowNum() + 1;
        for (int i = 0; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    if (i > 0) {
                        unitMap.put(getCellValue(row.getCell(1)), getCellValue(row.getCell(2)));
                    }
                }
            }
        }
    }
}

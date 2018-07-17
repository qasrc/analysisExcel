package com.realcan;

import java.io.*;

public class AnalysisStrategy {

    private static AnalysisStrategy analysisStrategy = new AnalysisStrategy();

    private AnalysisStrategy() {
    }

    private static String CATEGORY = "";

    static AnalysisStrategy getAnalysisStrategy(String category) {
        AnalysisStrategy.CATEGORY = category;
        return analysisStrategy;
    }

    public void analysis(String filePath, String sheetName) {


        ExcelAnalysis excelAnalysis = null;
        if ("1".equals(CATEGORY)) {

            excelAnalysis = new ProductAnalysis();
            //------------解析products-----------------
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析unit---------------------
            excelAnalysis = new UnitAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析product.impex------------------
            excelAnalysis = new ProductExtendAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析products-classification_zh.impex-------
            excelAnalysis = new ClassificationExtendAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析extend price------------
            excelAnalysis = new PriceExtendAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析stocklevels--------------
            excelAnalysis = new StockLevelsAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析productZh---------------
            excelAnalysis = new ProductZhAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析suppliers---------------
            excelAnalysis = new SuppliersAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析suppliersZh-------------
            excelAnalysis = new SupplierZhAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析manufacturer-------------
            excelAnalysis = new ManufacturerAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

        } else if ("3".equals(CATEGORY)) {
            excelAnalysis = new ProductAnalysis();
            //------------解析products-----------------
            excelAnalysis.analysis(filePath, sheetName);


            //------------解析user-groups.impex > b2bunit-----------------
            excelAnalysis = new B2bUnitAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析user-groups.impex > b2baddress----------------
            excelAnalysis = new B2bAddressAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

            //------------解析user-groups.impex > b2bcustomer------
            excelAnalysis = new B2bCustomerAnalysis();
            excelAnalysis.analysis(filePath, sheetName);

        } else {
            throw new RuntimeException("类型输入错误，错误的类型：" + CATEGORY);
        }


        this.writeFile(excelAnalysis);
        System.out.println("结果已写入文件，路径：/Users/zhangzhan/realcanwork/hybris开发/result.impex");
    }

    private void writeFile(ExcelAnalysis excelAnalysis) {
        String resultFilePath = "/Users/zhangzhan/realcanwork/hybris开发/result.impex";
        File file = new File(resultFilePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("原始文件已删除");
            }
        }
        try {
            boolean flag = file.createNewFile();
            if (!flag) {
                System.out.println("创建文件失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建文件失败");
        }

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for (String line : excelAnalysis.result) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("未找到文件");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

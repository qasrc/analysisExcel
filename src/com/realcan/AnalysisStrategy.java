package com.realcan;

import java.io.*;

public class AnalysisStrategy {

    private static AnalysisStrategy analysisStrategy = new AnalysisStrategy();

    private AnalysisStrategy() {
    }

    static AnalysisStrategy getAnalysisStrategy() {
        return analysisStrategy;
    }

    public void analysis(String filePath, String sheetName) {
        //------------解析products-----------------
        ExcelAnalysis excelAnalysis = new ProductAnalysis();
        excelAnalysis.analysis(filePath, sheetName);

        //------------解析classification-----------
        excelAnalysis = new ClassificationAnalysis();
        excelAnalysis.analysis(filePath, sheetName);

        //------------解析price-------------------
        excelAnalysis = new PriceAnalysis();
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

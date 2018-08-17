package com.realcan;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        execute();
    }

    //初始化程序
    private static void execute() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入产品列表文件路径(默认/Users/zhangzhan/realcanwork/hybris开发/增量数据/口腔数据正式5.xlsx)：");
        String filePath = input.nextLine();
        if (StringUtils.isBlank(filePath)) {
            filePath = "/Users/zhangzhan/realcanwork/hybris开发/增量数据/口腔数据正式5.xlsx";
        }
        System.out.println("请输入产品列表Sheet名称(默认工作表1)：");
        String fileSheet = input.nextLine();
        if (StringUtils.isBlank(fileSheet)) {
            fileSheet = "工作表1";
        }
        System.out.println("--------------------------");
        System.out.println("请输入生产厂商对照表文件路径(默认/Users/zhangzhan/realcanwork/hybris开发/增量数据/厂家.xlsx)：");
        String maPath = input.nextLine();
        if (StringUtils.isBlank(maPath)) {
            maPath = "/Users/zhangzhan/realcanwork/hybris开发/增量数据/厂家.xlsx";
        }
        System.out.println("请输入对照表Sheet名称(默认Sheet1)：");
        String maSheet = input.nextLine();
        if (StringUtils.isBlank(maSheet)) {
            maSheet = "Sheet1";
        }

        System.out.println("----------------------------");
        System.out.println("请输入计量单位对照表文件路径（默认/Users/zhangzhan/realcanwork/hybris开发/增量数据/计量单位对照表.xlsx）:");
        String unitFilePath = input.nextLine();
        if (StringUtils.isBlank(unitFilePath)) {
            unitFilePath = "/Users/zhangzhan/realcanwork/hybris开发/增量数据/计量单位对照表.xlsx";
        }
        System.out.println("请输入计量单位Sheet名称（默认Sheet1）:");
        String unitSheet = input.nextLine();
        if (StringUtils.isBlank(unitSheet)) {
            unitSheet = "Sheet1";
        }
        System.out.println("----------------------------");
        System.out.println("请输入用户列表文件路径（默认/Users/zhangzhan/realcanwork/hybris开发/增量数据/诊所正式数据修订2.xlsx），需要将后两列改为描述1和名称 2:");
        String userFilePath = input.nextLine();
        if (StringUtils.isBlank(userFilePath)) {
            userFilePath = "/Users/zhangzhan/realcanwork/hybris开发/增量数据/诊所正式数据修订2.xlsx";
        }
        System.out.println("请输入用户列表Sheet名称（默认工作表1）:");
        String userSheet = input.nextLine();
        if (StringUtils.isBlank(userSheet)) {
            userSheet = "工作表1";
        }
        System.out.println("---------------------------");
        System.out.println("请输入商品图片对照的文件路径（默认/Users/zhangzhan/realcanwork/hybris开发/增量数据/物料图片对应关系正式5.xlsx，Sheet名称：工作表1）");
        String imageFilePath = input.nextLine();
        if (StringUtils.isBlank(imageFilePath)) {
            imageFilePath = "/Users/zhangzhan/realcanwork/hybris开发/增量数据/物料图片对应关系正式5.xlsx";
        }

        System.out.println("--------------------------");
        System.out.println("请输入商品价格文件路径（默认/Users/zhangzhan/realcanwork/hybris开发/增量数据/口腔数据正式价格5.xlsx，Sheet名称：工作表1）");
        String priceFilePath = input.nextLine();
        if (StringUtils.isBlank(priceFilePath)) {
            priceFilePath = "/Users/zhangzhan/realcanwork/hybris开发/增量数据/口腔数据正式价格5.xlsx";
        }

        System.out.println("请选择生成impex文件类型：1.商品数据  3.用户数据 ");
        String category = input.nextLine();

        System.out.println("初始化生产厂商对照表数据");
        ExcelUtil.initManufacturerData(maPath, maSheet);
        System.out.println("初始化生产厂商对照表数据完成");
        System.out.println("初始化计量单位对照表数据");
        ExcelUtil.initUnitData(unitFilePath, unitSheet);
        System.out.println("初始化计量单位对照表数据完成");
        System.out.println("初始化用户测试数据");
        ExcelUtil.initUserData(userFilePath, userSheet);
        System.out.println("初始化用户测试数据完成");
        System.out.println("初始化商品图片对照表数据");
        ExcelUtil.initProductImage(imageFilePath);
        System.out.println("初始化商品图片对照表完成");
        System.out.println("初始化商品价格对照表");
        ExcelUtil.initProductPrice(priceFilePath, "工作表1");
        System.out.println("初始化商品价格对照表完成");

        System.out.println("开始解析产品列表文件");
        AnalysisStrategy analysisStrategy = AnalysisStrategy.getAnalysisStrategy(category);
        analysisStrategy.analysis(filePath, fileSheet);
        System.out.println("解析产品列表文件完成");


    }

}

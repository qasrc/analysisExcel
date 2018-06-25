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
        System.out.println("请输入产品列表文件路径(默认/Users/zhangzhan/realcanwork/hybris开发/电商平台测试产品数据.xlsx)：");
        String filePath = input.nextLine();
        if (StringUtils.isBlank(filePath)) {
            filePath = "/Users/zhangzhan/realcanwork/hybris开发/电商平台测试产品数据.xlsx";
        }
        System.out.println("请输入产品列表Sheet名称(默认Sheet1)：");
        String fileSheet = input.nextLine();
        if (StringUtils.isBlank(fileSheet)) {
            fileSheet = "Sheet1";
        }
        System.out.println("--------------------------");
        System.out.println("请输入生产厂商对照表文件路径(默认/Users/zhangzhan/realcanwork/hybris开发/生产厂商对照表对照表.xlsx)：");
        String maPath = input.nextLine();
        if (StringUtils.isBlank(maPath)) {
            maPath = "/Users/zhangzhan/realcanwork/hybris开发/生产厂商对照表对照表.xlsx";
        }
        System.out.println("请输入对照表Sheet名称(默认Sheet1)：");
        String maSheet = input.nextLine();
        if (StringUtils.isBlank(maSheet)) {
            maSheet = "Sheet1";
        }

        System.out.println("----------------------------");
        System.out.println("请输入计量单位对照表文件路径（默认/Users/zhangzhan/realcanwork/hybris开发/计量单位对照表.xlsx）:");
        String unitFilePath = input.nextLine();
        if (StringUtils.isBlank(unitFilePath)) {
            unitFilePath = "/Users/zhangzhan/realcanwork/hybris开发/计量单位对照表.xlsx";
        }
        System.out.println("请输入计量单位Sheet名称（默认Sheet1）:");
        String unitSheet = input.nextLine();
        if (StringUtils.isBlank(unitSheet)) {
            unitSheet = "Sheet1";
        }
        System.out.println("----------------------------");
        System.out.println("请输入用户列表文件路径（默认/Users/zhangzhan/realcanwork/hybris开发/电商平台用户测试数据.xlsx）:");
        String userFilePath = input.nextLine();
        if (StringUtils.isBlank(userFilePath)) {
            userFilePath = "/Users/zhangzhan/realcanwork/hybris开发/电商平台用户测试数据.xlsx";
        }
        System.out.println("请输入用户列表Sheet名称（默认Sheet1）:");
        String userSheet = input.nextLine();
        if (StringUtils.isBlank(userSheet)) {
            userSheet = "Sheet1";
        }
        System.out.println("请选择生成impex文件类型：1.baseProduct   2.extendProduct  3.用户测试数据");
        String category = input.nextLine();
        System.out.println("开始初始化生产厂商对照表数据");
        ExcelUtil.initManufacturerData(maPath, maSheet);
        System.out.println("初始化生产厂商对照表数据完成");
        System.out.println("开始初始化计量单位对照表数据");
        ExcelUtil.initUnitData(unitFilePath, unitSheet);
        System.out.println("初始化计量单位对照表数据完成");
        System.out.println("开始初始化用户测试数据");
        ExcelUtil.initUserData(userFilePath, userSheet);
        System.out.println("初始化用户测试数据完成");
        System.out.println("开始解析产品列表文件");

        AnalysisStrategy analysisStrategy = AnalysisStrategy.getAnalysisStrategy(category);
        analysisStrategy.analysis(filePath, fileSheet);
        System.out.println("解析产品列表文件完成");


    }

}

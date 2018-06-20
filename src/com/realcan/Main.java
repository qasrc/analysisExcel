package com.realcan;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        init();
    }

    //初始化程序
    private static void init(){
        System.out.println("请输入要解析的excel文件路径：");
        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();
        if (StringUtils.isBlank(filePath)) {
            System.out.println("路径不合法！");
            System.exit(0);
        }else{
            System.out.println("开始解析文件...");
        }

    }

}

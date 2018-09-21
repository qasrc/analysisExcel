package com.realcan;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author zhangzhan
 * @date 2018/8/29 下午5:43
 */
public class ImgDownload {
    public static void main(String[] args) {
        String path = "/Users/zhangzhan/realcanwork/hybris开发/增量数据/和舟医药商品.xlsx";
        String sheet = "商品图片";
        ExcelUtil.initSheetData(path, sheet);
        List<Map<String, String>> data = ExcelUtil.mapData;
        data.forEach(ele -> {
            String name = ele.get("图片名");
            String url = ele.get("图片");
            try {
                download(name, url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("download all images!!!");

    }

    public static void download(String name, String url) throws Exception {
        System.out.println("start download image,url:" + url);
        URL url1 = new URL(url);
        URLConnection urlConnection = url1.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] imageData = readInputStreamData(inputStream);
        File file = new File("/tmp/img/" + name + ".jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(imageData);
        fileOutputStream.close();
        System.out.println("download success!");
    }

    private static byte[] readInputStreamData(InputStream inputStream) throws Exception {
        byte[] bytes = new byte[1024];
        int len = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}

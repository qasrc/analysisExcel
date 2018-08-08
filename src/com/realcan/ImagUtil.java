package com.realcan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangzhan
 * @date 2018/8/7 下午4:32
 */
public class ImagUtil {

    private static Map<String, String> productImageMap = new HashMap<>();

    public static void main(String[] args) {
        analysis();

    }

    public static void analysis() {
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
}

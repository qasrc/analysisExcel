package com.realcan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangzhan
 * @date 2018/8/1 下午6:19
 */
public class SalesmanAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {


        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>>salesman start");
        Map<String, Salesman> salesmanMap = new HashMap<>();
        ExcelUtil.userMapData.forEach(ele -> {
            String salesmanId = ele.get(UserCellTypeEnum.SALESMAN_ID.getDescription());
            String soldwithorg = ele.get(UserCellTypeEnum.COMPANYID.getDescription()) + "-30-11_sellerOrg:" + ele.get(UserCellTypeEnum.SOLD_TO_ID.getDescription());
            if (salesmanMap.containsKey(salesmanId)) {
                Salesman salesman = salesmanMap.get(salesmanId);
                Set<String> soldwithorgs = salesman.getSoldWithOrg();
                soldwithorgs.add(soldwithorg);
            } else {
                Salesman salesman = new Salesman();
                salesman.setSalesmanId(salesmanId);
                salesman.setName(ele.get(UserCellTypeEnum.SALESMAN_NAME.getDescription()));
                Set<String> soldwithorgs = new HashSet<>();
                soldwithorgs.add(soldwithorg);
                salesman.setSoldWithOrg(soldwithorgs);
                salesmanMap.put(salesmanId, salesman);
            }
        });


        salesmanMap.keySet().forEach(key -> {
            Salesman salesman = salesmanMap.get(key);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(key)
                    .append(";;false;searchmanagergroup;Search Configuration Manager;")
                    .append(salesman.getName())
                    .append(";")
                    .append(getsoldwithorg(salesman))
                    .append(";");
            result.add(stringBuilder.toString());
        });

        result.add(">>>>>>>>>>>>>>>>>salesman end");


    }

    private String getsoldwithorg(Salesman salesman) {
        StringBuilder stringBuilder = new StringBuilder();
        salesman.getSoldWithOrg().forEach(ele -> stringBuilder.append(ele)
                .append(","));
        String resultStr = stringBuilder.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

    static class Salesman {
        private String salesmanId;
        private String name;
        private Set<String> soldWithOrg;

        public String getSalesmanId() {
            return salesmanId;
        }

        public void setSalesmanId(String salesmanId) {
            this.salesmanId = salesmanId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<String> getSoldWithOrg() {
            return soldWithOrg;
        }

        public void setSoldWithOrg(Set<String> soldWithOrg) {
            this.soldWithOrg = soldWithOrg;
        }
    }
}

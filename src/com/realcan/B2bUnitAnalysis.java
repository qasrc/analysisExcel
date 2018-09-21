package com.realcan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B2bUnitAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {
        result.add("");
        result.add("");
        result.add("!!!上方数据无用，仅作加载数据使用");
        for (int i = 0; i < 3; i++) {
            result.add("");
        }
        result.add("--------------------user-groups.impex start--------------");
        result.add(">>>>>>>>>>>>>>>> B2BUnit start");
        Set<String> tmp = new HashSet<>();
        Map<String, B2bUnit> unitMap = new HashMap<>();
        ExcelUtil.userMapData.forEach(ele -> {
            String soldToId = ele.get(UserCellTypeEnum.SOLD_TO_ID.getDescription());
            if (unitMap.containsKey(soldToId)) {
                B2bUnit b2bUnit = unitMap.get(soldToId);
                b2bUnit.getCompany().add(ele.get(UserCellTypeEnum.COMPANYID.getDescription()));
                b2bUnit.getShipToId().add(ele.get(UserCellTypeEnum.SHIP_TO_ID.getDescription()));
            } else {
                B2bUnit b2bUnit = new B2bUnit();
                b2bUnit.setSoldToId(soldToId);
                b2bUnit.setHospitalName(ele.get(UserCellTypeEnum.HOSPITAL_NAME.getDescription()));
                Set<String> companys = new HashSet<>();
                companys.add(ele.get(UserCellTypeEnum.COMPANYID.getDescription()));
                b2bUnit.setCompany(companys);
                b2bUnit.setDivision(ele.get(UserCellTypeEnum.DIVISION.getDescription()));
                Set<String> shipToIds = new HashSet<>();
                shipToIds.add(ele.get(UserCellTypeEnum.SHIP_TO_ID.getDescription()));
                b2bUnit.setShipToId(shipToIds);
                unitMap.put(soldToId, b2bUnit);
            }
        });

        unitMap.keySet().forEach(key -> {
            B2bUnit b2bUnit = unitMap.get(key);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(";")
                    .append(b2bUnit.getHospitalName())
                    .append(";")
                    .append(b2bUnit.getSoldToId())
                    .append(";")
                    .append(b2bUnit.getHospitalName())
                    .append(";")
                    .append(b2bUnit.getHospitalName())
                    .append(";")
                    .append(getCompany(b2bUnit))
                    .append(";;")
                    .append(getShipToId(b2bUnit))
                    .append(";RealcanID_")
                    .append(b2bUnit.getSoldToId())
                    .append(";acctmgoral;;;;");
            tmp.add(stringBuilder.toString());
        });

        result.addAll(tmp);
        result.add(">>>>>>>>>>>>>>>>>>> B2BUnit end");
    }


    private String getCompany(B2bUnit b2bUnit) {
        StringBuilder stringBuilder = new StringBuilder();
        b2bUnit.getCompany().forEach(ele -> {
            stringBuilder.append(ele)
                    .append("-30-")
                    .append(b2bUnit.getDivision())
                    .append("_sellerOrg,");
        });
        String resultStr = stringBuilder.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

    private String getShipToId(B2bUnit b2bUnit) {
        StringBuilder stringBuilder = new StringBuilder();
        b2bUnit.getShipToId().forEach(ele -> {
            stringBuilder.append("RealcanAddrID_")
                    .append(ele)
                    .append(",");
        });
        String resultStr = stringBuilder.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }


    static class B2bUnit {
        String soldToId;
        String hospitalName;
        Set<String> company;
        Set<String> shipToId;
        String division;

        public String getDivision() {
            return division;
        }

        public void setDivision(String division) {
            this.division = division;
        }

        public String getSoldToId() {
            return soldToId;
        }

        public void setSoldToId(String soldToId) {
            this.soldToId = soldToId;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public Set<String> getCompany() {
            return company;
        }

        public void setCompany(Set<String> company) {
            this.company = company;
        }

        public Set<String> getShipToId() {
            return shipToId;
        }

        public void setShipToId(Set<String> shipToId) {
            this.shipToId = shipToId;
        }
    }
}

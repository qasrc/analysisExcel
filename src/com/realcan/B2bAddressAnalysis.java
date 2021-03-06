package com.realcan;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B2bAddressAnalysis extends ExcelAnalysis {
    @Override
    void analysis(String filePath, String sheetName) {

        for (int i = 0; i < 5; i++) {
            result.add("");
        }
        result.add(">>>>>>>>>>>>>>>>>>>> RealcanB2BAddress start");
        Set<String> tmp = new HashSet<>();

        Map<String, B2bAddress> b2bAddressMap = new HashMap<>();
        ExcelUtil.userMapData.forEach(ele -> {
            String soldToId = ele.get(UserCellTypeEnum.SOLD_TO_ID.getDescription());
            if (StringUtils.isNotBlank(soldToId)) {
                String shipToId = ele.get(UserCellTypeEnum.SHIP_TO_ID.getDescription());
                if (b2bAddressMap.containsKey(shipToId)) {
                    B2bAddress b2bAddress = b2bAddressMap.get(shipToId);
                    b2bAddress.getCompany().add(ele.get(UserCellTypeEnum.COMPANYID.getDescription()));
                } else {
                    B2bAddress b2bAddress = new B2bAddress();
                    b2bAddress.setShipToId(ele.get(UserCellTypeEnum.SHIP_TO_ID.getDescription()));
                    b2bAddress.setStreetName(ele.get(UserCellTypeEnum.STREET_NAME.getDescription()));
                    b2bAddress.setPostalCode(ele.get(UserCellTypeEnum.POSTALCODE.getDescription()));
                    b2bAddress.setDesc1(ele.get(UserCellTypeEnum.DESC1.getDescription()));
                    b2bAddress.setCountry(ele.get(UserCellTypeEnum.COUNTRY.getDescription()));
                    b2bAddress.setSoldToId(ele.get(UserCellTypeEnum.SOLD_TO_ID.getDescription()));
                    b2bAddress.setName2(ele.get(UserCellTypeEnum.NAME2.getDescription()));
                    Set<String> company = new HashSet<>();
                    company.add(ele.get(UserCellTypeEnum.COMPANYID.getDescription()));
                    b2bAddress.setCompany(company);
                    b2bAddress.setMobileNum1(ele.get(UserCellTypeEnum.MOBILE_NUM1.getDescription()));
                    b2bAddress.setRg(ele.get(UserCellTypeEnum.RG.getDescription()));
                    b2bAddress.setDefaultAddress(ele.get(UserCellTypeEnum.DEFAULT.getDescription()));
                    b2bAddressMap.put(shipToId, b2bAddress);
                }
            }
        });

        b2bAddressMap.keySet().forEach(key -> {
            StringBuilder stringBuilder = new StringBuilder();
            B2bAddress b2bAddress = b2bAddressMap.get(key);
            stringBuilder.append(";")
                    .append(key)
                    .append(";")
                    .append(b2bAddress.getStreetName())
                    .append(";")
                    .append(";")
                    .append(b2bAddress.getDesc1())
                    .append(";")
                    .append(b2bAddress.getCountry())
                    .append(";TRUE;TRUE;TRUE;TRUE;;")
                    .append(b2bAddress.getName2())
                    .append(";;rev;RealcanAddrID_")
                    .append(key)
                    .append(";RealcanID_")
                    .append(b2bAddress.getSoldToId())
                    .append(";")
                    .append(getCompanys(b2bAddress))
                    .append(";")
                    .append(getRegionByRg(b2bAddress.getRg()))
                    .append(";")
                    .append(b2bAddress.getMobileNum1())
                    .append(";RealcanID_")
                    .append(b2bAddress.getSoldToId());
            if ("1".equals(b2bAddress.getDefaultAddress())) {
                stringBuilder.append(";true");
            } else {
                stringBuilder.append(";false");
            }
            tmp.add(stringBuilder.toString());
        });

        result.addAll(tmp);
        result.add(">>>>>>>>>>>>>>>>>>> RealcanB2BAddress end");
    }

    private String getCompanys(B2bAddress b2bAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        b2bAddress.getCompany().forEach(ele -> {
            stringBuilder.append(ele)
                    .append("-30-11_sellerOrg,");
        });
        String resultStr = stringBuilder.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

    private String getRegionByRg(String rg) {
        if (ExcelUtil.regionRgMap.size() == 0) {
            ExcelUtil.initRegionRgMap();
        }
        return ExcelUtil.regionRgMap.get(rg);
    }

    static class B2bAddress {
        private String shipToId;
        private String soldToId;
        private String streetName;
        private String postalCode;
        private String desc1;
        private String country;
        private String name2;
        private Set<String> company;
        private String mobileNum1;
        private String rg;
        private String defaultAddress;

        public String getDefaultAddress() {
            return defaultAddress;
        }

        public void setDefaultAddress(String defaultAddress) {
            this.defaultAddress = defaultAddress;
        }

        public String getRg() {
            return rg;
        }

        public void setRg(String rg) {
            this.rg = rg;
        }

        public String getShipToId() {
            return shipToId;
        }

        public String getSoldToId() {
            return soldToId;
        }

        public void setSoldToId(String soldToId) {
            this.soldToId = soldToId;
        }

        public void setShipToId(String shipToId) {
            this.shipToId = shipToId;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getDesc1() {
            return desc1;
        }

        public void setDesc1(String desc1) {
            this.desc1 = desc1;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        public Set<String> getCompany() {
            return company;
        }

        public void setCompany(Set<String> company) {
            this.company = company;
        }

        public String getMobileNum1() {
            return mobileNum1;
        }

        public void setMobileNum1(String mobileNum1) {
            this.mobileNum1 = mobileNum1;
        }
    }


    public static void main(String[] args) {
        String s = "00000123".replaceAll("^(0+)", "");
        System.out.println(s);
    }
}

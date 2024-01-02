package lib;

import org.testng.annotations.DataProvider;

public class Dataprovider {
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        ExcelReader reader = new ExcelReader();
        String exePath = "C:\\Users\\Dell\\IdeaProjects\\eCommerceProject\\src\\data\\Login.xlsx";
        return reader.getExcelData(exePath, "Sheet1");
    }
}
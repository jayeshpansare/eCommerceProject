package lib;

import org.testng.annotations.DataProvider;

public class Dataprovider {
    static String projectPath = System.getProperty("user.dir");
    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
        ExcelReader reader = new ExcelReader();
        String exePath = "C:\\Users\\Dell\\IdeaProjects\\eCommerceProject\\src\\data\\Login.xlsx";
        Object[][] arrayObject= reader.getExcelData(exePath, "Sheet1");
        return arrayObject;
    }

    public Object[] getTopLevelCatData(){
        ExcelReader reader = new ExcelReader();
        String exePath = "C:\\Users\\Dell\\IdeaProjects\\eCommerceProject\\src\\data\\AddProduct.xlsx";
        Object[] arrayObject= reader.getExcelData(exePath, "Sheet1");
        return arrayObject;
    }
}

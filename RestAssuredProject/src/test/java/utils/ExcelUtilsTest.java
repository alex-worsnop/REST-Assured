package utils;

//From: https://www.youtube.com/watch?v=AWbwhkDceB0
//REST Assured API testing Beginner Tutorial | Part 5

public class ExcelUtilsTest {
	
	public static void main(String[] args) {
		
		String excelPath = "./data/TestData.xlsx";
		String sheetName = "Sheet1";
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
	}

}

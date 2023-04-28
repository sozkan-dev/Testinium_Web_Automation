package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Util {

    public static String getDataFromExcel(int index) throws IOException {
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(fs);
        XSSFSheet s1 = wb.getSheet("Sayfa1");
        XSSFRow r1 = s1.getRow(index);
        XSSFCell c1 = r1.getCell(0);
        System.out.println(c1.getStringCellValue());
        return c1.getStringCellValue();
    }




}
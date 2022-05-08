package httpclientdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

//import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

/**
 * 实现从excel中读取数据的功能
 *
 * @Author: Wzw
 * @Date: 2021/7/27 21:36
 */
public class ExcelUtil {

    public static Object[][] datas() {

        String filePath = "src\\test\\resources\\testdata\\cases_v1.xlsx";
        Object[][] datas = new Object[5][2];
        //获取Workbook对象

        try {
            Workbook wb = WorkbookFactory.create(new File(filePath));

            //获取Sheet对象
            Sheet sheet = wb.getSheet("用例");

            //lastRowNum is the index of last row, if lastRowNum = 5, 6 rows in this sheet
            int lastRowNum = sheet.getLastRowNum();
//            System.out.println("lastRowNum="+lastRowNum);
            // 获取行
//            int [] rows = {1,2,3,4,5}; //实际上取1-5行的数据，先硬编码for loop 的参数
            for (int i = 1; i <= 5; i++) {//取行index 1-5 的数据,当 i=1时，实际读取的是excel第二行数据
                Row row = sheet.getRow(i);
                for (int j = 5; j <= 6; j++) {//取列index 5、6的数据
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
//                    System.out.println("i=" + i + ",j=" + j + ",value = " + value);
                    datas[i - 1][j - 5] = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }


    /**
     * @param filePath:  excel file path
     * @param startRow:  start row number, instead of index
     * @param endRow     : end row number, instead of index
     * @param startCol:  start column number, instead of index
     * @param endCol:end column number, instead of index
     */

    public static Object[][] datas(String filePath, String sheetName, int startRow, int endRow, int startCol, int endCol) {

        Object[][] datas = new Object[endRow - startRow + 1][endCol - startCol + 1];
        //获取Workbook对象

        try {
            Workbook wb = WorkbookFactory.create(new File(filePath));

            //获取Sheet对象
            Sheet sheet = wb.getSheet(sheetName);

//            int lastRowNum = sheet.getLastRowNum();
            // 获取行
            for (int i = startRow; i <= endRow; i++) {
                Row row = sheet.getRow(i - 1);// index (i-1) equals to (row number -1)
                for (int j = startCol; j <= endCol; j++) {
                    //index (j-1) equals to (column number -1)
                    Cell cell = row.getCell(j - 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    datas[i - startRow][j - startCol] = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }


    public static Object[][] datas(String filePath, String sheetName, int[] rows, int[] cols) {

        Object[][] datas = new Object[rows.length][cols.length];
        //获取Workbook对象

        try {
            Workbook wb = WorkbookFactory.create(new File(filePath));

            //获取Sheet对象
            Sheet sheet = wb.getSheet(sheetName);

//            int lastRowNum = sheet.getLastRowNum();
            // 获取行
            for (int i = 0; i < rows.length; i++) {
                Row row = sheet.getRow(rows[i] - 1);// index (i-1) equals to (row number -1)
                for (int j = 0; j < cols.length; j++) {
                    //index (j-1) equals to (column number -1)
                    Cell cell = row.getCell(cols[j] - 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    datas[i][j] = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }


    public static <T> void load(String filePath, String sheetName, Class<T> clazz) {
//        Class clazz = Case.class;//反射得到 class 对象
        try {
            Workbook wb = WorkbookFactory.create(new File(filePath));
            Sheet sheet = wb.getSheet(sheetName);

            //使用反射读取列名
            Row headerRow = sheet.getRow(0);
            short lastCellNum = headerRow.getLastCellNum();//lastCellNum - 1 = index

            // 循环处理第一行的各列，取出每一列的字段名保存到数组
            String[] headers = new String[lastCellNum];
            for (int i = 0; i < lastCellNum; i++) {
                Cell cell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String oneOfHeaderCell = cell.getStringCellValue();
//                System.out.println(oneOfHeaderCell);
                String headerCol = oneOfHeaderCell.substring(0, oneOfHeaderCell.indexOf("("));
//                System.out.println(headers);
                headers[i] = headerCol;
            }

            int lastRowIndex = sheet.getLastRowNum();//返回行索引 index
            //循环处理每一个数据行
            for (int i = 1; i <= lastRowIndex; i++) {

//                Case cs = (Case) clazz.newInstance();
                Object cs = clazz.newInstance();

                //拿到一个数据行
                Row dataRow = sheet.getRow(i);
                //拿到此数据行上的每一列,反射获取方法名
                for (int j = 0; j < lastCellNum; j++) {
                    Cell cell = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    //获取要反射的方法名
                    String methodName = "set" + headers[j];
                    Method method = clazz.getMethod(methodName, String.class);
                    method.invoke(cs, value);
                }

                if (cs instanceof Case) {
                    Case cs2 = (Case) cs;
                    CaseUtil.cases.add(cs2);
                }else if (cs instanceof Rest){
                    Rest cs2 = (Rest) cs;
                    RestUtil.rests.add(cs2);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 获取cellName以及它对应的列索引，结果保存在HashMap<String,Integer>中
     * 获取caseId  以及它对应的行索引，结果保存在HashMap<String,Integer>中
     * */
    private static void loadRownumAndCellnumMapping(String excelPath,String sheetName){
        InputStream inp = null;
        try {
            inp = new FileInputStream(new File(excelPath));
            Workbook workbook = WorkbookFactory.create(inp);
            Sheet sheet = workbook.getSheet(sheetName);

            //获取第一行（标题行）,将标题column 以及标题column 对应的索引存入到 HashMap<String,Integer>中
            Row titleRow = sheet.getRow(0);
            if(titleRow != null){
                short lastCellNum = titleRow.getLastCellNum();// 列号,不是列索引

                for (int i = 0; i < lastCellNum; i++) {
                    Cell cell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                }
            }

            //从第二行开始，获取所有数据行



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }


    public static void main(String[] args) {
        String filePath = "src\\test\\resources\\testdata\\cases_v4.xlsx";
//        load(filePath, "用例");
        for (Case cs : CaseUtil.cases) {
            System.out.println(cs);
        }
    }
}

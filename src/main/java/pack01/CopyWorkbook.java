package pack01;

import java.io.File;
import java.nio.file.*;

public class CopyWorkbook {

    public static void main(String[] args) {
        String oldFilePath = "C:\\Users\\wzw\\Desktop\\tst-workbook.xlsx";
        String newFilePath = "C:\\Users\\wzw\\Desktop\\Evidence\\";
        int endIndex = oldFilePath.lastIndexOf(".");

        String fileDir = oldFilePath.substring(oldFilePath.lastIndexOf("."));
        System.out.println("fileDir = "+fileDir);

    }

}

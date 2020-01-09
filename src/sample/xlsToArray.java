package sample;

import java.io.*;

import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class xlsToArray {
    private int rowNum = 0;
    private int colNum = 0;
    public String[] ChangeXls(String[] WorkDay,Integer theFirst,Integer count)
            throws IOException {
        File file = new File("f:\\21.xls");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        POIFSFileSystem fileSystem = new POIFSFileSystem(in);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        for (int i = 0; i < workbook.getNumberOfSheets(); i++){
            HSSFSheet sheet = workbook.getSheetAt(i);
            rowNum = sheet.getLastRowNum();
            for(int j = 0; j <= rowNum; j++){
                HSSFRow row = sheet.getRow(j);
                colNum =  row.getPhysicalNumberOfCells();
                //k是位置排序，num是xls的数据列表
                for (int k = theFirst,num = 0; k <= count; k++) {
                    // 获取该单元格相应的类型的值
                    HSSFCell c = row.getCell(num++);
                    if(c == null||c.getStringCellValue().equals("")){
                        WorkDay[k-1] = "休";
                    }else
                        WorkDay[k-1] = c.getStringCellValue();
                }
            }
        }
        return WorkDay;
    }
}

package com.lyf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lyf.entity.Emp;

@SuppressWarnings("serial")
public class TrServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		System.out.println("执行导入开始");
		 // 文件所在路径  
        String execelFile = "E:/test.xls" ; 
        impExcel(execelFile);
	}
    /** 
     * 导入Excel 
     * @param execelFile 
     */  
    @SuppressWarnings("resource")
	public HashMap<String, String> impExcel(String execelFile){  
    	HashMap<String, String> map_row = new HashMap<String, String>();
        try {  
            // 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)  
            Workbook book = null;  
            try {  
                // Excel 2007获取方法  
                book = new XSSFWorkbook(new FileInputStream(execelFile));  
            } catch (Exception ex) {  
                // Excel 2003获取方法  
                book = new HSSFWorkbook(new FileInputStream(execelFile));  
            }  
              
            // 读取表格的第一个sheet页  
            Sheet sheet = book.getSheetAt(0);  
            // 定义 row、cell  
            Row row;  
            // 总共有多少行,从0开始  
            int totalRows = sheet.getLastRowNum() ;  
            // 循环输出表格中的内容,首先循环取出行,再根据行循环取出列  
            for (int i = 1; i <= totalRows; i++) {  
            	Emp emp = new Emp();
            	
                row = sheet.getRow(i);  
                // 处理空行  
                if(row == null){  
                    continue ;  
                }  
                // 总共有多少列,从0开始  
                int totalCells = row.getLastCellNum() ;  
                String cell = "";
                for (int j = row.getFirstCellNum(); j < totalCells; j++) {  
                    // 处理空列  
                    if(row.getCell(j) == null){  
                        continue ;  
                    }
                    // 通过 row.getCell(j).toString() 获取单元格内容  
                    System.out.print(cell + "\t");  
                }  
                System.out.println("");  
            }
            
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return map_row;
    }  
}

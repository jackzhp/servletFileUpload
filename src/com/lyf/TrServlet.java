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
		System.out.println("ִ�е��뿪ʼ");
		 // �ļ�����·��  
        String execelFile = "E:/test.xls" ; 
        impExcel(execelFile);
	}
    /** 
     * ����Excel 
     * @param execelFile 
     */  
    @SuppressWarnings("resource")
	public HashMap<String, String> impExcel(String execelFile){  
    	HashMap<String, String> map_row = new HashMap<String, String>();
        try {  
            // ���� Workbook ����execelFile �Ǵ����ļ�·��(���Excel������)  
            Workbook book = null;  
            try {  
                // Excel 2007��ȡ����  
                book = new XSSFWorkbook(new FileInputStream(execelFile));  
            } catch (Exception ex) {  
                // Excel 2003��ȡ����  
                book = new HSSFWorkbook(new FileInputStream(execelFile));  
            }  
              
            // ��ȡ���ĵ�һ��sheetҳ  
            Sheet sheet = book.getSheetAt(0);  
            // ���� row��cell  
            Row row;  
            // �ܹ��ж�����,��0��ʼ  
            int totalRows = sheet.getLastRowNum() ;  
            // ѭ���������е�����,����ѭ��ȡ����,�ٸ�����ѭ��ȡ����  
            for (int i = 1; i <= totalRows; i++) {  
            	Emp emp = new Emp();
            	
                row = sheet.getRow(i);  
                // �������  
                if(row == null){  
                    continue ;  
                }  
                // �ܹ��ж�����,��0��ʼ  
                int totalCells = row.getLastCellNum() ;  
                String cell = "";
                for (int j = row.getFirstCellNum(); j < totalCells; j++) {  
                    // �������  
                    if(row.getCell(j) == null){  
                        continue ;  
                    }
                    // ͨ�� row.getCell(j).toString() ��ȡ��Ԫ������  
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

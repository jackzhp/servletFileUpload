package com.lyf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import com.lyf.entity.Emp;

public class ImpExcel extends HttpServlet {
	private static final long serialVersionUID = -2473105478542292601L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		System.out.println("执行导入开始");
		 // 文件所在路径  
        String execelFile = "E:/test.xls" ; 
       List<Emp> list =  getAllByExcel(execelFile);
       request.getSession().setAttribute("list", list);
       request.getRequestDispatcher("begin.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		doPost(request, response);
	}
	/**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public List<Emp> getAllByExcel(String file){
        List<Emp> list=new ArrayList<Emp>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
             
            System.out.println("列数:"+clos+" 行数:"+rows);
            for (int i = 1; i < rows; i++) {
                //第一个是列数，第二个是行数
                String name=rs.getCell(0, i).getContents();//默认最左边编号也算一列 所以这里得j++
                String age=rs.getCell(1, i).getContents();
                String sex=rs.getCell(2, i).getContents();
                String fav=rs.getCell(3, i).getContents();
                 System.out.println(name+"\t"+age+"\t"+sex+"\t"+fav);
                Emp emp = new Emp();
                emp.setName(name);
                emp.setSex(sex);
                emp.setAge(age);
                emp.setFav(fav);
                list.add(emp);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
         
    }
     
}

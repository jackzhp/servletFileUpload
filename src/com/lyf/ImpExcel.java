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
		System.out.println("ִ�е��뿪ʼ");
		 // �ļ�����·��  
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
     * ��ѯָ��Ŀ¼�е��ӱ�������е�����
     * @param file �ļ�����·��
     * @return
     */
    public List<Emp> getAllByExcel(String file){
        List<Emp> list=new ArrayList<Emp>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);
            int clos=rs.getColumns();//�õ����е���
            int rows=rs.getRows();//�õ����е���
             
            System.out.println("����:"+clos+" ����:"+rows);
            for (int i = 1; i < rows; i++) {
                //��һ�����������ڶ���������
                String name=rs.getCell(0, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
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

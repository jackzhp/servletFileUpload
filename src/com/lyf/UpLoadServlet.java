package com.lyf;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        DiskFileItemFactory df = new DiskFileItemFactory();  
        //�趨��ֵ1M������������ֵ�����ļ���ֱ��д����ʱ�ļ�������һֱռ���ڴ�  
        //����������Կ����ϴ����ļ���ʱ�򲻻�ռ�ô����ڴ棬������߲���ʹ������  
        df.setSizeThreshold(1024 * 1024);  
          
        try {  
            File f = new File("E:\\preprocess_gd_package\\temp");  
            if (!f.exists()) {  
                f.mkdirs();  
            }  
              
            df.setRepository(f);  
            ServletFileUpload sf = new ServletFileUpload(df);  
            sf.setFileSizeMax(1024 * 1024 * 100);//�ϴ��ļ����Ϊ100M  
            List list = sf.parseRequest(request);  
            for (int i = 0; i < list.size(); i++) {  
                FileItem fileItem = (FileItem) list.get(i);  
                String fileName = fileItem.getName();  
                if(fileName == null || "".equals(fileName.trim())){  
                    continue;  
                }  
                File ff = new File("E:\\preprocess_gd_package\\files");  
                if (!ff.exists()) {  
                    ff.mkdirs();  
                }  
                  
                File f2 = new File(ff, fileName);  
                fileItem.write(f2);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        response.setContentType("text/html");  
        response.setCharacterEncoding("GBK");  
        PrintWriter out = response.getWriter();  
        out.println("<script>alert('�ļ��ϴ��ɹ���');</script>");  
        out.flush();  
        out.close();  
    }  
}

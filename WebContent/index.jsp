<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>�ļ��ϴ�</title>  
       <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    </head>  
  <style>
inupt[type="text"]{
  width: 100%;
}
</style>
<body>  
<br><br><br>

<div style="border: 1px solid;width: 90%;" class="container">
	<br>
    <form action="fileupload" method="post" class="form-inline"  name="form1" role="form"> 
    	
    	<table cellspacing="0" cellpadding="6px" width="85%" border="1" align="center">
        <tr>
			<td width="22%"><span style="color:red">*</span>�γ�����</td>
			<td>
				<input type="text" id="kcmc" class="form-control" name="kcmc" value="${exTraining.kcmc }">
			</td>
			<td width="22%"><span style="color:red">*</span>��ѵ����</td>
			<td>
				<input type="text" id="pxjg" class="form-control" name="pxjg" value="${exTraining.pxjg }">&nbsp;��&nbsp;
				<input type="text" id="pxjg" class="form-control" name="pxjg" value="${exTraining.pxjg }">&nbsp;ʱ
			</td>
		</tr> 
		<tr>
			<td>��ע</td>
			<td colspan="3" >
				<textarea class="form-control" style="height: 60px; width: 90%"></textarea>
			</td>
		</tr>
		<tr>
			<td>ѡ��</td>
			<td colspan="3" >
				<select class="form-control">
					<option></option>
					<option>�й�����</option>
					<option>��������</option>
				</select>
			</td>
		</tr>
		</table> 
		<br>
		<table style="width:100%" id="Top_Button" class="QueryConTab" border="1">
		<tr>
			<td colspan="4">
				<input type="button" value="��&nbsp;��" class="btn btn-primary active" onclick="clean();"  />&nbsp;
				<input type="button" value="��&nbsp;��" class="btn btn-primary active" onclick="query();"  />&nbsp;
				<input type="button" value="��&nbsp;��" class="btn btn-primary active" onclick="download();" />&nbsp;
			</td>
		</tr>
		<tr>
			<td width="18%">����</td>
			<td width="32%" align="left">
				<input type="text" id="num" name="num" class="form-control" value="${condition.workFlowNumber }"/>
			</td>
			<td width="18%">��������</td>
			<td width="32%" align="left" colspan="3">
			From: <input type="text" id="timeFrom" class="form-control" name="timeFrom" value="${condition.timeFrom}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px" />
			To: <input type="text" id="timeTo" class="form-control" name="timeTo" value="${condition.timeTo}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:100px" />
			</td>
		</tr>
		<tr>
			<td>����</td>
			<td align="left">
				<input type="text" class="form-control" id="empDept" name="empDept" value="${condition.empDept }"/>
			</td>
			<td>��ǰ������</td>
			<td align="left">
				<input type="text" class="form-control" id="currentHandler" name="currentHandler" value="${condition.currentHandler }"/>
			</td>
		</tr>
		<tr>
			<td>��ѵ����</td>
			<td align="left">
				<input type="text" class="form-control" id="pxjg" name="pxjg" value="${condition.pxjg }"/>
			</td>
			<td>�γ�����</td>
			<td align="left">
				<input type="text" class="form-control" id="kcmc" name="kcmc" value="${condition.kcmc }"/>
			</td>
		</tr>
		<tr>
			<td>״̬</td>
			<td align="left">
				<select class="form-control">
						<option></option>
						<option>�й�����</option>
						<option>��������</option>
					</select>
			</td>
			<td>������</td>
			<td align="left">
				<input type="text" class="form-control" id="applyer" name="applyer" value="${condition.applyer }"/>
			</td>
		</tr>
	</table>
		
    </form>  
    </div>
  </body>
</html> 
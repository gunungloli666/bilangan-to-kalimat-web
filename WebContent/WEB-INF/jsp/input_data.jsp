<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bilangan to Bahasa</title>
<%
String path = request.getContextPath(); 
%>
<link rel="stylesheet" href="<%=path%>/style/w3.css" type="text/css" >
<link rel="stylesheet" href="<%=path%>/style/xmain.css" type="text/css" >
</head>
<body>

<%
String keluaran = (String ) request.getAttribute("keluaran");
String masukan = (String) request.getAttribute("masukan"); 
%>
<center>
	<h2>Konversi Bilangan Ke Kalimat</h2>
	<form method="post" action="simple" >   
	    <table>
	    	<tr>
	    		<td>Bilangan Masukan:</td>
	    		<td><input type="text" name="bilanganMasukan" value="<%=masukan%>"/>
	    	</tr>
	    	<tr>
	    		<td>Hasil Konversi:</td>
	    		<td><%=keluaran%></td>
	    	</tr>
	    	<tr>
	    		<td colspan="2"><input type="submit" value="Hitung" /> 
	    	</tr>
	    </table>
	</form>
	
	<p>
	<small>Dibuat oleh: Mohammad Fajar</small>
	</p>

</center>
</body>
</html>
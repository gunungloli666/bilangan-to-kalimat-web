<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String nama = (String) request.getAttribute("nama" ) != null ? (String) request.getAttribute("nama" ) : ""; 
String id = (String) request.getAttribute("id" ) != null ?(String) request.getAttribute("id" ) : ""; 
 %>
 
 <h2><%=nama%></h2>
 <h2><%=id%></h2>
<form method="post" action="testform">

<table cellspacing="10px">
<tr>
<td>Nama:</td><td><input type="text" name="nama" /></td>
</tr>
<tr></tr>
<tr>
<td></td><td><input type="submit" value="SUBMIT" /></td>
</tr>
</table>

</form>

</body>
</html>
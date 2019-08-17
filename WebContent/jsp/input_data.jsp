<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="guesData" scope="request"
	class="com.fjr.helloworld.TestEnum"></jsp:useBean>

<jsp:useBean id="konverter" scope="request"
	class="com.parsing.bilangan.BilanganToKalimat" >
</jsp:useBean>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bilangan to Bahasa</title>

</head>
<body>
<center>
	<h2><%=guesData.exampleString()%></h2>
	<form method="post" action="#" >   
	    <jsp:setProperty name="konverter"  property="*"  />
	    <table>
	    	<% 
	    			String data = konverter.getBilanganKeluaran(); 
	    			String dataInput = konverter.getBilanganMasukan(); 
	    	%>
	    	<tr>
	    		<td>Bilangan Masukan:</td>
	    		
	    		<td><input type="text" name="bilanganMasukan" 
	    		<%if(dataInput!= null && ! dataInput.equals("")){ %>
	    				value="<%= dataInput %>" 
	    		<%}%>
	    		 />
	    	</tr>
	    	<tr>
	    		<td>Hasil Konversi:</td>
	    		<td><% if(data != null && ! data.equals("")){ %> <%= data%>  <% } %></td>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Bilangan to Bahasa</title>
<%
String path = request.getContextPath(); 
%>

</head>
<body >

<%
String keluaran = (String ) request.getAttribute("keluaran");
String masukan = (String) request.getAttribute("masukan"); 
%>


<center>

<div >
	<h2>Konversi Bilangan Ke Kalimat</h2>
	
	<p>Alat Konversi Dari Bilangan Ke Bahasa Indonesia</p>	
	<form method="post" action="simple"  >   
	    <table>
	    	<tr>
	    		<td>Bilangan Masukan:</td>
	    		<td><input type="text" name="bilanganMasukan" value="<%=masukan%>"/> 
	    		
	    		<td colspan="2"><input type="submit" value="Hitung" /> 
	    
	    	</tr>
	    	<tr style="position: relative; top:2px; text-align: top;">
	    		<td  valign="top" style="position: relative; top:2px; text-align: top;" >Hasil Konversi:</td>
	    		<td><%=keluaran%></td>
	    		<td></td>
	    	</tr>
	    	
	    </table>




	</form>
	
	

</div>



<div style="position: absolute; top: 350px; width:100%;">
<div style="position: relative; top:2px; " align="center">
	<small>Dibuat oleh: Mohammad Fajar</small>
</div>
</div>

</center>



</body>
</html>
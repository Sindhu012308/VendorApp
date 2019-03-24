<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Vendor Data</title>
</head>
<body>
<form action="updateData" method="post">
<pre>
Id: <input type="text" name="id" value="${vendorbyId.id}" readonly>
Code: <input type="text" name="code" value="${vendorbyId.code}">
Name: <input type="text" name="name" value="${vendorbyId.name}">
Type: <select name="type" >
   <option value=""
            hidden
    >Select</option>
  <option  ${vendorbyId.type=='Regular'?'selected':'' }>Regular</option>
  <option ${vendorbyId.type=='Contract'?'selected':'' }>Contract </option>
</select>
E-Mail: <input type="text" name="email" value="${vendorbyId.email}">
Phone#: <input type="text" name="phone" value="${vendorbyId.phone}">
Address: <textarea rows="4" cols="12" placeholder="Enter your Address here..." name="address" >${vendorbyId.address}</textarea>
<input type="submit" value="save" />
</pre>
</form>

</body>
</html>
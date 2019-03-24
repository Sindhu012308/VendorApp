<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Vendors</title>
</head>
<body>
<h3> Vendors:</h3>

<table>

<tr>
<th>ID</th>
<th>Code</th>
<th>Name</th>
<th>Type</th>
<th>Email</th>
<th>Phone#</th>
<th>Address</th>
</tr>

<c:forEach items="${allVendor}" var="vendor">
<tr>
<td> ${vendor.id} </td>
<td> ${vendor.code} </td>
<td> ${vendor.name} </td>
<td> ${vendor.type} </td>
<td> ${vendor.email} </td>
<td> ${vendor.phone} </td>
<td> ${vendor.address} </td>
<td> <a href="deleteVendor?id=${vendor.id}">Delete</a> </td>
<td> <a href="editVendor?id=${vendor.id}">Edit</a> </td>
</tr>
</c:forEach>

</table>

<a href="showCreate">Add Vendor</a>
<br>
<a href="generateReport">Pie-Chart for Vendor Types</a>
</body>
</html>
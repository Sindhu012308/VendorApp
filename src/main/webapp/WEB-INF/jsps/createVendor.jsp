<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Vendor</title>
</head>
<body>
<form action="SaveVendor" method="post">
<pre>
Id: <input type="text" name="id">
Code: <input type="text" name="code">
Name: <input type="text" name="name">
Type: <select name="type">
   <option value=""
            hidden
    >Select</option>
  <option value="Regular">Regular </option>
  <option  value="Contract">Contract</option>
</select>
E-Mail: <input type="text" name="email">
Phone#: <input type="text" name="phone">
Address: <textarea rows="4" cols="12" placeholder="Enter your Address here..." name="address"></textarea>
<input type="submit" value="save" />
</pre>
</form>
${mesg}
<br>
<a href="displayVendors">Display All Vendors</a> 
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>





<head>
<body background="https://files.fm/thumb_show.php?i=gpuqb4gb5">
  <meta charset="UTF-8">
  <title>User Form</title>
</head>

<form action="/addPerson" method="POST">

  <select name="name" />
  <option selected value disabled>Select your product</option>
    <option>Shishka</option>
    <option>Polshisho4ki</option>
  <option>Na_PolShishe4ki</option>
  <option>Ямайский закат</option>


  </select>
  <br><br>
  Weith product gram: <input name="number" />
  <br><br>

  <input type="submit" value="Submit" />
  <button><a href="/index.jsp">Think again</a></button>
</form>
</body>
</html>
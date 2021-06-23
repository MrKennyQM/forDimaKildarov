<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Result Page</h1>
<h2>They order from us: ${size}</h2>

<ol>

    <c:forEach items="${personList}" var="person" varStatus="loop">
        <li>  - <c:out value="${person.name}"/> : ${person.id} : <c:out value="${person.number}"/></li>
    </c:forEach>
</ol>

<a href="index.jsp">Think again</a>


</body>
</html>

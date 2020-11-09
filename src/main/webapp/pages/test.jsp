
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach begin="0" end="500" var="val">
    <c:out value="${val}"/>
<p>
</c:forEach>

</body>
</html>

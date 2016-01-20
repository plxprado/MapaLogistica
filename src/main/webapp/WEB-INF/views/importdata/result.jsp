<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Results for importing movies: &quot;${ids}&quot;</h2>

<p>Imported of ${fn:length(movies)} movies took ${duration} seconds.</p>

<dl>
    <c:forEach items="${movies}" var="entry">
        <dt>${entry.key}</dt>
        <dd>${entry.value}</dd>
    </c:forEach>
</dl>
</body>
</html>
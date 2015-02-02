<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hey!</title>
</head>
<body>
	
    <c:choose>
		<c:when test="${session.loggedin == true}">
			<p>Welcome, ${session.username}. Say HEY to someone.</p>
		</c:when>
		<c:otherwise>
			<p>Welcome, anonymous user. Say HEY to someone.</p>
		</c:otherwise>
	</c:choose>

	<%-- funcemina --%>
	<%--
    <c:forEach items="${heyBean.allUsers}" var="value">
		<a href="<s:url action="sayhey" />"><c:out value="${value}" /></a><br>
	</c:forEach>
	--%>

    <%--
    <c:forEach items="${heyBean.allUsers}" var="value">
		<c:out value="${value}" /><br>
	</c:forEach>
    --%>

	<%--
    <c:forEach items="${heyBean.allUsers}" var="value">
		<s:url action="sayhey" var="link" >
            <s:param name="user">User</s:param>
        </s:url>

        <p><a href="${link}">User Link</a></p>
	</c:forEach>
	--%>
	
	<c:forEach items="${heyBean.allUsers}" var="value">
		<%--
		<s:url action="sayhey" var="link" >
            <s:param name="user">User</s:param>
        </s:url>

        <p><a href="${link}">User Link</a></p>
        --%>
        
        <a href="<s:url action="sayhey"> <s:param name="user">${value}</s:param></s:url>"><c:out value="${value}" /></a><br>
	</c:forEach>
	
    <%--
    <s:url id="url" action="myTestAction">
        <s:param name="typeA">false</s:param>
    </s:url>
    <s:a href="%{url}" >My Link</s:a>
    --%>
    
    <p>You have ${heyBean.readHeys(session.username)} incoming heys!</p>

	<p><a href="<s:url action="index" />">Start</a></p>

</body>
</html>
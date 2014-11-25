<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
	<c:forEach items="${classifyLists}" var="entry" varStatus="statu">
		<li>
		<a href="${entry.category}" title="${entry.name}"> ${entry.name} (${entry.count})</a>
		</li>
	</c:forEach>
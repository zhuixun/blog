<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
	<c:forEach items="${pageView.records}" var="entry" varStatus="statu">
			<li>
				${statu.count}.<a href="/html/article/${entry.articletype.typeid}/${entry.id}.shtml" target="_blank" title="${entry.name}">${fn:substring(entry.name,0,30)}</a>
			</li>
	</c:forEach>
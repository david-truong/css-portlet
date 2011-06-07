<%@ include file="/init.jsp" %>

<%
CSSEntry globalEntry = null;
CSSEntry siteEntry = null;
CSSEntry pageEntry = null;

long companyId = layout.getCompanyId();
long layoutSetId = layout.getLayoutSet().getLayoutSetId();
long groupId = layout.getGroupId();
boolean privateLayout = layout.isPrivateLayout();

try {
	globalEntry = CSSEntryLocalServiceUtil.getLatestCSSEntry(PortalUtil.getClassNameId(Company.class), companyId);
}
catch (Exception e) {}

try {
	siteEntry = CSSEntryLocalServiceUtil.getLatestCSSEntry(PortalUtil.getClassNameId(LayoutSet.class), layoutSetId);
}
catch (Exception e) {}

try {
	pageEntry = CSSEntryLocalServiceUtil.getLatestCSSEntry(PortalUtil.getClassNameId(Layout.class), plid);
}
catch (Exception e) {}

%>

<c:if test="<%= !layout.getGroup().isControlPanel() %>">
	<c:if test="<%= globalEntry != null %>">
		<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPortalURL(request) + "/css-portlet/global.css", globalEntry.getModifiedDate().getTime())) %>" rel="stylesheet" type="text/css" />
	</c:if>
	<c:if test="<%= siteEntry != null %>">
		<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPortalURL(request) + "/css-portlet/site.css", "privateLayout=" + privateLayout + "&groupId=" + groupId, siteEntry.getModifiedDate().getTime())) %>" rel="stylesheet" type="text/css" />
	</c:if>
	<c:if test="<%= pageEntry != null %>">
		<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPortalURL(request) + "/css-portlet/page.css", "plid=" + plid, pageEntry.getModifiedDate().getTime())) %>" rel="stylesheet" type="text/css" />
	</c:if>
</c:if>
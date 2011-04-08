<%@ include file="/init.jsp" %>

<%
Portlet portlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletDisplay.getId());
%>

<link href="<%= PortalUtil.getLayoutFullURL(themeDisplay) %>/-/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%= PortalUtil.getLayoutFullURL(themeDisplay) %>/-/css/<%= themeDisplay.getLayout().isPrivateLayout() ? "private" : "public" %>/groupId/<%= themeDisplay.getScopeGroupId() %>/site.css" rel="stylesheet" type="text/css" />
<link href="<%= PortalUtil.getLayoutFullURL(themeDisplay) %>/-/css/plid/<%= themeDisplay.getPlid() %>/page.css" rel="stylesheet" type="text/css" />
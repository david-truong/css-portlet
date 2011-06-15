package com.liferay.portlet.css.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.service.CSSEntryLocalServiceUtil;
import com.liferay.util.servlet.ServletResponseUtil;

public class CSSServlet extends HttpServlet {

	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		
		response.setContentType(ContentTypes.TEXT_CSS_UTF8);
		
		String css = StringPool.BLANK;

		long classNameId = 0;
		long classPK = 0;

		String scope = request.getServletPath();

		if (scope.equals("/page.css")) {
			classNameId = PortalUtil.getClassNameId(Layout.class);
			classPK = ParamUtil.getLong(request, "plid");
		}
		else if (scope.equals("/site.css")) {
			boolean privateLayout = ParamUtil.getBoolean(request, "privateLayout");
			long groupId = ParamUtil.getLong(request, "groupId");
			try {
				classPK = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout).getLayoutSetId();
			}
			catch (Exception e) {}
			classNameId = PortalUtil.getClassNameId(LayoutSet.class);
		}
		else if (scope.equals("/global.css")) {
			classNameId = PortalUtil.getClassNameId(Company.class);
			classPK = PortalUtil.getCompanyId(request);
		}

		CSSEntry cssEntry = null;

		try {
			cssEntry = CSSEntryLocalServiceUtil.getLatestCSSEntry(classNameId, classPK);
			css = cssEntry.getCss();
		}
		catch (Exception e) {}
				
		ServletResponseUtil.write(
			response,
			css.getBytes(StringPool.UTF8));
	}
}

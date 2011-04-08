package com.liferay.portlet.css;

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
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
public class CSSPortlet extends MVCPortlet {

	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		resourceResponse.setContentType(ContentTypes.TEXT_CSS_UTF8);

		OutputStream outputStream = resourceResponse.getPortletOutputStream();

		try {
			outputStream.write(getCSS(resourceRequest));
		}
		finally {
			outputStream.close();
		}
	}

	protected byte[] getCSS(ResourceRequest resourceRequest)
		throws IOException {

		String css = StringPool.BLANK;

		long classNameId = 0;
		long classPK = 0;

		String scope = ParamUtil.getString(resourceRequest, "scope");

		if (scope.equals("page")) {
			classNameId = PortalUtil.getClassNameId(Layout.class);
			classPK = ParamUtil.getLong(resourceRequest, "plid");
		}
		else if (scope.equals("site")) {
			boolean privateLayout = ParamUtil.getBoolean(resourceRequest, "privateLayout");
			long groupId = ParamUtil.getLong(resourceRequest, "groupId");
			try {
				classPK = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout).getLayoutSetId();
			}
			catch (Exception e) {}
			classNameId = PortalUtil.getClassNameId(LayoutSet.class);
		}
		else if (scope.equals("global")) {
			classNameId = PortalUtil.getClassNameId(Company.class);
			classPK = PortalUtil.getCompanyId(resourceRequest);
		}

		CSSEntry cssEntry = null;

		try {
			cssEntry = CSSEntryLocalServiceUtil.getLatestCSSEntry(classNameId, classPK);
			css = cssEntry.getCss();
		}
		catch (Exception e) {}

		return css.getBytes(StringPool.UTF8);
	}
}
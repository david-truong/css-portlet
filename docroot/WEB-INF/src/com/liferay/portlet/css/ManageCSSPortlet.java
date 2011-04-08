package com.liferay.portlet.css;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.service.CSSEntryLocalServiceUtil;
import com.liferay.portlet.css.util.CSSUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
public class ManageCSSPortlet extends MVCPortlet {

	public void updateCSS(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long classNameId = ParamUtil.getLong(actionRequest, "classNameId");
		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		double version = ParamUtil.getDouble(actionRequest, "version");

		String css = ParamUtil.getString(actionRequest, "css");
		String cmd = ParamUtil.getString(actionRequest, "cmd");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			CSSEntry.class.getName(), actionRequest);

		if (cmd.equals("new")) {
			CSSEntryLocalServiceUtil.addEntry(
				classNameId, classPK, css, serviceContext);
		}
		if (cmd.equals("save")) {
			CSSEntryLocalServiceUtil.updateEntry(
				classNameId, classPK, version, css, serviceContext);
		}
		else if (cmd.equals("increment")) {
			CSSEntryLocalServiceUtil.addEntry(
				classNameId, classPK, CSSUtil.increment(version), css,
				serviceContext);
		}
		else if (cmd.equals("delete")) {
			CSSEntryLocalServiceUtil.deleteCSSEntry(
				classNameId, classPK, version);
		}

	}

}
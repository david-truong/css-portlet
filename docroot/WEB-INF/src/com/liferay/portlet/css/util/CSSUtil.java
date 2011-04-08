package com.liferay.portlet.css.util;

import com.liferay.portal.kernel.util.StringUtil;
public class CSSUtil {

	public static String encodeJSON(String text) {
		return StringUtil.replace(text, '\\', "\\\\");
	}
	
	public static double increment(double version) {
		return version + 1.0;
	}

	public static double NEW_VERSION = 1.0;
}
package com.liferay.portlet.css.lar;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BasePortletDataHandler;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.portal.kernel.lar.PortletDataHandlerControl;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.service.CSSEntryLocalServiceUtil;
import com.liferay.portlet.css.service.persistence.CSSEntryUtil;

public class CSSPortletDataHandlerImpl extends BasePortletDataHandler {

	public PortletDataHandlerControl[] getExportControls() {
		return new PortletDataHandlerControl[] {
				_entries
			};
		}

	public PortletDataHandlerControl[] getImportControls() {
		return new PortletDataHandlerControl[] {
			_entries
		};
	}
	
	public boolean isAlwaysExportable() {
		return _ALWAYS_EXPORTABLE;
	}
	
	public boolean isPublishToLiveByDefault() {
		return _PUBLISH_TO_LIVE_BY_DEFAULT;
	}

	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		if (!portletDataContext.addPrimaryKey(
				CSSPortletDataHandlerImpl.class, "deleteData")) {

			CSSEntryLocalServiceUtil.deleteCSSEntryByGroupId(
				portletDataContext.getScopeGroupId());
		}

		return null;
	}

	protected String doExportData(
			PortletDataContext context, String portletId,
			PortletPreferences preferences)
		throws Exception {

		context.addPermissions(
			"com.liferay.portlet.css", context.getScopeGroupId());

		Document document = SAXReaderUtil.createDocument();

		Element rootElement = document.addElement("css-data");

		rootElement.addAttribute(
			"group-id", String.valueOf(context.getScopeGroupId()));

		List<CSSEntry> entries = new ArrayList<CSSEntry>();
		
		entries.addAll(CSSEntryUtil.findByGroupId(
			context.getScopeGroupId()));

		//entries.addAll(CSSEntryUtil.findByClassNameId_ClassPK(PortalUtil.getClassNameId(Company.class), context.getCompanyId()));
		
		for (CSSEntry entry : entries) {
			exportEntry(context, rootElement, entry);
		}

		return document.formattedString();
	}

	protected void exportEntry(
			PortletDataContext context, Element root, CSSEntry entry)
		throws PortalException, SystemException {

		if (!context.isWithinDateRange(entry.getModifiedDate())) {
			return;
		}

		if (entry.getStatus() != WorkflowConstants.STATUS_APPROVED) {
			return;
		}

		String path = getEntryPath(context, entry);

		if (!context.isPathNotProcessed(path)) {
			return;
		}

		Element entryElement = root.addElement("entry");

		entryElement.addAttribute("path", path);

		context.addPermissions(CSSEntry.class, entry.getCssEntryId());

		context.addZipEntry(path, entry);
	}

	protected String getEntryPath(
		PortletDataContext context, CSSEntry entry) {

		StringBundler sb = new StringBundler(4);

		sb.append(context.getPortletPath("1_WAR_cssportlet"));
		sb.append("/entries/");
		sb.append(entry.getCssEntryId());
		sb.append(".xml");

		return sb.toString();
	}

	protected PortletPreferences doImportData(
			PortletDataContext context, String portletId,
			PortletPreferences preferences, String data)
		throws Exception {

		context.importPermissions(
			"com.liferay.portlet.css", context.getSourceGroupId(),
			context.getScopeGroupId());

		Document document = SAXReaderUtil.read(data);

		Element rootElement = document.getRootElement();

		for (Element entryElement : rootElement.elements("entry")) {
			String path = entryElement.attributeValue("path");

			if (!context.isPathNotProcessed(path)) {
				continue;
			}

			CSSEntry entry = (CSSEntry)context.getZipEntryAsObject(path);

			importEntry(context, entry);
		}

		return null;
	}

	protected void importEntry(PortletDataContext context, CSSEntry entry)
		throws Exception {

		int status = entry.getStatus();
		
		long scopeGroupId = context.getScopeGroupId();

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCreateDate(entry.getCreateDate());
		serviceContext.setModifiedDate(entry.getModifiedDate());
		serviceContext.setScopeGroupId(scopeGroupId);

		if (status != WorkflowConstants.STATUS_APPROVED) {
			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);
		}

		CSSEntry importedEntry = null;

		long classPK = entry.getClassPK();
		
		if (entry.getClassNameId() == PortalUtil.getClassNameId(LayoutSet.class)) {
			
			Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
			
			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(classPK);
			
			if (layoutSet.isPrivateLayout()) {
				classPK = group.getPrivateLayoutSet().getLayoutSetId(); 
			}
			else {
				classPK = group.getPublicLayoutSet().getLayoutSetId();
			}
		}
		else if (entry.getClassNameId() == PortalUtil.getClassNameId(Layout.class)) {
			Layout layout = LayoutLocalServiceUtil.getLayout(classPK);
			
			classPK = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(
				layout.getUuid(), scopeGroupId).getPlid();
		}
		
		if (context.isDataStrategyMirror()) {
			CSSEntry existingEntry = CSSEntryUtil.fetchByUUID_G(
				entry.getUuid(), scopeGroupId);

			if (existingEntry == null) {
				serviceContext.setUuid(entry.getUuid());

				importedEntry = CSSEntryLocalServiceUtil.addEntry(
					entry.getClassNameId(), classPK,
					entry.getVersion(), entry.getCss(),
					serviceContext);
			}
			else {
				importedEntry = CSSEntryLocalServiceUtil.updateEntry(
					entry.getClassNameId(), classPK, entry.getVersion(), 
					entry.getCss(), serviceContext);
			}
		}
		else {
			importedEntry = CSSEntryLocalServiceUtil.addEntry(
				entry.getClassNameId(), classPK,
				entry.getVersion(), entry.getCss(),
				serviceContext);
		}

		context.importPermissions(
			CSSEntry.class, entry.getCssEntryId(), 
			importedEntry.getCssEntryId());
	}
	
	private static final boolean _ALWAYS_EXPORTABLE = true;

	private static final String _NAMESPACE = "css";
	
	private static final boolean _PUBLISH_TO_LIVE_BY_DEFAULT = true;

	private static PortletDataHandlerBoolean _entries =
		new PortletDataHandlerBoolean(_NAMESPACE, "entries", true);

}
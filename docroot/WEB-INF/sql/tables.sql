create table CSS_CSSEntry (
	uuid_ VARCHAR(75) null,
	cssEntryId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	css TEXT null,
	classNameId LONG,
	classPK LONG,
	groupId LONG,
	version DOUBLE,
	status INTEGER,
	statusDate DATE null
);
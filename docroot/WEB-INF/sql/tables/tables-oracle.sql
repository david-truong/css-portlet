create table CSS_CSSEntry (
	uuid_ varchar2(300) null,
	cssEntryId number(30,0) not null primary key,
	createDate timestamp null,
	modifiedDate timestamp null,
	css clob null,
	classNameId number(30,0),
	classPK number(30,0),
	groupId number(30,0),
	version number(30,20),
	status number(30,0),
	statusDate timestamp null
);

create table CSS_CSSEntry (
	uuid_ varchar(75),
	cssEntryId bigint not null primary key,
	createDate timestamp,
	modifiedDate timestamp,
	css clob,
	classNameId bigint,
	classPK bigint,
	groupId bigint,
	version double,
	status integer,
	statusDate timestamp
);

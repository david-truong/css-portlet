create table CSS_CSSEntry (
	uuid_ varchar(75),
	cssEntryId int64 not null primary key,
	createDate timestamp,
	modifiedDate timestamp,
	css blob,
	classNameId int64,
	classPK int64,
	groupId int64,
	version double precision,
	status integer,
	statusDate timestamp
);

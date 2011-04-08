create table CSS_CSSEntry (
	uuid_ varchar(75) null,
	cssEntryId bigint not null primary key,
	createDate timestamp null,
	modifiedDate timestamp null,
	css text null,
	classNameId bigint,
	classPK bigint,
	groupId bigint,
	version double precision,
	status integer,
	statusDate timestamp null
);

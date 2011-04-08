create table CSS_CSSEntry (
	uuid_ varchar(75) null,
	cssEntryId bigint not null primary key,
	createDate timestamp null,
	modifiedDate timestamp null,
	css longvarchar null,
	classNameId bigint,
	classPK bigint,
	groupId bigint,
	version double,
	status int,
	statusDate timestamp null
);

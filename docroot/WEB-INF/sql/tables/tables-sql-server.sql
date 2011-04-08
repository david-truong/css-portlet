create table CSS_CSSEntry (
	uuid_ nvarchar(75) null,
	cssEntryId bigint not null primary key,
	createDate datetime null,
	modifiedDate datetime null,
	css ntext null,
	classNameId bigint,
	classPK bigint,
	groupId bigint,
	version float,
	status int,
	statusDate datetime null
);

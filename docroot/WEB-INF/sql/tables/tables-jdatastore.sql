create table CSS_CSSEntry (
	uuid_ varchar(75) null,
	cssEntryId bigint not null primary key,
	createDate date null,
	modifiedDate date null,
	css long varchar null,
	classNameId bigint,
	classPK bigint,
	groupId bigint,
	version double,
	status integer,
	statusDate date null
);

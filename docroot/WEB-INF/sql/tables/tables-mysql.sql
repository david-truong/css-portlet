create table CSS_CSSEntry (
	uuid_ varchar(75) null,
	cssEntryId bigint not null primary key,
	createDate datetime null,
	modifiedDate datetime null,
	css longtext null,
	classNameId bigint,
	classPK bigint,
	groupId bigint,
	version double,
	status integer,
	statusDate datetime null
) engine InnoDB;

create table CSS_CSSEntry (
	uuid_ varchar(75) null,
	cssEntryId decimal(20,0) not null primary key,
	createDate datetime null,
	modifiedDate datetime null,
	css text null,
	classNameId decimal(20,0),
	classPK decimal(20,0),
	groupId decimal(20,0),
	version float,
	status int,
	statusDate datetime null
)
go

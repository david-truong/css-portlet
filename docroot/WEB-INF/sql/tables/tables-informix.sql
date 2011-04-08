create table CSS_CSSEntry (
	uuid_ varchar(75),
	cssEntryId int8 not null primary key,
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	css text,
	classNameId int8,
	classPK int8,
	groupId int8,
	version float,
	status int,
	statusDate datetime YEAR TO FRACTION
)
extent size 16 next size 16
lock mode row;

create index IX_43240FC6 on CSS_CSSEntry (classNameId, classPK);
create unique index IX_EADAC502 on CSS_CSSEntry (classNameId, classPK, version);
create index IX_D301D399 on CSS_CSSEntry (groupId);
create index IX_C3797863 on CSS_CSSEntry (uuid_);
create unique index IX_9C99BBA7 on CSS_CSSEntry (uuid_, groupId);
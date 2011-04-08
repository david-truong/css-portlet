drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;



create index IX_43240FC6 on CSS_CSSEntry (classNameId, classPK);
create unique index IX_EADAC502 on CSS_CSSEntry (classNameId, classPK, version);
create index IX_D301D399 on CSS_CSSEntry (groupId);
create index IX_E13E9D2E on CSS_CSSEntry (groupId, classNameId, classPK);
create unique index IX_3B24CC9A on CSS_CSSEntry (groupId, classNameId, classPK, version);
create index IX_C3797863 on CSS_CSSEntry (uuid_);
create unique index IX_9C99BBA7 on CSS_CSSEntry (uuid_, groupId);



quit
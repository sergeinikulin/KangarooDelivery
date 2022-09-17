CREATE SCHEMA reports;

--посылка todo посылки не будет тут
create table reports.package
(
    id                              uuid not null primary key,
    active                          boolean
);

INSERT INTO reports.package VALUES ('23b54eb8-0f4f-4442-aa56-51320c5c6fa1', true);
INSERT INTO reports.package VALUES ('6d05f295-2f31-444b-b96b-817295f85aec', null);
INSERT INTO reports.package VALUES ('d485207c-8318-405c-aeff-9b4c2291bc7c', false);
INSERT INTO reports.package VALUES ('44177394-d88b-426c-a348-12b4a66855e2', true);
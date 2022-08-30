create table tbl_Todos(
task_id number primary key;
title varchar2(50),
description  varchar2(500),
completed  varchar2(20),
assigned_Date date,
updated_Date date
);

---------------------
insert into tbl_Todos(TASK_ID,TITLE,DESCRIPTION,COMPLETED,ASSIGNED_DATE) values(101,'Create rest api','Todos rest api','COMPLETED',sysdate);

update tbl_todos set TITLE='Create rest api.',DESCRIPTION='Create rest api with db.',COMPLETED='PENDING', UPDATED_DATE=sysdate where TASK_ID=101;

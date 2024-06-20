create table member (
                    no number primary key,
                    id varchar2(64) not null unique,
                    password varchar2(64) not null,
                    nickname varchar2(32) not null unique,
                    regdate date not null
                    );
                    
select * from member;

-- primary key  확인 하기 테이블명은 대문자여야함
select * from user_constraints where table_name = 'MEMBER';

create sequence member_seq  start with 1
                            increment by 1
                            maxvalue 99999
                            nocycle nocache noorder;

-- 생성한 시퀀스 확인
 select * from user_sequences;
 
 select member_seq.currval from dual;
 
 select member_seq.nextval from dual;


-- insert
 insert into member (no, id, password, nickname, regdate)
 values (member_seq.nextval, 'id001', 'pwd001', 'nick001', sysdate);
 
 
 -- select
select * from member;
select * from member where no=2;

 
-- delete
delete member where no=1;


 -- update
update member
set password='pwd02', nickname='nick002'
where no=1;
 
commit;

select * from member;
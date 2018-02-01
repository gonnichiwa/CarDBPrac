/*
 * CarInfoDDL.sql : DDL,DML 다 포함된 sql파일. 이름 잘 못정했당.. ㅜㅜ
 * */

create table carInfo (
	ciNum int primary key,
	ciName varchar2(30) not null,
	ciMaker varchar2(30) not null,
	ciPrice int not null
);

create sequence seq_carInfo_ciNum
start with 1
increment by 1
nomaxvalue;

insert into carInfo(ciNum,ciName,ciMaker,ciPrice) values (seq_carInfo_ciNum.nextval,'아반떼','횬대',2000);
insert into carInfo(ciNum,ciName,ciMaker,ciPrice) values (seq_carInfo_ciNum.nextval,'k3','기아',2200);
insert into carInfo(ciNum,ciName,ciMaker,ciPrice) values (seq_carInfo_ciNum.nextval,'말리부','GM',2700);
insert into carInfo(ciNum,ciName,ciMaker,ciPrice) values (seq_carInfo_ciNum.nextval,'그랜저','현대',5000);

-- carInfo 테이블의 전체 자료 조회
select * from carInfo;

-- ciNum이 5인 carInfo 칼럼 모두를 조회 하시오 (where절)
select * from carInfo where ciNum = 5;






/*
 * CarInfoDDL.sql
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




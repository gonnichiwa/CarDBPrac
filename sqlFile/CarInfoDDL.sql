/*
 * CarInfoDDL.sql : DDL,DML 다 포함된 sql파일. 이름 잘 못정했당.. ㅜㅜ
 * */
drop table carInfo;

create table carInfo (
	ciNum int primary key, -- 정보번호
	ciName varchar2(30) not null, -- 차명
	ciMaker varchar2(30) not null, -- 제조사
	ciPrice int not null, -- 가격
  ciColor varchar2(20) not null, -- 차색깔
  ciWidth int not null, -- 폭(cm)
  ciHeight int not null -- 높이(cm)
);

create sequence seq_carInfo_ciNum
start with 1
increment by 1
nomaxvalue;

insert into carInfo(ciNum,ciName,ciMaker,ciPrice,ciColor,ciWidth,ciHeight) 
values (seq_carInfo_ciNum.nextval,'아반떼','횬대',2000,'흰색',500,150);
insert into carInfo(ciNum,ciName,ciMaker,ciPrice,ciColor,ciWidth,ciHeight) 
values (seq_carInfo_ciNum.nextval,'k3','기아',2200,'검은색',480,160);
insert into carInfo(ciNum,ciName,ciMaker,ciPrice,ciColor,ciWidth,ciHeight) 
values (seq_carInfo_ciNum.nextval,'말리부','GM',2700,'흰색',520,165);
insert into carInfo(ciNum,ciName,ciMaker,ciPrice,ciColor,ciWidth,ciHeight) 
values (seq_carInfo_ciNum.nextval,'그랜저','현대',5000,'검은색',550,200);

-- carInfo 테이블의 전체 자료 조회
select * from carInfo;

-- ciNum이 5인 carInfo 칼럼 모두를 조회 하시오 (where절)
select * from carInfo where ciNum = 22;
commit;






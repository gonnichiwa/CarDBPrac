-- test
select * from products;
/* 복수행 함수 (sum,avg) */
-- 합(sum) : OrderItems 테이블(주문정보)전체 가격
select sum(item_price) from orderItems;
-- 평균(avg) : OrderItems 테이블(주문정보)의 평균 주문 가격
select avg(item_price) from orderItems;

-- 전체 물품 정보
select * from products;
-- products 테이블 정보
-- prod_id : 물품 구분 아이디
-- vend_id : 물품 제조사 아이디
-- prod_name : 물품 제목
-- prod_price : 물품 가격
-- prod_desc : 물품 간단 설명
/* products 테이블의 vend_id가 BRS01인 물품의 평균 가격을 avg_price로 나타내시오 */
select avg(prod_price) as avg_price from products where vend_id='BRS01';

/* OrderItems 테이블의 Prod_id가 BR03인 주문정보의 전체 가격과 평균 가격을 나타내시오. */
/*
1. OrdersItem 테이블의 전체 목록을 출력하는 쿼리 작성 : select * from OrderItems;
2. Prod_id가 BR03인 주문정보의 전체 목록을 출력하는 쿼리: select * from OrderItems where prod_id='BR03';
3. 전체 가격과 평균 가격을 나타내시오. : select sum(item_price), avg(item_price) from OrderItems where prod_id='BR03';
*/
select sum(item_price), avg(item_price) from orderItems where prod_id = 'BR03';

/* count() 함수 : 갯수를 구하는 함수 */
select * from customers;
-- 전체 고객의 수를 집계
select count(*) from customers;
-- 이메일 주소가 있는 고객의 수
select count(cust_email) from customers; -- 3명

/* max(컬럼이름) 컬럼 데이터중 최대값 min(컬럼이름) 컬럼 데이터 중 최소값*/
select * from products;
-- products 테이블에서 가장 비싼 가격이 뭔가요?
select max(prod_price) from products; -- prod_price컬럼의 전체 데이터중 최대값을 나타냄

-- 제품(Products) 테이블에서 제품의 종류별 갯수를 나타내시오
select * from products;
select vend_id, count(*) as num_prods from products group by vend_id;

/* 주문정보(OrderItems)테이블에서 
제품 종류별(Prod_id)별 주문 건수, 종류별 주문수량(quantity)의 합, 주문금액(item_price) 합계 를 나타내시오 */
select prod_id,count(*),sum(quantity),sum(item_price) from orderItems group by prod_id;

/* 모든 주문 정보를 출력 */
select * from orders;
-- 주문자ID별 주문 갯수를 출력 하시오
select cust_id, count(*) from orders group by cust_id;
-- 주문자 ID별로 주문 갯수를 출력 하는데, 주문수가 2건 이상인 고객만 출력
select cust_id, count(*) from orders group by cust_id having count(*) >= 2;

/* Products 테이블의 모든 정보를 출력 하시오 */
select * from Products;
-- vend_id(제조사ID) 별로 몇개의 products들이 있는지 출력하시오
select vend_id, count(*) from products group by vend_id;
/* vend_id(제조사ID) 별로 2가지 이상의 제품을 가지고 있는 vend_id와 */
/* 그 가짓수를 출력하시오 */
select vend_id, count(*) from Products group by vend_id having count(*) >=2;

/* where절 */
-- prod_price(제품가격)이 4딸라 이상인 모든 제품을 검색 하시오.
select * from products where prod_price >= 4;
select * from products;
-- 1. 제품의 가격이 4딸라 이상인 것중
-- 2. 제품 가짓수가 2가지 이상인 vend_id별 제품 갯수를 출력
select vend_id, count(*) from products 
where prod_price >= 4 
group by vend_id
having count(*) >=2;

select * from orderItems;
-- orderItems 테이블에서
-- Item_Price(제품가격)가 5딸라 이상인 주문제품들 중
-- PROD_ID(제품ID) 별로 주문 갯수, 주문수량, 주문총가격을 출력 하시오
select prod_id,count(*),sum(quantity),sum(item_price) 
from orderItems 
where item_price >= 5 group by prod_id;


select * from customers;
-- customers 테이블에서 email주소가 있는 사람이 몇명인지 를 출력하시오
select count(cust_email) from customers;
-- OrderItems 테이블에서
-- 주문번호(order_num)별로 주문건수가 3건 이상인 주문건수와 주문번호를 출력하시오.
select order_num, count(*) from orderItems 
group by order_num
having count(*) >= 3;
-- OrderItems 테이블에서
-- 주문번호(order_num)별로 주문건수가 3건 이상인 주문건수와 주문번호를 출력하시오.
-- 주문번호는 오름차순으로 정렬 (order by절)
select count(*) as 주문갯수, order_num from orderItems 
group by order_num
having count(*) >= 3
order by 주문갯수 desc, order_num asc; -- 정렬기준 칼럼을 작성한 순서대로 정렬을 수행
























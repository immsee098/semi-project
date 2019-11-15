/* 회원정보 */

/* 시퀀스 4개 만들기 */

insert into PdTable
	values(seq_pd.nextval,'고래밥3',500,30,'라두와 친구들','C:\Users\dbstj\Desktop\semi-project-master\src\semi\project\com\image\whaleMeal.jpg');
	commit;

select * from memtable;
select * from carttable;
select * from pdtable;
select * from orderedtable;

Create Sequence seq_mem
    start with 1
    increment by 1
    nomaxvalue;
    
Create Sequence seq_pd
    start with 1
    increment by 1
    nomaxvalue;
 
Create Sequence seq_cart
    start with 1
    increment by 1
    nomaxvalue;
    
Create Sequence seq_ordered
    start with 1
    increment by 1
    nomaxvalue;

select * from MemTable;

insert into MemTable
values(seq_mem.nextval, 'bc@gmail.com', 'qwerty1234','윤해서', '가나다', '010-2605-1111', 10);

CREATE TABLE MemTable (
	MemNo NUMBER NOT NULL, /* 회원번호 */
	Email VARCHAR2(30) NOT NULL, /* 이메일 */
	Pwd VARCHAR2(20) NOT NULL, /* 비밀번호 */
	MemName VARCHAR2(10) NOT NULL, /* 이름 */
	Address VARCHAR2(80), /* 주소 */
	Phone VARCHAR2(20), /* 전화번호 */
	Mileage NUMBER DEFAULT 0 /* 마일리지 */
);

CREATE UNIQUE INDEX MemberTable
	ON MemTable (
		MemNo ASC
	);

ALTER TABLE MemTable
	ADD
		CONSTRAINT MemberTable
		PRIMARY KEY (
			MemNo
		);

/* 상품 */

CREATE TABLE PdTable (
	PdNo NUMBER NOT NULL, /* 상품번호 */
	PdName VARCHAR2(20) NOT NULL, /* 상품명 */
	PdPrice NUMBER NOT NULL, /* 상품가격 */
	PdQty NUMBER NOT NULL, /* 상품재고 */
	PdDesc VARCHAR2(80), /* 상품내용 */
	PdImg VARCHAR2(100) /* 상품이미지 */
);

select * from pdtable;

update PdTable 
set PdName='이삼사2', PdPrice=21000, PdQty=15, PdDesc='가나다라마바사', PdImg='ddddd'
where PdNo=101;

insert into PdTable
values(seq_pd.nextval, '이삼사', 10400, 5, '상품설명', 'http://www...');

select * from MemTable;

commit;

CREATE UNIQUE INDEX PdTable
	ON PdTable (
		PdNo ASC
	);

ALTER TABLE PdTable
	ADD
		CONSTRAINT PdTable
		PRIMARY KEY (
			PdNo
		);

/* 장바구니 */
CREATE TABLE CartTable (
	OrderNo NUMBER NOT NULL, /* 주문상세번호 */
	PdNo NUMBER NOT NULL, /* 상품번호 */
	OrderQty NUMBER NOT NULL, /* 수량 */
	MemNo NUMBER NOT NULL /* 회원번호 */
);

select * from carttable;

 /*drop table CartTable cascade constraints;*/

CREATE UNIQUE INDEX CartTable
	ON CartTable (
		OrderNo ASC
	);
	
	select * from CartTable;
	
	insert into CartTable
	values(seq_cart, 100, 2, 3);

ALTER TABLE CartTable
	ADD
		CONSTRAINT CartTable
		PRIMARY KEY (
			OrderNo
		);


/* 주문내역 */
CREATE TABLE OrderedTable (
	No NUMBER NOT NULL, /* 넘버 */
	OrderDate DATE DEFAULT sysdate NOT NULL, /* 주문일자 */
	PdNo NUMBER NOT NULL, /* 상품번호 */
	OrderQty NUMBER NOT NULL, /* 수량 */
	MemNo NUMBER NOT NULL /* 회원번호 */
);

CREATE UNIQUE INDEX OrderedTable
	ON OrderedTable (
		No ASC
	);

ALTER TABLE OrderedTable
	ADD
		CONSTRAINT OrderedTable
		PRIMARY KEY (
			No
		);

ALTER TABLE CartTable
	ADD
		CONSTRAINT FK_PdTable_TO_CartTable
		FOREIGN KEY (
			PdNo
		)
		REFERENCES PdTable (
			PdNo
		);

ALTER TABLE CartTable
	ADD
		CONSTRAINT FK_MemTable_TO_CartTable
		FOREIGN KEY (
			MemNo
		)
		REFERENCES MemTable (
			MemNo
		);
		


/*
drop table memtable cascade constraints;
drop table pdtable cascade constraints;
drop table carttable cascade constraints;
drop table orderedtable cascade constraints;
*/
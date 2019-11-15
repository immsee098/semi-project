/* ȸ������ */

/* ������ 4�� ����� */

insert into PdTable
	values(seq_pd.nextval,'����3',500,30,'��ο� ģ����','C:\Users\dbstj\Desktop\semi-project-master\src\semi\project\com\image\whaleMeal.jpg');
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
values(seq_mem.nextval, 'bc@gmail.com', 'qwerty1234','���ؼ�', '������', '010-2605-1111', 10);

CREATE TABLE MemTable (
	MemNo NUMBER NOT NULL, /* ȸ����ȣ */
	Email VARCHAR2(30) NOT NULL, /* �̸��� */
	Pwd VARCHAR2(20) NOT NULL, /* ��й�ȣ */
	MemName VARCHAR2(10) NOT NULL, /* �̸� */
	Address VARCHAR2(80), /* �ּ� */
	Phone VARCHAR2(20), /* ��ȭ��ȣ */
	Mileage NUMBER DEFAULT 0 /* ���ϸ��� */
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

/* ��ǰ */

CREATE TABLE PdTable (
	PdNo NUMBER NOT NULL, /* ��ǰ��ȣ */
	PdName VARCHAR2(20) NOT NULL, /* ��ǰ�� */
	PdPrice NUMBER NOT NULL, /* ��ǰ���� */
	PdQty NUMBER NOT NULL, /* ��ǰ��� */
	PdDesc VARCHAR2(80), /* ��ǰ���� */
	PdImg VARCHAR2(100) /* ��ǰ�̹��� */
);

select * from pdtable;

update PdTable 
set PdName='�̻��2', PdPrice=21000, PdQty=15, PdDesc='�����ٶ󸶹ٻ�', PdImg='ddddd'
where PdNo=101;

insert into PdTable
values(seq_pd.nextval, '�̻��', 10400, 5, '��ǰ����', 'http://www...');

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

/* ��ٱ��� */
CREATE TABLE CartTable (
	OrderNo NUMBER NOT NULL, /* �ֹ��󼼹�ȣ */
	PdNo NUMBER NOT NULL, /* ��ǰ��ȣ */
	OrderQty NUMBER NOT NULL, /* ���� */
	MemNo NUMBER NOT NULL /* ȸ����ȣ */
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


/* �ֹ����� */
CREATE TABLE OrderedTable (
	No NUMBER NOT NULL, /* �ѹ� */
	OrderDate DATE DEFAULT sysdate NOT NULL, /* �ֹ����� */
	PdNo NUMBER NOT NULL, /* ��ǰ��ȣ */
	OrderQty NUMBER NOT NULL, /* ���� */
	MemNo NUMBER NOT NULL /* ȸ����ȣ */
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
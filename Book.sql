
--BOOK ���̺� ����
CREATE TABLE BOOK (
   id VARCHAR2(999) NOT NULL primary key,
   title VARCHAR2(999) NOT NULL,
   author VARCHAR2(999) NOT NULL,
   publisher VARCHAR2(999) NOT NULL,
   price VARCHAR2(999) NOT NULL
);

--�� ������ ����
CREATE SEQUENCE BOOK_seq 
START WITH 5  -- 1����
INCREMENT BY 1  -- 1�� ����
MAXVALUE 99999  -- 99999����
NOCYCLE 
NOCACHE 
NOORDER;

SELECT * FROM BOOK order by id; --���̺� üũ

--������ INSERT 
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2401', '���� ���� �ڹ� ���α׷��� 2��', '������', '�Ѻ���ī����', '20000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2402', '�ڵ� �����н� HTML+CSS+�ڹٽ�ũ��Ʈ', '����', '���', '30000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2403', 'Do It! �ڷᱸ���� �Բ� ���� �˰��� �Թ� - �ڹ���', '����ù�Ÿ', '�������ۺ���', '25000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2404', '�޴� �ȳ�', '�Ͼ߽� ��Ű��', '����', '10000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2407', '�нǻ��ΰ���', '��Ÿ�� ���', '�ѽ��̵��', '16500');
commit;
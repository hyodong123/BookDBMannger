
--BOOK 테이블 생성
CREATE TABLE BOOK (
   id VARCHAR2(999) NOT NULL primary key,
   title VARCHAR2(999) NOT NULL,
   author VARCHAR2(999) NOT NULL,
   publisher VARCHAR2(999) NOT NULL,
   price VARCHAR2(999) NOT NULL
);

--북 시퀀스 생성
CREATE SEQUENCE BOOK_seq 
START WITH 5  -- 1부터
INCREMENT BY 1  -- 1씩 증가
MAXVALUE 99999  -- 99999까지
NOCYCLE 
NOCACHE 
NOORDER;

SELECT * FROM BOOK order by id; --테이블 체크

--데이터 INSERT 
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2401', '쉽게 배우는 자바 프로그래밍 2판', '우종정', '한빛아카데미', '20000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2402', '코딩 자율학습 HTML+CSS+자바스크립트', '김기수', '길벗', '30000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2403', 'Do It! 자료구조와 함께 배우는 알고리즘 입문 - 자바편', '보요시바타', '이지스퍼블리싱', '25000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2404', '달님 안녕', '하야시 아키코', '보림', '10000');
INSERT INTO BOOK (id, title, author, publisher, price)
VALUES ('2407', '밀실살인게임', '우타노 쇼고', '한스미디어', '16500');
commit;
-- Active: 1728460757606@@127.0.0.1@3306@board
-- 회원가입
INSERT INTO user VALUES ('email@email.com', 'P!ssw0rd','nickname','01012345678','서울시 구로구','롯데백화점',null);

-- 로그인
SELECT * FROM user WHERE email = 'email@email.com';

-- 게시물 작성 
INSERT INTO board (title, content, write_datetime, favorite_count, comment_count, view_count, writer_email)
VALUES ('제목입니다.' , '내용 입니다.', '2024-10-09 18::44' ,0, 0, 0, 'email@email.com');

INSERT INTO image VALUES (1, 'url');

-- 댓글 작성
INSERT INTO comment (content, write_datetime, user_email, board_number)  VALUES ('반갑습니다.', '2024-10-09 17:37' , 'email@email.com', 1);

UPDATE board SET comment_count = comment_count + 1 WHERE board_number = 1;

-- 좋아요 
INSERT INTO favorite VALUES ('email@email.com', 1);

UPDATE board SET favorite_count = favorite_count + 1 WHERE board_number = 1;


DELETE FROM favorite WHERE user_email = 'email@email.com' AND board_number = 1;


UPDATE board SET favorite_count = favorite_count - 1 WHERE board_number = 1;


-- 게시물 수정 
UPDATE board SET title = '수정 제목입니다.', content = '수정 내용입니다.' WHERE board_number = 1;

DELETE FROM image WHERE board_number = 1; 

INSERT INTO image VALUES (1 , 'url');

-- 게시물 삭제 
DELETE FROM comment WHERE board_number = 1;

DELETE FROM favorite WHERE board_number = 1;

DELETE FROM board WHERE board_number = 1;


--





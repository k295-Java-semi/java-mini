-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS pension_db;
USE pension_db;

-- user 테이블
CREATE TABLE `user` (
    `user_id` INT NOT NULL PRIMARY KEY auto_increment,
    `name` VARCHAR(30) not NULL,
    `phone` VARCHAR(50) not NULL,
    `email` VARCHAR(50) not NULL,
    `password` VARCHAR(30) not NULL,
    `role` ENUM('guest', 'admin') NOT NULL DEFAULT 'guest'
);

-- room 테이블
CREATE TABLE `room` (
    `room_id` INT NOT NULL PRIMARY KEY auto_increment,
    `room_number` VARCHAR(10)  NOT NULL,
    `type` ENUM('A', 'B', 'C') NOT NULL DEFAULT 'A',
    `price` int NULL,
    `capacity` INT NULL,
    `size` VARCHAR(10) NULL,
    `description` VARCHAR(50) NULL,
     `available` ENUM('Y', 'N') not NULL DEFAULT 'Y'
);

-- booking_detail 테이블
CREATE TABLE `booking_detail` (
    `booking_detail_id` INT NOT NULL PRIMARY KEY auto_increment,
    `guest_count` INT not NULL,
    `room_count` INT not NULL,
    `total_price` int not NULL,
    `check_in_date` DATE not NULL,
    `check_out_date` DATE not NULL,
    `payment_date` DATE not NULL,
    `booking_id` INT NOT NULL,
    foreign key(`booking_id`) references `booking`(`booking_id`)
);

-- booking 테이블
CREATE TABLE `booking` (
    `booking_id` INT NOT NULL PRIMARY KEY auto_increment,
    `user_id` INT NOT NULL,
    `room_id` INT NOT NULL,
    `payment_date` DATE NOT NULL DEFAULT (curdate()),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
    FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
);


-- room_rate 테이블
CREATE TABLE `room_rate` (
    `roomrate_id` INT NOT NULL PRIMARY KEY auto_increment,
    `room_score` INT NOT NULL DEFAULT 0,
    `comment` VARCHAR(50) NULL,
    `visible` BOOLEAN not NULL default False,
    `room_id` INT NOT NULL,
    FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
);

-- attraction 테이블
CREATE TABLE `attraction` (
    `attraction_id` INT NOT NULL PRIMARY KEY auto_increment,
    `attraction_name` VARCHAR(20) NULL,
    `address` VARCHAR(50) NULL,
    `entrance` BOOLEAN NULL,
    `photo` VARCHAR(255) NULL
);

-- attraction_rate 테이블
CREATE TABLE `attraction_rate` (
    `attractionrate_id` INT NOT NULL PRIMARY KEY auto_increment,
    `attraction_score` INT NOT NULL DEFAULT 0,
    `comment` VARCHAR(50) NULL,
    `attraction_id` INT NOT NULL,
    FOREIGN KEY (`attraction_id`) REFERENCES attraction(`attraction_id`)
);

-- notice 테이블
CREATE TABLE `notice` (
    `notice_id` INT NOT NULL PRIMARY KEY auto_increment,
    `content` VARCHAR(50) NULL,
    `post_date` DATE NULL
);




-- 더미데이터 


-- user 테이블 (3명 삽입)
INSERT INTO user (`name`, `phone`, `email`, `password`, `role`) VALUES
('홍길동', '010-1234-5678', 'hong@example.com', 'pass1234', 'guest'),
('김영희', '010-9876-5432', 'kim@example.com', 'pass5678', 'guest'),
('관리자', '010-5555-5555', 'admin@example.com', 'adminpass', 'admin');

select * from user;

-- room 테이블 (3개 삽입)
INSERT INTO room (`room_number`, `type`, `price`, `capacity`, `size`, `description`) VALUES
('101', 'A', 100000, 2, '20', '바다가 보이는 방'),
('102', 'B', 80000, 4, '25', '가족용 방'),
('103', 'C', 60000, 6, '30', '단체 이용 가능');

select * from room;

-- booking_detail 테이블 (3개 삽입)
INSERT INTO booking_detail (`guest_count`, `room_count`, `total_price`, `check_in_date`, `check_out_date`, `payment_date`, `booking_id`) VALUES
(2, 1, 100000.00, '2024-04-01', '2024-04-03', now(), 1),
(4, 1, 80000.00, '2024-04-05', '2024-04-07', now(), 2),
(6, 1, 60000.00, '2024-04-10', '2024-04-12', now(), 3);


select * from booking where user_id = 1;
select * from booking_detail where booking_id = (1);
select * from booking_detail where booking_id = (4);
select * from booking_detail where booking_id = (6);

-- booking 테이블 (3개 삽입) (user_id와 room_id는 위에 삽입된 데이터를 기반으로 설정)
INSERT INTO booking (`user_id`, `room_id`, `payment_date`) VALUES
(1, 1, CURDATE()),
(2, 2, CURDATE()),
(3, 3, CURDATE());



select * from booking;
-- state 테이블 (3개 삽입) (방이 예약됨을 표시)
commit;



-- room_rate 테이블 (3개 삽입) (방 평가)
INSERT INTO `room_rate` (`room_score`, `comment`, `visible`, `room_id`) VALUES
(5, '깨끗하고 좋아요', TRUE, 1),
(4, '가족이 이용하기 좋음', TRUE, 2),
(6, NULL, TRUE, 3);  

select  * from room_rate;

-- attraction 테이블 (3개 삽입)
INSERT INTO attraction (`attraction_name`, `address`, `entrance`, `photo`) VALUES
('해수욕장', '해변로 123', TRUE, 'beach.jpg'),
('놀이공원', '테마로 456', TRUE, 'themepark.jpg'),
('전통시장', '시장로 789', FALSE, 'market.jpg');

select * from attraction;

-- attraction_rate 테이블 (3개 삽입) (명소 평가)
INSERT INTO `attraction_rate` (`attraction_score`, `comment`, `attraction_id`) VALUES
(5, '바다가 예뻐요!', 1),
(4, '재미있었어요!', 2),
(3, '먹거리가 많아요!', 3);

select * from attraction_rate;

-- notice 테이블에 데이터 삽입 (notice_id는 자동 증가)
INSERT INTO notice (`content`, `post_date`) 
VALUES ('지금 홍수가 났어요', curdate());

select * from notice;






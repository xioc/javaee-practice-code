DROP DATABASE IF EXISTS javaee;
CREATE DATABASE javaee;
USE javaee;
CREATE TABLE news_inf
(
 news_id INT AUTO_INCREMENT PRIMARY KEY,
 news_title VARCHAR(255)
);

INSERT INTO news_inf
VALUES
(NULL, '·è¿ñJavaÁªÃË'),
(NULL, 'crazyit.org');
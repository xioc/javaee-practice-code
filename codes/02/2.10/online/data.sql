DROP DATABASE IF EXISTS online_inf;

CREATE DATABASE online_inf;

USE online_inf;

CREATE TABLE online_inf
(
 session_id VARCHAR(255) PRIMARY KEY,
 username VARCHAR(255),
 user_ip VARCHAR(255),
 access_res VARCHAR(255),
 last_access BIGINT
);

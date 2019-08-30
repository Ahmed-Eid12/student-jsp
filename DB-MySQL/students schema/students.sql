DROP SCHEMA IF EXISTS `students`;

CREATE SCHEMA `students`;

use `students`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) NOT NULL,
  `student_email` varchar(100),
  `dept_id` int NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `EMAIL_UNIQUE` (`student_email`),
  FOREIGN KEY (`dept_id`) REFERENCES `department`(`dept_id`) ON DELETE CASCADE
);

/*
 one to many: Book has many reviews
*/

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dpet_name` varchar(100) NOT NULL,
  PRIMARY KEY (`dept_id`)
);



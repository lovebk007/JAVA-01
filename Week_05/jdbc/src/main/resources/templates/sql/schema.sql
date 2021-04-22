drop schema if exists `test`;
create schema `test`;
use `test`;
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `student_id`   int(10) unsigned NOT NULL AUTO_INCREMENT,
    `student_name` varchar(1024)    NOT NULL,
    `gender`       tinyint(1)       NOT NULL,
    `age`          int(3)           NOT NULL,
    PRIMARY KEY (`student_id`)
)
;
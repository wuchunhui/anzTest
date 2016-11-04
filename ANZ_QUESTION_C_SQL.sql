CREATE TABLE `employee` (
`id`  bigint primary key NOT NULL  auto_increment ,
`first_name`  varchar(32) NOT NULL ,
`last_name`  varchar(32) NOT  NULL ,
`idap_user_name`  varchar(32) NOT NULL ,
`gender`  varchar(6) NULL ,
`birth_DATE`  date NULL ,
`title`  varchar(128)  NOT NULL ,
`grade`  varchar(128) NOT NULL 
)
;

CREATE TABLE `department` (
`id`  bigint primary key NOT NULL  auto_increment ,
`name`  varchar(32) NOT NULL ,
`location`  varchar(32)   NULL ,
`manager`  bigint  NULL ,
`open_positions` int not NULL ,
CONSTRAINT `fk_employee` FOREIGN KEY (`manager`) REFERENCES `employee` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION
)
;
ALTER TABLE `department`
ADD COLUMN `parent_department`  bigint NULL AFTER `open_positions`;
ALTER TABLE `department` ADD CONSTRAINT `fk_department` FOREIGN KEY (`parent_department`) REFERENCES `department` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION;



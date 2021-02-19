CREATE TABLE `User` (
	`id` INT(255) NOT NULL AUTO_INCREMENT,
	`rollno` INT(255) NOT NULL,
	`enrollno` INT(255) NOT NULL,
	`FirstName` VARCHAR(255) NOT NULL,
	`LastName` VARCHAR(255) NOT NULL,
	`Email` VARCHAR(255) NOT NULL,
	`city` VARCHAR(255) NOT NULL,
	UNIQUE KEY `Searchkey` (`rollno`,`enrollno`) USING BTREE,
	PRIMARY KEY (`id`)
);
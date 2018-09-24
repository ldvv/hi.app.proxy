USE iam;

DROP TABLE `USER`;

CREATE TABLE `USER` (
	id VARCHAR (100) PRIMARY KEY,
	`NAME` VARCHAR (100),
	`PASSWORD` VARCHAR (100),
	phone VARCHAR (100),
	email VARCHAR (100),
	sex VARCHAR (100),
	address VARCHAR (100),
	nativePlace VARCHAR (100),
	idCard VARCHAR (100),
	workNumber VARCHAR (100),
	department VARCHAR (100)
);

insert into user values('admin', 'admin', 'huawei@123', '18129934135', '1210754789@qq.com', 'man', '', '', '', 'LD0001', 'TT');
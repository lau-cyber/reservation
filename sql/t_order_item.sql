create table `t_order_item` (
	`id` int (11),
	`oid` int (11),
	`roid` int (11),
	`title` varchar (300),
	`image` varchar (1500),
	`time` double(20, 1),
	`num` int (11),
	`created_user` varchar (60),
	`created_time` datetime ,
	`modified_user` varchar (60),
	`modified_time` datetime 
); 
create table `t_order` (
	`oid` int (11),
	`uid` int (11),
	`recv_name` varchar (60),
	`recv_tel` varchar (60),
	`recv_department` varchar (45),
	`recv_major` varchar (45),
	`recv_grade` varchar (45),
	`recv_details` varchar (150),
	`total_time` double(20, 1),
	`status` int (11),
	`order_time` datetime ,
	`submit_time` datetime ,
	`created_user` varchar (60),
	`created_time` datetime ,
	`modified_user` varchar (60),
	`modified_time` datetime 
); 
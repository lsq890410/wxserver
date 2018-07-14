create table lc_bd_user(
	id int primary key auto_increment,
	skey varchar(100),
	create_time char(19),
	last_visit_time char(19),
	session_key varchar(100),
	appsession varchar(50)
);
